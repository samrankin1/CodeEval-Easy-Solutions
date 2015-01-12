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
			char[] chars = nextLine.toCharArray(); // split the input line into an array of its characters

			StringBuilder result = new StringBuilder(); // create a StringBuilder to store the result while we build it
			for (char c : chars) {
				if (!Character.isAlphabetic(c)) { // if the character is not alphabetic
					result.append(c); // append it to the result unchanged
					continue;
				}

				if (Character.isUpperCase(c)) { // if the character is uppercase
					result.append(Character.toLowerCase(c)); // append it to the result as lowercase
					continue;
				}

				if (Character.isLowerCase(c)) { // if the character is lowercase
					result.append(Character.toUpperCase(c)); // append it to the result as uppercase
					continue;
				}

				result.append(c); // fail-safe, if the character someone isn't alphabetic or uppercase or lowercase, append it to the result unchanged instead of ignoring it completely
			}

			System.out.println(result.toString()); // print the result
		}

		input.close(); // close the reader to free system resources
	}

}