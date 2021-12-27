package day25;

import aoc.day19.Day19;
import aoc.day25.Day25;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Day25Test {

    @Test
    public void testPart1(){
        // Given
        ArrayList<String> block = new ArrayList<>();

        String test = "v...>>.vv>\n" +
                ".vv>>.vv..\n" +
                ">>.>v>...v\n" +
                ">>v>>.>.v.\n" +
                "v>v.vv.v..\n" +
                ">.>>..v...\n" +
                ".vv..>.>v.\n" +
                "v.v..>>v.v\n" +
                "....v..v.>";

        String[] toBlock = test.split("\n");

        for (String item : toBlock) {
            block.add(item);
        }


        List<String> input = block;

        // When
        String result = new Day25().part1(input);

        // Then
        assertEquals("58", result);
    }

    @Test
    public void testPart2(){
        // Given
        ArrayList<String> block = new ArrayList<>();

        String test = "v...>>.vv>\n" +
                ".vv>>.vv..\n" +
                ">>.>v>...v\n" +
                ">>v>>.>.v.\n" +
                "v>v.vv.v..\n" +
                ">.>>..v...\n" +
                ".vv..>.>v.\n" +
                "v.v..>>v.v\n" +
                "....v..v.>";

        String[] toBlock = test.split("\n");

        for (String item : toBlock) {
            block.add(item);
        }

        List<String> input = block;

        // When
        String result = new Day25().part2(input);

        // Then
        assertEquals("wip", result);
    }
}
