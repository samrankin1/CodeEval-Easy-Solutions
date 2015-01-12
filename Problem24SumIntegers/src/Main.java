import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		File inputFile = new File(args[0]); // the first argument will be the path to a file

		BufferedReader input = new BufferedReader(new FileReader(inputFile)); // create a BufferedReader to read the input from the given file

		int total = 0; // here we store the running total of the integers as we read them

		String nextLine = null;
		while ((nextLine = input.readLine()) != null) { // run until there are no more lines of input
			total += Integer.parseInt(nextLine); // parse the integer on the input line and add it to the total
		}

		System.out.println(total); // print the total

		input.close(); // close the reader to free system resources
	}

}
