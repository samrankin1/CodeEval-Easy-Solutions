import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException {
		File inputFile = new File(args[0]); // the first argument will be the path to a file

		BufferedReader input = new BufferedReader(new FileReader(inputFile)); // create a BufferedReader to read the input from the given file

		String nextLine = null;
		while ((nextLine = input.readLine()) != null) { // run until there are no more lines of input
			String[] inputParts = nextLine.split(";"); // since the input consists of two lists separated by a semicolon, split the line into two lists
			String[] wordArray = inputParts[0].split(" "); // the first string in the array is the list of words separated by spaces
			String[] locationArray = inputParts[1].split(" "); // the second string in the array is the list of locations separated by spaces

			String[] unscrambledWords = new String[wordArray.length]; // this array will store the unscrambled sentence

			for (int i = 0; i < (wordArray.length - 1); i++) { // for each index in wordArray except for the last one
				String word = wordArray[i]; // get the word at this index
				int newIndex = Integer.parseInt(locationArray[i]) - 1; // get its original location from locationArray, subtract 1 to make it a zero-based numbering system

				unscrambledWords[newIndex] = word; // put the word at its original location
			}

			// at this point, there will be one more word to place and one more location which is empty in unscrambledWords because its location is not in locationArray

			for (int i = 0; i < unscrambledWords.length; i++) { // for each index in unscrambledWords
				if (unscrambledWords[i] == null) { // if the last missing word is supposed to be at this index
					unscrambledWords[i] = wordArray[wordArray.length - 1]; // put the last word in wordList at this index
					break; // no need to search anymore
				}
			}

			System.out.println(join(Arrays.asList(unscrambledWords), " ")); // print the unscrambled array, placing spaces between the words
		}

		input.close(); // close the reader to free system resources
	}

	private static String join(List<String> list, String separator) {
		Iterator<String> iterator = list.iterator();

		if (!iterator.hasNext()) { // if the list is empty
			return ""; // return an empty string
		}

		StringBuilder result = new StringBuilder(); // store the result string as we build it

		result.append(iterator.next()); // add the first result

		while (iterator.hasNext()) { // while there are still elements to add
			result.append(separator); // add the separator
			result.append(iterator.next()); // then add the next element
		}

		return result.toString(); // return the resultant string
	}

}
