package aoc.day09;

import aoc.Day;

import java.util.Arrays;
import java.util.List;

public class Day09 implements Day {

    @Override
    public String part1(List<String> input) {
        String output = "";

        int[][][] map = gridSearch(input);

        int count = sumLowPoints(map);

        output = count + "";

        return output;
    }

    public int [][][] gridSearch(List<String> input) {
        int[][][] map = inputTransform(input);

        for (int i = 0; i < map.length; i++) { //Rows in map
            for (int j = 0; j < map[i].length; j++) { //Columns in row
                //Check left
                if (j != 0 && map[i][j][0] >= map[i][j - 1][0]) {
                    map[i][j][1] = map[i][j][1] + 1;
                }

                //Check right
                if (j != map[i].length - 1 && map[i][j][0] >= map[i][j + 1][0]) {
                    map[i][j][1] = map[i][j][1] + 1;
                }

                //Check up
                if (i != 0 && map[i][j][0] >= map[i - 1][j][0]) {
                    map[i][j][1] = map[i][j][1] + 1;
                }

                //Check down
                if (i != map.length - 1 && map[i][j][0] >= map[i + 1][j][0]) {
                    map[i][j][1] = map[i][j][1] + 1;
                }
            }
        }

        return map;
    }

    public int sumLowPoints(int[][][] input ) {
        int output = 0; //Alias count

        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[i].length; j++) {
                if (input[i][j][1] == 0) {
                    output += input[i][j][0] + 1;
                }
            }
        }
        return output;
    }

    public int[][][] inputTransform(List<String> input ) {
        int[][][] output = new int[input.size()][input.get(0).length()][2];

        for (int i = 0; i < output.length; i++) {
            String[] line = input.get(i).split("");
            for (int j = 0; j < output[i].length; j++) {
                output[i][j][0] = Integer.parseInt(line[j]);
                output[i][j][1] = 0;
            }
        }

        return output;
    }

    @Override
    public String part2(List<String> input) {
        String output = "wip";

        return output;
    }
}
