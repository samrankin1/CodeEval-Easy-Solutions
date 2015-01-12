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
			char[] digits = nextLine.toCharArray(); // since each character in the input line is a digit we need to add up, place them all into an array

			int total = 0; // here we will store the running total of the digits
			for (char c : digits) {
				total += Integer.parseInt(String.valueOf(c)); // convert the character to a string, then to an integer, and add it to the total
			}

			System.out.println(total); // print the total
		}

		input.close(); // close the reader to free system resources
	}

}
