import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException {
		File inputFile = new File(args[0]); // the first argument will be the path to a file

		BufferedReader input = new BufferedReader(new FileReader(inputFile)); // create a BufferedReader to read the input from the given file

		String nextLine = null;
		while ((nextLine = input.readLine()) != null) { // run until there are no more lines of input
			String[] rawNumbers = nextLine.split(" "); // since the input is a list of numbers separated by spaces, split the line into an array of the numbers

			ArrayList<Double> numbers = new ArrayList<Double>(); // create a list to store the unformatted numbers
			for (String rawNumber : rawNumbers) { // for each number string in the list
				numbers.add(Double.parseDouble(rawNumber)); // parse the double and add it to the list
			}

			Collections.sort(numbers); // sort the numbers in ascending order

			DecimalFormat format = new DecimalFormat("0.000"); // decimal format with three fixed digits
			format.setRoundingMode(RoundingMode.DOWN); // always round down

			ArrayList<String> formattedNumbers = new ArrayList<String>(numbers.size()); // create a list to store the formatted numbers
			for (double d : numbers) { // for each number
				formattedNumbers.add(format.format(d)); // format the number and add it to the list
			}

			System.out.println(join(formattedNumbers, " ")); // print each formatted number, separated by spaces
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