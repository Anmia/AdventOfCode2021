package day09;

import aoc.day06.Day06;
import aoc.day09.Day09;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Day09Test {

    @Test
    public void testPart1(){
        // Given
        ArrayList<String> block = new ArrayList<>();

        block.add("2199943210");
        block.add("3987894921");
        block.add("9856789892");
        block.add("8767896789");
        block.add("9899965678");


        List<String> input = block;

        // When
        String result = new Day09().part1(input);

        // Then
        assertEquals("15", result);
    }

    @Test
    public void testPart2(){
        // Given
        ArrayList<String> block = new ArrayList<>();

        block.add("2199943210");
        block.add("3987894921");
        block.add("9856789892");
        block.add("8767896789");
        block.add("9899965678");

        List<String> input = block;

        // When
        String result = new Day09().part2(input);

        // Then
        assertEquals("wip", result);
    }
}
