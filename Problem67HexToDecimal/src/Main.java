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
			int result = Integer.parseInt(nextLine, 16); // parse the hex string to a decimal integer (the 16 argument means that the input is base-16, aka hexadecimal)
			System.out.println(result); // print the resulting integer
		}

		input.close(); // close the reader to free system resources
	}

}