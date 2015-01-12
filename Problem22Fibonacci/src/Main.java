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
			int n = Integer.parseInt(nextLine); // parse the input integer N
			System.out.println(fibonacciNthTerm(n)); // print the nth term of the Fibonacci sequence
		}

		input.close(); // close the reader to free system resources
	}

	// Implementation of Binet's Fibonacci Number Formula
	// More information can be found here: http://mathworld.wolfram.com/BinetsFibonacciNumberFormula.html
	private static int fibonacciNthTerm(int n) {
		double phi = (1.0 + Math.sqrt(5));
		double phi2 = (1.0 - Math.sqrt(5));
		return (int) (((Math.pow(phi, n)) - (Math.pow(phi2, n))) / ((Math.pow(2, n)) * (Math.sqrt(5))));
	}
}
