package org.insane.codeeval.moderate;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/** Counting Primes https://www.codeeval.com/open_challenges/63/ */
public class CountingPrimes {
    public static final int FIRST_PRIME = 2;
    public static final String SEPARATOR = ",";

    public static void main(String[] args) throws FileNotFoundException {
        for (String line : readLines(args[0])) {
            int[] parsed = parse(line);
            int min = parsed[0];
            int max = parsed[1];

            System.out.println(getPrimesCount(min, max));
        }
    }

    public static boolean isPrime(int number) {
        if (number == FIRST_PRIME)
            return true;

        for (int i = FIRST_PRIME; i < number; i++)
            if (number % i == 0)
                return false;

        return true;
    }

    public static int getPrimesCount(int min, int max) {
        int result = 0;

        for (int i = min; i <= max; i++)
            if (isPrime(i))
                ++result;

        return result;
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

    public static int[] parse(String line) {
        String[] parts = line.split(SEPARATOR);
        int[] result = new int[parts.length];

        for (int i = 0; i < result.length; i++)
            result[i] = Integer.parseInt(parts[i]);

        return result;
    }

}
