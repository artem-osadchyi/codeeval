package org.insane.codeeval;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/** Stepwise Word https://www.codeeval.com/open_challenges/202/ */
public class StepwiseWord {
    public static final String SEPARATOR = " ";
    public static final char CHARACTER = '*';

    public static void main(String[] args) throws FileNotFoundException {
        for (String line : readLines(args[0]))
            System.out.println(getLongestStepwise(line));
    }

    public static String getLongestStepwise(String line) {
        return stepwise(getLongestWord(parse(line)));
    }

    public static String[] parse(String line) {
        return line.split(SEPARATOR);
    }

    public static String getLongestWord(String[] words) {
        String result = words[0];

        for (String word : words)
            if (result.length() < word.length())
                result = word;

        return result;
    }

    public static String stepwise(String word) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < word.length(); i++) {
            result.append(characters(CHARACTER, i));
            result.append(word.charAt(i));
            result.append(SEPARATOR);
        }

        return result.toString().trim();
    }

    public static String characters(char character, int multiplier) {
        char[] result = new char[multiplier];

        for (int i = 0; i < multiplier; i++)
            result[i] = character;

        return new String(result);
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

}
