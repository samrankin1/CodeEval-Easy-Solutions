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
			int number = Integer.parseInt(nextLine); // parse the input integer

			int armstrongTotal = 0; // store the total as we calculate it
			for (char c : nextLine.toCharArray()) { // for each digit in the input integer
				int digit = Integer.parseInt(String.valueOf(c)); // parse the digit as an integer
				armstrongTotal += Math.pow(digit, nextLine.length()); // raise the digit to the nth power, where n is the length of the input number, and add it to the total
			}

			System.out.println((number == armstrongTotal) ? "True" : "False"); // print "True" if the number is equal to the Armstrong total, or "False" if it is not
		}

		input.close(); // close the reader to free system resources
	}

}