package org.insane.codeeval.easy;

import java.util.Arrays;

/** Sum of Primes https://www.codeeval.com/open_challenges/4/ */
public class SumOfPrimes {
    public static final int FIRST_PRIME = 2;
    public static final int COUNT = 1000;

    public static void main(String[] args) {
        System.out.println(sumOfPrimes(COUNT));
    }

    public static int sumOfPrimes(int count) {
        return sum(getFirstPrimes(count));
    }

    public static int getEstimation(int count) {
        double countLog = Math.log(count);
        return (int) (count * (countLog + Math.log(countLog)));
    }

    public static int[] getFirstPrimes(int count) {
        int[] primes = getPrimesLower(getEstimation(count));

        return Arrays.copyOfRange(primes, 0, count);
    }

    public static int[] getPrimesLower(int max) {
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

    public static int sum(int[] array) {
        int result = 0;

        for (int item : array)
            result += item;

        return result;
    }

}
