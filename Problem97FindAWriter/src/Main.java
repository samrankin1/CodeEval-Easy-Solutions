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
			String[] splitInput = nextLine.split("\\| "); // split the input line at the "| "
			String encrypted = splitInput[0]; // the first element in the array is the encrypted name
			String[] locations = splitInput[1].split(" "); // the second element in the array is a list of locations separated by spaces, split it into an array of locations

			StringBuilder result = new StringBuilder(); // create a StringBuilder to store the name as we build it
			for (String location : locations) {
				int loc = Integer.parseInt(location) - 1; // parse the location integer and change it to a zero-based numbering system
				result.append(encrypted.charAt(loc)); // append the character at the location in the encrypted string
			}

			System.out.println(result.toString()); // print the result
		}

		input.close(); // close the reader to free system resources
	}

}