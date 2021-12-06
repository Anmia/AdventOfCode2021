package aoc.day05;

import aoc.Day;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day05 implements Day {

    @Override
    public String part1(List<String> input) {
        String output = "";

        int[][] lines = lineSplitter(input);
        int[][] grid = prefilledGrid(lines); //a grid filled with 0 that is as big as it needs to be

        for (int i = 0; i < lines.length; i++) { //Go through the list of commands
            if (lines[i][1] == lines[i][3]) { //check for horizontal match
                int high, low;
                if (lines[i][0] > lines[i][2]) {
                    high = lines[i][0];
                    low = lines[i][2];
                } else {
                    high = lines[i][2];
                    low = lines[i][0];
                }

                for (int j = low; j <= high; j++) {
                    grid[lines[i][1]][j] = grid[lines[i][1]][j] + 1;
                }
            }

            if (lines[i][0] == lines[i][2]) { //Check vertical match
                int high, low;
                if (lines[i][1] > lines[i][3]) { //sets max and min for X
                    high = lines[i][1];
                    low = lines[i][3];
                } else {
                    high = lines[i][3];
                    low = lines[i][1];
                }

                for (int j = low; j <= high; j++) {
                    grid[j][lines[i][0]] = grid[j][lines[i][0]] + 1;
                }
            }
        }

        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] > 1) {
                    count++;
                }
            }
        }

        output = count + "";

        return output;
    }

    public static int[][] lineSplitter(List<String> input) {
        int[][] output = new int[input.size()][4];

        for (int i = 0; i < input.size(); i++) {
            String[] firstSplit = input.get(i).split(" -> ");
            String[] temp1 = firstSplit[0].split(",");
            String[] temp2 = firstSplit[1].split(",");

            for (int j = 0; j < 2; j++) {
                output[i][j] = Integer.parseInt(temp1[j]);
                output[i][j + 2] = Integer.parseInt(temp2[j]);
            }
        }
        return output;
    }

    public static int[][] prefilledGrid(int[][] input) {
        int xMax = 0;
        int yMax = 0;

        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < 3; j += 2) {
                if (input[i][j] > xMax) {
                    xMax = input[i][j];
                }

                if (input[i][j + 1] > yMax) {
                    yMax = input[i][j + 1];
                }
            }
        }

        int[][] output = new int[xMax + 2][yMax + 2];

        for (int[] rows : output) {
            Arrays.fill(rows, 0);
        }

        return output;
    }

    @Override
    public String part2(List<String> input) {
        String output = "";

        return output;
    }
}
