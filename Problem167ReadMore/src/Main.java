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

			if (nextLine.length() > 55) { // if the input string is longer than 55 characters, it needs to be modified
				StringBuilder result = new StringBuilder(nextLine); // create a new StringBuilder based on the input line
				result.setLength(40); // set the length of the string to 40

				if (result.toString().contains(" ")) { // if the string contains any spaces
					while (true) { // loop until we're done
						char lastChar = result.charAt(result.length() - 1); // get the last character in the string
						if (lastChar == ' ') { // if the last character is a space, we've found the last character we need to remove
							result.setLength(result.length() - 1); // remove the last character from the string
							break; // stop looping so we don't destroy the whole string
						} else { // if the last character isn't a space
							result.setLength(result.length() - 1); // remove it and keep going
						}
					}
				}

				result.append("... <Read More>"); // append the "read more" text
				System.out.println(result.toString()); // print the resulting string

			} else { // if the input string is shorter than or equal to 55 characters, print the string as-is
				System.out.println(nextLine); // print the string without any modifications
			}

		}

		input.close(); // close the reader to free system resources
	}
}
