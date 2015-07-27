package org.insane.codeeval;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/** Prime Numbers https://www.codeeval.com/open_challenges/46/ */
public class PrimeNumbers {
    public static final int FIRST_PRIME = 2;
    public static final String SEPARATOR = ",";

    public static void main(String[] args) throws FileNotFoundException {
        for (String arg : readLines(args[0]))
            System.out.println(join(SEPARATOR, primes(Integer.parseInt(arg))));
    }

    public static List<String> readLines(File file) throws FileNotFoundException {
        List<String> result = new ArrayList<>();

        try (Scanner input = new Scanner(file)) {
            while (input.hasNextLine())
                result.add(input.nextLine());
        }

        return result;
    }

    public static List<String> readLines(String path) throws FileNotFoundException {
        return readLines(new File(path));
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

    public static int sum(int[] array) {
        int result = 0;

        for (int item : array)
            result += item;

        return result;
    }

    public static String join(String separator, int[] array) {
        StringBuilder result = new StringBuilder();

        result.append(array[0]);
        for (int i = 1; i < array.length; i++) {
            result.append(separator);
            result.append(array[i]);
        }

        return result.toString().trim();
    }

}
