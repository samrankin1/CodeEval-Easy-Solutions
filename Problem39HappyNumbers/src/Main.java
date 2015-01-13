import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws IOException {
		File inputFile = new File(args[0]); // the first argument will be the path to a file

		BufferedReader input = new BufferedReader(new FileReader(inputFile)); // create a BufferedReader to read the input from the given file

		String nextLine = null;
		while ((nextLine = input.readLine()) != null) { // run until there are no more lines of input
			int currentNumber = Integer.parseInt(nextLine);

			ArrayList<Integer> sequence = new ArrayList<Integer>(); // make an ArrayList to store integers already in the sequence
			sequence.add(currentNumber); // add the first number to the sequence
			while (true) { // repeat until broken
				String numberString = Integer.toString(currentNumber); // convert the current number to a String
				char[] digits = numberString.toCharArray(); // place each digit in the number string into a char array

				int total = 0; // store the total of the squared digits as we calculate it
				for (char digit : digits) { // for a each digit in the array
					int thisDigit = Integer.parseInt(Character.toString(digit)); // parse the digit to an integer
					int squaredDigit = thisDigit * thisDigit; // square the number
					total += squaredDigit; // add the result to the total
				}

				// System.out.println(total); // debug

				if (total == 1) { // if the total is 1
					System.out.println("1"); // this is a happy number
					break; // break the loop, continuing to the next case
				}

				if (sequence.contains(total)) { // if the sequence already contains this total
					System.out.println("0"); // this is not a happy number because the sequence will now repeat itself infinitely without reaching 1
					break; // break the loop, continuing to the next case
				}

				sequence.add(total); // add this total to the sequence

				currentNumber = total; // set the current number to be this total
			}
		}

		input.close(); // close the reader to free system resources
	}
}
