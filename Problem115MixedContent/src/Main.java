import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException {
		File inputFile = new File(args[0]); // the first argument will be the path to a file

		BufferedReader input = new BufferedReader(new FileReader(inputFile)); // create a BufferedReader to read the input from the given file

		String nextLine = null;
		while ((nextLine = input.readLine()) != null) { // run until there are no more lines of input
			String[] elements = nextLine.split(","); // since the input string is a list of elements separated by commas, split the input into an array of its elements

			ArrayList<String> words = new ArrayList<String>(); // create a new ArrayList to store the words we find
			ArrayList<String> numbers = new ArrayList<String>(); // create a new ArrayList to store the numbers we find

			for (String element : elements) { // for each element in the array
				if (isNumber(element)) { // if the element is a number
					numbers.add(element); // add it to the number list
				} else { // otherwise, the element is a word
					words.add(element); // add it to the word list
				}
			}

			if (words.isEmpty()) { // if no words were found
				System.out.println(join(numbers, ",")); // print only numbers
			} else if (numbers.isEmpty()) { // else if no numbers were found
				System.out.println(join(words, ",")); // print only words
			} else { // if there are elements in both lists
				System.out.println(join(words, ",") + "|" + join(numbers, ",")); // create the output string, which consists of both lists separated by commas, separated by a pipe symbol
			}
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

	private static boolean isNumber(String string) { // returns whether the string argument is a valid integer
		try {
			Integer.parseInt(string); // attempt to parse the string as an integer
		} catch (NumberFormatException e) { // if the string can't be parsed, catch the exception
			return false; // the string is not an integer
		}

		return true; // if an exception wasn't thrown, the string is an integer
	}
}
