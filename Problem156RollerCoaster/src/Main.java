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
			char[] chars = nextLine.toCharArray(); // split the input into an array of its characters

			StringBuilder result = new StringBuilder(); // create a StringBuilder to store the result as we build it
			boolean nextUpper = true; // stores whether the next character should be uppercased
			for (char c : chars) { // for each character in the string
				if (Character.isAlphabetic(c)) { // if the character is alphabetic
					if (nextUpper) { // if the next character needs to be uppercase
						result.append(Character.toUpperCase(c)); // append the character to the result as uppercase
						nextUpper = false; // the next character needs to be lowercase
					} else { // if the next character needs to be lowercase
						result.append(Character.toLowerCase(c)); // append the character to the result as lowercase
						nextUpper = true; // the next character needs to be uppercase
					}
				} else { // if the character is non-alphabetic
					result.append(c); // append it to the result unchanged
				}
			}

			System.out.println(result.toString()); // print the result
		}

		input.close(); // close the reader to free system resources
	}

}