
public class Main {

	public static void main(String[] args) {
		for (int i = 1; i <= 12; i++) { // for each of 12 rows (fixed)
			System.out.println(generateTableRow(i)); // generate and print row n
		}
	}

	// Generate the nth line of the multiplication table
	private static String generateTableRow(int n) {
		StringBuilder result = new StringBuilder(); // create a StringBuilder to store the row as we generate it

		for (int i = 1; i <= 12; i++) { // for each number in [1, 12] (inclusive), representing the columns
			int thisEntry = (n * i); // each column in the row's value is n*i
			result.append(String.format("%4d", thisEntry)); // add this column's value and the correct number of spaces
		}

		return result.toString().trim(); // return the result, removing trailing spaces
	}


}
