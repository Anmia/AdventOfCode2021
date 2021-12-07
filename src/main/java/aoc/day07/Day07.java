package aoc.day07;

import aoc.Day;

import java.util.Arrays;
import java.util.List;

public class Day07 implements Day {

    @Override
    public String part1(List<String> input) {
        String output = "";
        int[] positions = intConverter(input);

        int shortPath = 0;

        for (int i = 0; i < positions.length; i++) {
            
        }



        return output;
    }

    public static int[] intConverter(List<String> input) {
        String[] temp = input.get(0).split(",");
        int[] output = new int[temp.length];
        for (int i = 0; i < output.length; i++) {
            output[i] = Integer.parseInt(temp[i]);
        }

        return output;
    }

    @Override
    public String part2(List<String> input) {
        String output = "";

        return output;
    }
}
