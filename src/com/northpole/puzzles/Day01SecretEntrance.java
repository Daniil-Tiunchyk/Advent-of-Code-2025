package com.northpole.puzzles;

import java.util.Scanner;

/**
 * Task: Day 1 - Secret Entrance.
 * Input: Sequence of rotations (e.g., "L68", "R10") from System.in.
 * Output:
 * Part 1: Count of times the dial stops exactly on 0.
 * Part 2: Count of times the dial passes or stops on 0 during rotation.
 */
public class Day01SecretEntrance {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int pos = 50;
        int zeroStops = 0;
        int zeroCrossings = 0;

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) break;

            char dir = line.charAt(0);
            int val = Integer.parseInt(line.substring(1));

            // R is positive, L is negative. Use floorMod for circular wrapping (0-99).
            int stepDir = (dir == 'R') ? 1 : -1;

            // Simulation: tick the dial one by one to catch every '0' crossing
            for (int i = 0; i < val; i++) {
                pos += stepDir;

                // Check Part 2 condition: "any click causes the dial to point at 0"
                if (pos % 100 == 0) {
                    zeroCrossings++;
                }
            }

            // Check Part 1 condition: "left pointing at 0 after any rotation"
            if (pos % 100 == 0) {
                zeroStops++;
            }
        }

        System.out.println("Part 1: " + zeroStops);
        System.out.println("Part 2: " + zeroCrossings);
    }
}
