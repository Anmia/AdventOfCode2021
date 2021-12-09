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

        block.add("3,4,3,1,2");


        List<String> input = block;

        // When
        String result = new Day14().part1(input);

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
        String result = new Day14().part2(input);

        // Then
        assertEquals("wip", result);
    }
}
