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

			String[] splitInput = nextLine.split(","); // since the input is two strings split by a comma, split the line at the comma
			String string = splitInput[0]; // the first element in the array is the string we're searching in
			String search = splitInput[1]; // the second element in the array is the string we're searching for

			System.out.println(string.lastIndexOf(search)); // print the index of the last occurrence of the search string
		}

		input.close(); // close the reader to free system resources
	}

}
