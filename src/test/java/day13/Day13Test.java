package day13;

import aoc.day12.Day12;
import aoc.day13.Day13;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Day13Test {

    @Test
    public void testPart1(){
        // Given
        ArrayList<String> block = new ArrayList<>();

        String test = "6,10\n" +
                "0,14\n" +
                "9,10\n" +
                "0,3\n" +
                "10,4\n" +
                "4,11\n" +
                "6,0\n" +
                "6,12\n" +
                "4,1\n" +
                "0,13\n" +
                "10,12\n" +
                "3,4\n" +
                "3,0\n" +
                "8,4\n" +
                "1,10\n" +
                "2,14\n" +
                "8,10\n" +
                "9,0\n" +
                "\n" +
                "fold along y=7\n" +
                "fold along x=5";

        String[] toBlock = test.split("\n");

        for (String item : toBlock) {
            block.add(item);
        }

        List<String> input = block;

        // When
        String result = new Day13().part1(input);

        // Then
        assertEquals("17", result);
    }

    @Test
    public void testPart2(){
        // Given
        ArrayList<String> block = new ArrayList<>();

        String test = "6,10\n" +
                "0,14\n" +
                "9,10\n" +
                "0,3\n" +
                "10,4\n" +
                "4,11\n" +
                "6,0\n" +
                "6,12\n" +
                "4,1\n" +
                "0,13\n" +
                "10,12\n" +
                "3,4\n" +
                "3,0\n" +
                "8,4\n" +
                "1,10\n" +
                "2,14\n" +
                "8,10\n" +
                "9,0\n" +
                "\n" +
                "fold along y=7\n" +
                "fold along x=5";

        String[] toBlock = test.split("\n");

        for (String item : toBlock) {
            block.add(item);
        }

        List<String> input = block;

        // When
        String result = new Day13().part2(input);

        // Then
        assertEquals("\n#####\n" +
                "#...#\n" +
                "#...#\n" +
                "#...#\n" +
                "#####\n" +
                ".....\n" +
                ".....\n", result);
    }
}
