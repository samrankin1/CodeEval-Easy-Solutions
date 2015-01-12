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
			String[] words = nextLine.split(" "); // since the input is a list of words separated by spaces, split the line into an array of words

			String longestWord = ""; // stores the current longest word
			for (String word : words) { // for each word in the sentence
				if (word.length() > longestWord.length()) { // if the word is longer than the current longest word
					longestWord = word; // this word is the new longest word
				}
			}

			System.out.println(longestWord); // print the result
		}

		input.close(); // close the reader to free system resources
	}

}