package org.insane.codeeval.easy;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/** String Mask https://www.codeeval.com/open_challenges/199/ */
public class StringMask {

    public static void main(String[] args) throws FileNotFoundException {
        List<String> lines = readLines(new File(args[0]));

        for (String line : lines) {
            String[] parts = line.split(" ");
            System.out.println(apply(parts[0], parts[1]));
        }
    }

    public static List<String> readLines(File file) throws FileNotFoundException {
        List<String> result = new ArrayList<>();

        try (Scanner input = new Scanner(file)) {
            while (input.hasNextLine())
                result.add(input.nextLine());
        }

        return result;
    }

    public static String apply(String string, String mask) {
        char[] result = string.toCharArray();

        for (int i = 0; i < string.length(); i++)
            if (mask.charAt(i) == '1')
                result[i] = Character.toUpperCase(result[i]);

        return new String(result);
    }

}
