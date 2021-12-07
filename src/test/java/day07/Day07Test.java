package day07;

import aoc.day06.Day06;
import aoc.day07.Day07;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Day07Test {

    @Test
    public void testPart1(){
        // Given
        ArrayList<String> block = new ArrayList<>();

        block.add("16,1,2,0,4,2,7,1,2,14");


        List<String> input = block;

        // When
        String result = new Day07().part1(input);

        // Then
        assertEquals("37", result);
    }

    @Test
    public void testPart2(){
        // Given
        ArrayList<String> block = new ArrayList<>();

        block.add("16,1,2,0,4,2,7,1,2,14");

        List<String> input = block;

        // When
        String result = new Day07().part2(input);

        // Then
        assertEquals("168", result);
    }
}
