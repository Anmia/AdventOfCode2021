package day03;

import aoc.day03.Day03;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Day03Test {

    @Test
    public void testPart1(){
        // Given
        ArrayList<String> block = new ArrayList<>();

        block.add("00100");
        block.add("11110");
        block.add("10110");
        block.add("10111");
        block.add("10101");
        block.add("01111");
        block.add("00111");
        block.add("11100");
        block.add("10000");
        block.add("11001");
        block.add("00010");
        block.add("01010");

        List<String> input = block;

        // When
        String result = new Day03().part1(input);

        // Then
        assertEquals("198", result);
    }

    @Test
    public void testPart2(){
        // Given
        ArrayList<String> block = new ArrayList<>();

        block.add("00100");
        block.add("11110");
        block.add("10110");
        block.add("10111");
        block.add("10101");
        block.add("01111");
        block.add("00111");
        block.add("11100");
        block.add("10000");
        block.add("11001");
        block.add("00010");
        block.add("01010");

        List<String> input = block;

        // When
        String result = new Day03().part2(input);

        // Then
        assertEquals("230", result);
    }
}
