package day06;

import aoc.day06.Day06;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Day06Test {

    @Test
    public void testPart1(){
        // Given
        ArrayList<String> block = new ArrayList<>();

        block.add("3,4,3,1,2");


        List<String> input = block;

        // When
        String result = new Day06().part1(input);

        // Then
        assertEquals("4512", result);
    }

    @Test
    public void testPart2(){
        // Given
        ArrayList<String> block = new ArrayList<>();

        block.add("3,4,3,1,2");

        List<String> input = block;

        // When
        String result = new Day06().part2(input);

        // Then
        assertEquals("1924", result);
    }
}
