package day02;

import aoc.day02.Day02;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Day02Test {

    @Test
    public void testPart1(){
        // Given
        ArrayList<String> block = new ArrayList<>();

        block.add("forward 5");
        block.add("down 5");
        block.add("forward 8");
        block.add("up 3");
        block.add("down 8");
        block.add("forward 2");

        List<String> input = block;

        // When
        String result = new Day02().part1(input);

        // Then
        assertEquals("150", result);
    }

    @Test
    public void testPart2(){
        // Given
        ArrayList<String> block = new ArrayList<>();

        block.add("forward 5");
        block.add("down 5");
        block.add("forward 8");
        block.add("up 3");
        block.add("down 8");
        block.add("forward 2");

        List<String> input = block;

        // When
        String result = new Day02().part2(input);

        // Then
        assertEquals("900", result);
    }
}
