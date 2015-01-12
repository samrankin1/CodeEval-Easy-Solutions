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
			String[] words = nextLine.split(";"); // since the input is a list of words separated by semicolons, split the line into an array of the words

			StringBuilder result = new StringBuilder(); // create a StringBuilder to store the result as we build it
			for (String word : words) { // for each word of input
				// depending on which number the word represents, append the corresponding digit to the result
				switch (word) {
				case "zero":
					result.append(0);
					break;
				case "one":
					result.append(1);
					break;
				case "two":
					result.append(2);
					break;
				case "three":
					result.append(3);
					break;
				case "four":
					result.append(4);
					break;
				case "five":
					result.append(5);
					break;
				case "six":
					result.append(6);
					break;
				case "seven":
					result.append(7);
					break;
				case "eight":
					result.append(8);
					break;
				case "nine":
					result.append(9);
					break;
				}
			}

			System.out.println(result.toString()); // print the result
		}

		input.close(); // close the reader to free system resources
	}

}