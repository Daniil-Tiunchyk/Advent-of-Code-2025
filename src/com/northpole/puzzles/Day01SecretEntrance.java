package com.northpole.puzzles;

import java.util.Scanner;

/**
 * Task: Day 1 - Secret Entrance.
 * Input: Sequence of rotations (e.g., "L68", "R10") from System.in.
 * Output: Count of times the dial (0-99) lands on 0. Starts at 50.
 */
public class Day01SecretEntrance {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int pos = 50;
        int zeroStops = 0;

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) break;

            char dir = line.charAt(0);
            int val = Integer.parseInt(line.substring(1));

            // R is positive, L is negative. Use floorMod for circular wrapping (0-99).
            pos = Math.floorMod(pos + (dir == 'R' ? val : -val), 100);

            if (pos == 0) zeroStops++;
        }

        System.out.println(zeroStops);
    }
}
