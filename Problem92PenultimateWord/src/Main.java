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
			String[] words = nextLine.split(" "); // since the input is a list of words separated by spaces, split the line into an array
			System.out.println(words[words.length - 2]); // print the second to last word in the array (this is safe because there will always be at least 2 words)
		}

		input.close(); // close the reader to free system resources
	}

}
