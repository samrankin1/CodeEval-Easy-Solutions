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

			String[] splitInput = nextLine.split(","); // since the input is two integers separated by a comma, split the line into an array containing the integers
			int x = Integer.parseInt(splitInput[0]); // the first string in the array contains X
			int n = Integer.parseInt(splitInput[1]); // the second string in the array contains N

			int multipleN = n; // start with the first multiple of N, itself
			while (multipleN < x) { // until the multiple of N is greater than or equal to X
				multipleN += n; // set multipleN to the next multiple of N
			}

			System.out.println(multipleN);
		}

		input.close(); // close the reader to free system resources
	}

}
