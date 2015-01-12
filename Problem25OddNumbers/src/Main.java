public class Main {

	public static void main(String[] args) {

		for (int i = 1; i <= 99; i++) { // for every number in [1, 99] (inclusive)
			if (isOdd(i)) { // if the number is odd
				System.out.println(i); // print the odd number
			}
		}

	}

	private static boolean isOdd(int n) {
		return ((n % 2) != 0); // n is odd if it is not divisible by 2
	}

}