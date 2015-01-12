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
			int number = Integer.parseInt(nextLine);
			System.out.println((isEven(number)) ? "1" : "0"); // print 1 if the number is even or 0 is the number is odd
		}

		input.close(); // close the reader to free system resources
	}

	private static boolean isEven(int n) { // determine if an number is even
		return ((n % 2) == 0); // a number is even if it is divisible by 2
	}

}