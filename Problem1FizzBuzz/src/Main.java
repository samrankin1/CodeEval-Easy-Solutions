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

			// read the input variables
			String[] inputVariables = nextLine.split(" "); // read the input line with three integers and split it by the space, resulting in an array of this format: {"X", "Y", "Z"}
			int fizzDivisor	 = Integer.parseInt(inputVariables[0]); // the first string in the array contains X
			int buzzDivisor	 = Integer.parseInt(inputVariables[1]); // the second string in the array contains Y
			int count		 = Integer.parseInt(inputVariables[2]); // the third string in the array contains Z

			StringBuilder result = new StringBuilder(); // here is where we build the result string
			for (int i = 1; i <= count; i++) { // for numbers [1, count] (inclusive)
				boolean foundDivisor = false; // this keeps track of if we've found a divisor so that we don't add the actual number if we have

				if (divisibleBy(i, fizzDivisor)) { // if i is divisible by the fizz divisor
					result.append("F"); // add F to the end of the result
					foundDivisor = true; // record that we've found a divisor
				}

				if (divisibleBy(i, buzzDivisor)) { // if i is divisible by the buzz divisor
					result.append("B"); // add B to the end of the result
					foundDivisor = true; // record that we've found a divisor
				}

				if (!foundDivisor) { // only add the number to the end of the string if we didn't find a divisor
					result.append(i); // add the number
				}

				result.append(' '); // add a trailing space after each sub-result
			}

			System.out.println(result.toString().trim()); // print the result as a string, removing any trailing spaces

		}

		input.close(); // close the reader to free system resources
	}

	private static boolean divisibleBy(int a, int b) {
		return ((a % b) == 0); // if the remainder of a divided by b is zero, a is divisible by b
	}
}
