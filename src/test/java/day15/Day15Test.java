package day15;

import aoc.day12.Day12;
import aoc.day15.Day15;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Day15Test {

    @Test
    public void testPart1(){
        // Given
        ArrayList<String> block = new ArrayList<>();

        String test = "1163751742\n" +
                "1381373672\n" +
                "2136511328\n" +
                "3694931569\n" +
                "7463417111\n" +
                "1319128137\n" +
                "1359912421\n" +
                "3125421639\n" +
                "1293138521\n" +
                "2311944581";

        String[] toBlock = test.split("\n");

        for (String item : toBlock) {
            block.add(item);
        }


        List<String> input = block;

        // When
        String result = new Day15().part1(input);

        // Then
        assertEquals("40", result);
    }

    @Test
    public void testPart2(){
        // Given
        ArrayList<String> block = new ArrayList<>();

        String test = "1163751742\n" +
                "1381373672\n" +
                "2136511328\n" +
                "3694931569\n" +
                "7463417111\n" +
                "1319128137\n" +
                "1359912421\n" +
                "3125421639\n" +
                "1293138521\n" +
                "2311944581";

        String[] toBlock = test.split("\n");

        for (String item : toBlock) {
            block.add(item);
        }

        List<String> input = block;

        // When
        String result = new Day15().part2(input);

        // Then
        assertEquals("315", result);
    }
}
