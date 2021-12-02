package aoc.day02;

import aoc.Day;

import java.util.ArrayList;
import java.util.List;

public class Day02 implements Day {

    @Override
    public String part1(List<String> input) {
        String output;
        int x = 0;
        int y = 0;

        String[] splitLine = new String[2];

        for (String line : input) {
            splitLine = line.split(" ");

            if (splitLine[0].contains("forward")) {
                x = x + Integer.parseInt(splitLine[1]);
            } else if (splitLine[0].contains("up")) {
                y = y - Integer.parseInt(splitLine[1]);
            } else if (splitLine[0].contains("down")) {
                y = y + Integer.parseInt(splitLine[1]);
            }
        }

        output = (x * y) + "";
        return output;
    }

    @Override
    public String part2(List<String> input) {
        String output;
        int x = 0;
        int y = 0;
        int aim = 0;

        String[] splitLine = new String[2];

        for (String line : input) {
            splitLine = line.split(" ");

            if (splitLine[0].contains("forward")) {
                x = x + Integer.parseInt(splitLine[1]);
                y = y + (aim * Integer.parseInt(splitLine[1]));
            } else if (splitLine[0].contains("up")) {
                // y = y - Integer.parseInt(splitLine[1]);
                aim = aim - Integer.parseInt(splitLine[1]);
            } else if (splitLine[0].contains("down")) {
                // y = y + Integer.parseInt(splitLine[1]);
                aim = aim + Integer.parseInt(splitLine[1]);
            }
        }

        output = (x * y) + "";
        return output;
    }

}
