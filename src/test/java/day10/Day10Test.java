package day10;

import aoc.day09.Day09;
import aoc.day10.Day10;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Day10Test {

    @Test
    public void testPart1(){
        // Given
        ArrayList<String> block = new ArrayList<>();

        block.add("3,4,3,1,2");


        List<String> input = block;

        // When
        String result = new Day10().part1(input);

        // Then
        assertEquals("wip", result);
    }

    @Test
    public void testPart2(){
        // Given
        ArrayList<String> block = new ArrayList<>();

        block.add("3,4,3,1,2");

        List<String> input = block;

        // When
        String result = new Day10().part2(input);

        // Then
        assertEquals("wip", result);
    }
}
