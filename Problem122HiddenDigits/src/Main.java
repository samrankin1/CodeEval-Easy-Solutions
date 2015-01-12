import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		File inputFile = new File(args[0]); // the first argument will be the path to a file

		BufferedReader input = new BufferedReader(new FileReader(inputFile)); // create a BufferedReader to read the input from the given file

		String nextLine = null;
		while ((nextLine = input.readLine()) != null) { // run until there are no more lines of input
			char[] chars = nextLine.toCharArray(); // split the input line into an array of characters

			StringBuilder result = new StringBuilder(); // create a new StringBuilder to store the result as we build it
			for (char c : chars) { // for each character in the input
				if (Character.isDigit(c)) { // if the character is a "visible digit"
					result.append(c); // append the digit to the result
					continue; // no need to check if it's a "hidden digit"
				}

				switch(c) { // if the character is a "hidden digit", append its digit value to the result
				case 'a':
					result.append(0);
					break;
				case 'b':
					result.append(1);
					break;
				case 'c':
					result.append(2);
					break;
				case 'd':
					result.append(3);
					break;
				case 'e':
					result.append(4);
					break;
				case 'f':
					result.append(5);
					break;
				case 'g':
					result.append(6);
					break;
				case 'h':
					result.append(7);
					break;
				case 'i':
					result.append(8);
					break;
				case 'j':
					result.append(9);
					break;
				}
			}

			if (result.toString().isEmpty()) { // if the result is empty
				System.out.println("NONE"); // print "NONE"
			} else { // if the result isn't empty
				System.out.println(result.toString()); // print the result
			}
		}

		input.close(); // close the reader to free system resources
	}

}