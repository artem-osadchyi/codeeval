package org.insane.codeeval.hard;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/** String Permutations https://www.codeeval.com/open_challenges/14/ */
public class StringPermutations {
    public static final String DELIMITER = ",";

    public static void main(String[] args) throws FileNotFoundException {
        new StringPermutations().run(args[0]);
    }

    public void run(String path) throws FileNotFoundException {
        run(new File(path));
    }

    public void run(File file) throws FileNotFoundException {
        for (String line : readLines(file)) {
            List<String> permutations = sort(permutations(line));
            String formatted = join(DELIMITER, permutations);
            System.out.println(formatted);
        }
    }

    public String join(String delimiter, List<String> parts) {
        StringBuilder result = new StringBuilder();

        result.append(parts.get(0));
        for (String part : parts.subList(1, parts.size())) {
            result.append(delimiter);
            result.append(part);
        }

        return result.toString().trim();
    }

    public List<String> readLines(File file) throws FileNotFoundException {
        List<String> result = new ArrayList<>();

        try (Scanner input = new Scanner(file)) {
            while (input.hasNextLine())
                result.add(input.nextLine());
        }

        return result;
    }

    public List<String> sort(List<String> unsorted) {
        List<String> result = new ArrayList<>(unsorted);

        Collections.sort(result);

        return result;
    }

    public List<String> permutations(String line) {
        List<String> result = new ArrayList<>();

        for (List<Character> permutation : permutations(toCharacterList(line)))
            result.add(toString(permutation));

        return result;
    }

    public <T> List<List<T>> permutations(List<T> sequence) {
        List<List<T>> result = new ArrayList<>();

        if (sequence.size() == 2) {
            result.add(new ArrayList<>(sequence));
            result.add(reverse(sequence));
        }
        else {
            for (T item : sequence)
                result.addAll(permute(item, permutations(without(sequence, item))));
        }

        return result;
    }

    public <T> List<List<T>> permute(T first, List<List<T>> permutations) {
        List<List<T>> result = new ArrayList<>();

        for (List<T> permutation : permutations)
            result.add(prepend(first, permutation));

        return result;
    }

    public <T> List<T> prepend(T item, List<T> list) {
        List<T> result = new ArrayList<>(list);

        result.add(0, item);

        return result;
    }

    public <T> List<T> without(List<T> sequence, int index) {
        List<T> result = new ArrayList<>(sequence);

        result.remove(index);

        return result;
    }

    public <T> List<T> without(List<T> sequence, T item) {
        return without(sequence, sequence.indexOf(item));
    }

    public List<Character> toCharacterList(String string) {
        List<Character> result = new ArrayList<>();

        for (Character item : string.toCharArray())
            result.add(item);

        return result;
    }

    public String toString(List<Character> characters) {
        return String.valueOf(toCharArray(characters));
    }

    public char[] toCharArray(List<Character> characters) {
        char[] result = new char[characters.size()];

        for (int i = 0; i < result.length; i++)
            result[i] = characters.get(i);

        return result;
    }

    public <T> List<T> reverse(List<T> list) {
        List<T> result = new ArrayList<>(list);

        Collections.reverse(result);

        return result;
    }

}
