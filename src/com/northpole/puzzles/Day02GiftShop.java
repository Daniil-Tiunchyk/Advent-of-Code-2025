package com.northpole.puzzles;

import java.util.Scanner;

/**
 * Task: Day 2 - Gift Shop
 * Input: Comma-separated ID ranges (e.g., "11-22,95-115").
 * Output:
 * Part 1: Sum of IDs formed by repeating a sequence exactly twice (e.g., 1212).
 * Part 2: Sum of IDs formed by repeating a sequence at least twice (e.g., 123123, 111).
 */
public class Day02GiftShop {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Treat comma and whitespace as delimiters to isolate "start-end" chunks
        scanner.useDelimiter("[,\\s]+");

        long sumPart1 = 0;
        long sumPart2 = 0;

        while (scanner.hasNext()) {
            String range = scanner.next();
            if (range.isEmpty()) continue;

            String[] parts = range.split("-");
            long start = Long.parseLong(parts[0]);
            long end = Long.parseLong(parts[1]);

            // Validate every ID within the range
            for (long id = start; id <= end; id++) {
                String s = Long.toString(id);

                if (checkPart1(s)) {
                    sumPart1 += id;
                }
                if (checkPart2(s)) {
                    sumPart2 += id;
                }
            }
        }

        System.out.println("Part 1: " + sumPart1);
        System.out.println("Part 2: " + sumPart2);
    }

    /**
     * Part 1: Strictly composed of a sequence repeated 2 times.
     */
    private static boolean checkPart1(String s) {
        int len = s.length();
        if (len % 2 != 0) return false;
        // Split in half and compare
        return s.substring(0, len / 2).equals(s.substring(len / 2));
    }

    /**
     * Part 2: Composed of a sequence repeated K times (K >= 2).
     */
    private static boolean checkPart2(String s) {
        int len = s.length();
        // Iterate valid divisor lengths for the pattern
        for (int patLen = 1; patLen <= len / 2; patLen++) {
            if (len % patLen == 0) {
                String pattern = s.substring(0, patLen);
                // Reconstruct and compare
                if (pattern.repeat(len / patLen).equals(s)) {
                    return true;
                }
            }
        }
        return false;
    }
}
