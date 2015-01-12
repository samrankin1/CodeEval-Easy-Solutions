import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;

public class Main {

	public static void main(String[] args) throws IOException {
		File inputFile = new File(args[0]); // the first argument will be the path to a file

		BufferedReader input = new BufferedReader(new FileReader(inputFile)); // create a BufferedReader to read the input from the given file

		String nextLine = null;
		while ((nextLine = input.readLine()) != null) { // run until there are no more lines of input
			char[] chars = nextLine.toCharArray(); // split the input into an array of its characters

			int upperCount = 0; // store the uppercase letter count
			int lowerCount = 0; // store the lowercase letter count
			for (char c : chars) { // for each character in the input
				if (Character.isUpperCase(c)) { // if the character is uppercase
					upperCount++; // count it
				}

				if (Character.isLowerCase(c)) { // if the character is lowercase
					lowerCount++; // count it
				}
			}

			double lowerPercent = ((double) lowerCount) / ((double) chars.length) * 100.0; // calculate the percentage of lowercase letters
			double upperPercent = ((double) upperCount) / ((double) chars.length) * 100.0; // calculate the percentage of uppercase letters

			DecimalFormat format = new DecimalFormat("0.00"); // decimal format with two fixed digits

			System.out.println("lowercase: " + format.format(lowerPercent) + " uppercase: " + format.format(upperPercent));
		}

		input.close(); // close the reader to free system resources
	}

}