package day05;

import aoc.day05.Day05;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Day05Test {

    @Test
    public void testPart1(){
        // Given
        ArrayList<String> block = new ArrayList<>();

        block.add("0,9 -> 5,9");
        block.add("8,0 -> 0,8");
        block.add("9,4 -> 3,4");
        block.add("2,2 -> 2,1");
        block.add("7,0 -> 7,4");
        block.add("6,4 -> 2,0");
        block.add("0,9 -> 2,9");
        block.add("3,4 -> 1,4");
        block.add("0,0 -> 8,8");
        block.add("5,5 -> 8,2");


        List<String> input = block;

        // When
        String result = new Day05().part1(input);

        // Then

        assertEquals("5", result);
    }

    @Test
    public void testPart2(){
        // Given
        ArrayList<String> block = new ArrayList<>();

        block.add("0,9 -> 5,9");
        block.add("8,0 -> 0,8");
        block.add("9,4 -> 3,4");
        block.add("2,2 -> 2,1");
        block.add("7,0 -> 7,4");
        block.add("6,4 -> 2,0");
        block.add("0,9 -> 2,9");
        block.add("3,4 -> 1,4");
        block.add("0,0 -> 8,8");
        block.add("5,5 -> 8,2");

        List<String> input = block;

        // When
        String result = new Day05().part2(input);

        // Then
        assertEquals("12", result);
    }
}
