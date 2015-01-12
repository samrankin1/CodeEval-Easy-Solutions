
public class Main {

	public static void main(String[] args) {
		int largestPalindrome = 0;

		for (int i = 2; i < 1000; i++) { // for each number in [2,1000) (exclusive on the upper bound)
			if ((isPalindrome(Integer.toString(i))) && (isPrime(i))) { // if the number is both prime and a palindrome
				largestPalindrome = i; // it is the new largest prime palindrome (since we are counting up)
			}
		}

		System.out.println(largestPalindrome); // print the result
	}

	private static boolean isPrime(int n) {
		if (n == 2) { // 2 is a special case
			return true;
		}

		if ((n % 2) == 0) { // if n is divisible by 2, it is not prime
			return false;
		}

		// if the number is divisible by 2, we only have to check odd numbers up to the square root of n
		for (int i = 3; (i * i) <= n; i += 2) {
			if ((n % i) == 0) {
				return false;
			}
		}

		return true; // if we don't find any factors, the number is prime
	}

	private static boolean isPalindrome(String s) {
		String reversed = new StringBuilder(s).reverse().toString(); // reverse the order of the string's characters
		return s.equals(reversed); // by definition, a palindrome is a string which is equal to its reversed self
	}

}
