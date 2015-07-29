package org.insane.codeeval;

/** Prime Palindrome https://www.codeeval.com/open_challenges/3/ */
public class PrimePalindrome {
    public static final int FIRST_PRIME = 2;
    public static final int MAX_NUMBER = 1000;

    public static void main(String[] args) {
        System.out.println(getMaxPrimePalindrome(MAX_NUMBER));
    }

    public static int getMaxPrimePalindrome(int max) {
        int[] primes = primes(max);

        for (int i = primes.length - 1; i >= 0; i--)
            if (isPalindrome(primes[i]))
                return primes[i];

        return FIRST_PRIME;
    }

    public static boolean isPalindrome(int number) {
        int[] digits = getDigits(number);

        for (int i = 0, j = digits.length - 1; i < digits.length / 2; i++, j--)
            if (digits[i] != digits[j])
                return false;

        return true;
    }

    public static int[] getDigits(int number) {
        String numberStr = Integer.toString(number);
        char[] characters = numberStr.toCharArray();
        int[] result = new int[numberStr.length()];

        for (int i = 0; i < result.length; i++)
            result[i] = Character.getNumericValue(characters[i]);

        return result;
    }

    public static int[] primes(int max) {
        boolean[] primes = fill(max - 1, true);

        // for (int number = FIRST_PRIME; number < max; number++) {
        for (int number = FIRST_PRIME; number < (int) Math.sqrt(max); number++) {
            int index = number - FIRST_PRIME;
            if (primes[index])
                // for (int i = index + number; i < primes.length; i += number)
                for (int i = number * number - FIRST_PRIME; i < primes.length; i += number)
                    primes[i] = false;
        }

        int[] result = new int[count(primes, true)];

        for (int i = 0, j = 0; i < primes.length && j < result.length; i++)
            if (primes[i])
                result[j++] = i + FIRST_PRIME;

        return result;
    }

    public static boolean[] fill(int length, boolean value) {
        boolean[] result = new boolean[length];

        for (int i = 0; i < result.length; i++)
            result[i] = value;

        return result;
    }

    public static int count(boolean[] array, boolean value) {
        int result = 0;

        for (boolean item : array)
            if (item == value)
                ++result;

        return result;
    }

}
