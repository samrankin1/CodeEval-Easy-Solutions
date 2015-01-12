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
			String[] points = nextLine.split("\\) \\("); // the input consists of two parenthetical points, split each point into its own element in an array (ex. {"(1, 2", "3, 4)"})
			String[] point1 = points[0].split(", "); // ex. {"(1", "2"}
			String[] point2 = points[1].split(", "); // ex. {"3", "4)"}

			// parse the integers in the points, using StringBuilders to remove leftover parentheses
			int x1 = Integer.parseInt(new StringBuilder(point1[0]).substring(1));
			int y1 = Integer.parseInt(point1[1]);
			int x2 = Integer.parseInt(point2[0]);

			StringBuilder y2Builder = new StringBuilder(point2[1]);
			y2Builder.setLength(y2Builder.length() - 1);
			int y2 = Integer.parseInt(y2Builder.toString());

			int result = (int) getDistance(x1, y1, x2, y2); // calculate the distance, do not round the result
			System.out.println(result); // print the result
		}

		input.close(); // close the reader to free system resources
	}

	// implementation of the Distance Formula
	// more information can be found here: http://mathworld.wolfram.com/Distance.html
	private static double getDistance(double x1, double y1, double x2, double y2) {
		return Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
	}

}