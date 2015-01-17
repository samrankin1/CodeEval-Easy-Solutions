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
			String[] lists = nextLine.split("\\|"); // since the input is two lists separated by a | (escaped), split the line into two lists
			String[] list1 = lists[0].trim().split(" "); // take the first list and split it into an array of number strings
			String[] list2 = lists[1].trim().split(" "); // take the second list and split it into an array of number strings

			ArrayList<Integer> results = new ArrayList<Integer>(list1.length); // create an ArrayList of integers to store the multiplied list

			for (int i = 0; i < list1.length; i++) { // for each index in list1
				int number1 = Integer.parseInt(list1[i]); // parse the integer at the index in list1
				int number2 = Integer.parseInt(list2[i]); // parse the integer at the index in list2
				int result = number1 * number2; // multiply the numbers
				results.add(result); // add the result to the multiplied list
			}

			System.out.println(join(results, " ")); // print the multiplied list, separated by spaces
		}

		input.close(); // close the reader to free system resources
	}

	private static String join(List<?> list, String separator) {
		Iterator<?> iterator = list.iterator();

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
