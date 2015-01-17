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
		cases:
			while ((nextLine = input.readLine()) != null) { // run until there are no more lines of input
				String[] rawNumbers = nextLine.split(","); // since the input is a list of integers separated by commas, split the input string into an array of string integers

				ArrayList<Integer> numbers = new ArrayList<Integer>(); // create a new ArrayList to store the parsed integers
				for (String number : rawNumbers) { // for each string integer in the array
					numbers.add(Integer.parseInt(number)); // parse the integer and add it to the array
				}

				Collections.sort(numbers); // sort the array so that all numbers that are the same will be together

				int currentNumber = -1; // this is -1 so that the currentNumber will be set on the first iteration
				int currentCount = -1; // this will be set on the first iteration as well

				for (Integer number : numbers) { // for each number in the sorted array

					if (number == currentNumber) { // if the number is the current number
						currentCount++; // add to the current count

						if (currentCount > (numbers.size() / 2)) { // if this number's count is now greater than half the size of the array
							System.out.println(currentNumber); // this number is the major element
							continue cases; // continue to the next case
						}

					} else { // if this is a new number
						currentNumber = number; // this new number is now the current number
						currentCount = 1; // the count is reset to 1
					}
				}

				System.out.println("None"); // no major element was found
			}

		input.close(); // close the reader to free system resources
	}

}
