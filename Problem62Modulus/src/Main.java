import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		File inputFile = new File(args[0]); // the first argument will be the path to a file

		BufferedReader input = new BufferedReader(new FileReader(inputFile)); // create a BufferedReader to read the input from the given file

		String nextLine = null;
		while ((nextLine = input.readLine()) != null) { // run until there are no more lines of input

			String[] integers = nextLine.split(","); // since the input is two integers separated by a comma, split the string into the two integers
			int n = Integer.parseInt(integers[0]); // the first string in the array is N
			int m = Integer.parseInt(integers[1]); // the second string in the array is M

			System.out.println(modulus(n, m)); // print n modulus m

		}

		input.close(); // close the reader to free system resources
	}

	private static int modulus(int n, int m) {
		double divided = (double) n / (double) m; // divide the numbers as doubles
		double remainder = divided - Math.floor(divided); // get the remainder
		return (int) Math.round(remainder * m); // multiply the remainder back by the m, round to avoid error
	}

}
