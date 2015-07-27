package org.insane.codeeval;

/** Multiplication Tables https://www.codeeval.com/open_challenges/23/ */
public class MultiplicationTables {
    public static final int LEFT_LIMIT = 12;
    public static final int RIGHT_LIMIT = 12;

    public static void main(String[] args) {
        new MultiplicationTables().run(LEFT_LIMIT, RIGHT_LIMIT);
    }

    public void run(int leftLimit, int rightLimit) {
        System.out.println(format(getTable(leftLimit, rightLimit)));
    }

    public int[][] getTable(int leftLimit, int rightLimit) {
        int[][] result = new int[leftLimit][rightLimit];

        for (int i = 1; i <= leftLimit; i++)
            for (int j = 1; j <= rightLimit; j++)
                result[i - 1][j - 1] = i * j;

        return result;
    }

    public String format(int[][] table) {
        StringBuilder result = new StringBuilder();

        for (int[] row : table)
            result.append(String.format("%s\n", format(row)));

        return result.toString().trim();
    }

    public String format(int[] row) {
        StringBuilder result = new StringBuilder();

        for (int item : row)
            result.append(String.format("% 4d", item));

        return result.toString().trim();
    }

}
