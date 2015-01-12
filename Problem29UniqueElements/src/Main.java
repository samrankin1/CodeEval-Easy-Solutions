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

			String[] elements = nextLine.split(","); // since the input is a list of integers separated by commas, split the string and place them in an array

			ArrayList<String> uniqueElements = new ArrayList<String>(); // create an ArrayList to store the unique elements
			for (String e : elements) { // for each element from the input line
				if (!uniqueElements.contains(e)) { // if the uniqueElements list doesn't already contain e
					uniqueElements.add(e); // add e to the list of unique elements
				}
			}

			System.out.println(join(uniqueElements, ",")); // print the list of unique elements, separated by commas
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
