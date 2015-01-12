import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException {
		File inputFile = new File(args[0]); // the first argument will be the path to a file

		BufferedReader input = new BufferedReader(new FileReader(inputFile)); // create a BufferedReader to read the input from the given file

		String nextLine = null;
		while ((nextLine = input.readLine()) != null) { // run until there are no more lines of input

			List<String> numbers = Arrays.asList(nextLine.split(" ")); // since the input is a list of integers separated by spaces, split the string and place them in an array, then convert it to a list

			ArrayList<Integer> uniqueNumbers = new ArrayList<Integer>(); // create an ArrayList to store the unique numbers
			for (String n : numbers) { // for each number from the input line
				List<String> clonedNumbers = new ArrayList<String>(numbers.size()); // make an empty array with the same size as numbers
				clonedNumbers.addAll(numbers); // copy the elements of numbers into the new list, cloning the list
				clonedNumbers.remove(n); // remove the number we're looking at

				if (!clonedNumbers.contains(n)) { // if the clonedNumbers list no longer contains the number we just removed, there is only one instance of it and it is therefore unique
					uniqueNumbers.add(Integer.parseInt(n)); // add the number to the list of unique numbers as an integer
				}
			}

			Collections.sort(uniqueNumbers); // sort the list of unique numbers in ascending order

			if (uniqueNumbers.isEmpty()) {
				System.out.println("0"); // if there are no unique numbers, print "0"
			} else {
				int winningNumber = uniqueNumbers.get(0); // the lowest unique number is the first number in the sorted list
				int winningPlayer = numbers.indexOf(String.valueOf(winningNumber)) + 1; // find the index of the winning number, then add 1 to make it a 1-based numbering system
				System.out.println(winningPlayer); // print the position of the winning player
			}
		}

		input.close(); // close the reader to free system resources
	}

}
