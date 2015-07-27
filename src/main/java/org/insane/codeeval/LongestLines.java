package org.insane.codeeval;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;

/** Longest Lines https://www.codeeval.com/open_challenges/2/ */
public class LongestLines {

    public static class Counter {
        private final int count;
        private final TreeMap<Integer, String> items;

        public Counter(int count) {
            this.count = count;
            items = new TreeMap<>();
        }

        public void add(String item) {
            items.put(item.length(), item);

            if (items.size() > count)
                items.remove(items.firstKey());
        }

        public void add(Collection<String> items) {
            for (String item : items)
                add(item);
        }

        public List<String> getItems() {
            List<String> result = new ArrayList<>();

            result.addAll(items.descendingMap().values());

            return result;
        }

    }

    public static void main(String[] args) throws FileNotFoundException {
        List<String> lines = readLines(args[0]);
        int count = Integer.parseInt(lines.remove(0));

        List<String> result = run(count, lines);

        for (String line : result)
            System.out.println(line);

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

    public static List<String> run(int count, List<String> lines) {
        Counter counter = new Counter(count);

        counter.add(lines);

        return counter.getItems();
    }

}
