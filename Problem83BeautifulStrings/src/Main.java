import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

	public static void main(String[] args) throws IOException {
		File inputFile = new File(args[0]); // the first argument will be the path to a file

		BufferedReader input = new BufferedReader(new FileReader(inputFile)); // create a BufferedReader to read the input from the given file

		String nextLine = null;
		while ((nextLine = input.readLine()) != null) { // run until there are no more lines of input
			String phrase = nextLine.toLowerCase(); // since case doesn't matter, lets make it all lowercase for convenience

			ArrayList<Integer> charCounts = new ArrayList<Integer>(); // this list will store the occurrences of each letter (which letter was actually is counted is irrelevant)

			for (char c = 'a'; c <= 'z'; c++) { // for each letter of the alphabet
				charCounts.add(countOccurrences(phrase, c)); // add the count of this character to the list of counts
			}

			Collections.sort(charCounts, Collections.reverseOrder()); // sort the list in descending order so that the most common letters are given the highest beauty values

			int totalBeauty = 0; // stores the total maximum beauty of the string as we add it up
			int currentBeauty = 26; // stores the current beauty of the letters as we iterate through them
			for (Integer i : charCounts) { // for each frequency of letter in the phrase (most frequent first)
				totalBeauty += (currentBeauty * i); // the most common letters are assigned the highest beauty values (this maximizes the beauty of the phrase)
				currentBeauty--; // the next letter must have 1 less beauty
			}

			System.out.println(totalBeauty); // print the result
		}

		input.close(); // close the reader to free system resources
	}

	private static int countOccurrences(String string, char search) { // count the occurrences of a particular character in a string

		int count = 0; // store the count of occurrences

		for (char c : string.toCharArray()) { // for each character in the string
			if (c == search) { // if the character is the one we're looking for
				count++; // count it
			}
		}

		return count; // return the count
	}

}