import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException {
		File inputFile = new File(args[0]); // the first argument will be the path to a file

		BufferedReader input = new BufferedReader(new FileReader(inputFile)); // create a BufferedReader to read the input from the given file

		String nextLine = null;
		while ((nextLine = input.readLine()) != null) { // run until there are no more lines of input

			String[] lists = nextLine.split(";"); // since the input line is two lists separated by a semicolon, split the string into the two lists
			List<String> list1 = Arrays.asList(lists[0].split(",")); // the first element is the first list, split it into an array of its elements, then convert it to a list
			List<String> list2 = Arrays.asList(lists[1].split(",")); // the second element is the second list, split it into an array of its elements, then convert it to a list

			ArrayList<String> intersection = new ArrayList<String>(); // create an ArrayList to store the intersections we find

			for (String e : list1) { // for every element is list1
				if (list2.contains(e)) { // if it is also in list2, it is an intersection
					intersection.add(e); // add it to the list of intersections
				}
			}

			System.out.println(join(intersection, ",")); // print the list of intersections, separated by commas
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
