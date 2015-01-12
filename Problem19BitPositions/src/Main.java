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

			String[] splitInput = nextLine.split(","); // since the input is three integers separated by commas, split the line into an array containing the integers
			int n = Integer.parseInt(splitInput[0]); // the first string in the array contains N
			int p1 = Integer.parseInt(splitInput[1]); // the second string in the array contains P1
			int p2 = Integer.parseInt(splitInput[2]); // the second string in the array contains P2

			System.out.println(getBitAtPos(n, p1) == getBitAtPos(n, p2)); // print if the bit at p1 in n is the same as the bit at p2 in n
		}

		input.close(); // close the reader to free system resources
	}

	public static int getBitAtPos(int n, int pos) {
		return (((n >> (pos - 1)) & 1)); // shift n to the right (pos - 1) times, then use & to check if it is set (the subtraction of 1 account for the 0 place)
	}

}
