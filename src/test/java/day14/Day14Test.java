package day14;

import aoc.day12.Day12;
import aoc.day14.Day14;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Day14Test {

    @Test
    public void testPart1(){
        // Given
        ArrayList<String> block = new ArrayList<>();

        String test = "NNCB\n" +
                "\n" +
                "CH -> B\n" +
                "HH -> N\n" +
                "CB -> H\n" +
                "NH -> C\n" +
                "HB -> C\n" +
                "HC -> B\n" +
                "HN -> C\n" +
                "NN -> C\n" +
                "BH -> H\n" +
                "NC -> B\n" +
                "NB -> B\n" +
                "BN -> B\n" +
                "BB -> N\n" +
                "BC -> B\n" +
                "CC -> N\n" +
                "CN -> C";

        String[] toBlock = test.split("\n");

        for (String item : toBlock) {
            block.add(item);
        }


        List<String> input = block;

        // When
        String result = new Day14().part1(input);

        // Then
        assertEquals("1588", result);
    }

    @Test
    public void testPart2(){
        // Given
        ArrayList<String> block = new ArrayList<>();

        String test = "NNCB\n" +
                "\n" +
                "CH -> B\n" +
                "HH -> N\n" +
                "CB -> H\n" +
                "NH -> C\n" +
                "HB -> C\n" +
                "HC -> B\n" +
                "HN -> C\n" +
                "NN -> C\n" +
                "BH -> H\n" +
                "NC -> B\n" +
                "NB -> B\n" +
                "BN -> B\n" +
                "BB -> N\n" +
                "BC -> B\n" +
                "CC -> N\n" +
                "CN -> C";

        String[] toBlock = test.split("\n");

        for (String item : toBlock) {
            block.add(item);
        }


        List<String> input = block;

        // When
        String result = new Day14().part2(input);

        // Then
        assertEquals("2188189693529", result);
    }
}
