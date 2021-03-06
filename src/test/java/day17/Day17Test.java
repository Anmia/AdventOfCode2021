package day17;

import aoc.day12.Day12;
import aoc.day17.Day17;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Day17Test {

    @Test
    public void testPart1(){
        // Given
        ArrayList<String> block = new ArrayList<>();

        block.add("target area: x=20..30, y=-10..-5");


        List<String> input = block;

        // When
        String result = new Day17().part1(input);

        // Then
        assertEquals("45", result);
    }

    @Test
    public void testPart2(){
        // Given
        ArrayList<String> block = new ArrayList<>();

        block.add("3,4,3,1,2");

        List<String> input = block;

        // When
        String result = new Day17().part2(input);

        // Then
        assertEquals("wip", result);
    }
}
