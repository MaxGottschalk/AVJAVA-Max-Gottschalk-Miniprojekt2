package controller;

import java.util.ArrayList;

public class PrimeNumbers {

	/**
	 * Generates a list of prime numbers up to the given number.
	 * 
	 * @param number The upper limit up to which prime numbers are generated.
	 * @return An ArrayList containing prime numbers up to the given number.
	 */
    public ArrayList<Integer> generatePrimeNumbers(int number) {
        // If number is less than 2 there are no prime numbers to find, returning an empty list.
        if (number < 2) {
            return new ArrayList<>();
        } else {
            ArrayList<Integer> primesList = new ArrayList<>();
            
            generatePrimesRecursive(2, number, primesList);
            return primesList;
        }
    }

    /**
     * Recursively finds prime numbers in the given range.
     * 
     * @param current The current number being evaluated.
     * @param number  The upper limit of the range to find prime numbers.
     * @param primes  The list to store the prime numbers found.
     */
    private void generatePrimesRecursive(int current, int number, ArrayList<Integer> primes) {
        // If current exceeds number, terminate the recursion.
        if (current > number) {
            return;
        }
        if (isPrime(current)) {
            primes.add(current);
        }
        // Recur with the next number.
        generatePrimesRecursive(current + 1, number, primes);
    }

    /**
     * Method to check if the given number is a prime
     * @param number is the amount of numbers being checked
     * @return If true it is a prime
     */
    private boolean isPrime(int number) {
        if (number <= 3) {
            return true;
        }
        if (number % 2 == 0 || number % 3 == 0) {
            return false;
        }
        for (int i = 5; i * i <= number; i += 6) {
            if (number % i == 0 || number % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }
}

