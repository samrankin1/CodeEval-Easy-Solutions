
public class Main {

	public static void main(String[] args) {

		int sum = 0; // this is the sum of the primes we have found so far
		int currentNumber = 2; // this is the number that we will be checking from primality
		int primesFound = 0; // this is the number of the primes we have found so far

		while (primesFound < 1000) { // until we have found 1000 primes
			if (isPrime(currentNumber)) { // if the current number is prime
				sum += currentNumber; // add it to the sum
				primesFound++; // add it to the count of primes found
			}

			currentNumber++; // always increase the current number by 1
		}

		System.out.println(sum); // print the result after we've found 1000 primes

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
}
