import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class Main {

	public static void main(String[] args) throws IOException {
		File inputFile = new File(args[0]); // the first argument will be the path to a file

		BufferedReader input = new BufferedReader(new FileReader(inputFile)); // create a BufferedReader to read the input from the given file

		String nextLine = null;
		while ((nextLine = input.readLine()) != null) { // run until there are no more lines of input
			if (nextLine.isEmpty()) // ignore empty input lines
				continue;

			List<String> wordList = Arrays.asList(nextLine.split(" ")); // split the input sentence into words
			Collections.reverse(wordList); // reverse the order of the list

			StringBuilder result = new StringBuilder(); // store the reversed sentence as we build it

			for (String word : wordList) { // for each word in the reversed list
				result.append(word + " "); // add the word and a space to the result
			}

			System.out.println(result.toString().trim()); // print the reversed sentence, removing trailing spaces
		}

		input.close(); // close the reader to free system resources
	}

}
