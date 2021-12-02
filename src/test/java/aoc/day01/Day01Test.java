package aoc.day01;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Day01Test {

    @Test
    public void testPart1(){
        // Given
        ArrayList<String> block = new ArrayList<>();

        block.add("199");
        block.add("200");
        block.add("208");
        block.add("210");
        block.add("200");
        block.add("207");
        block.add("240");
        block.add("269");
        block.add("260");
        block.add("263");


        List<String> input = block;

        // When
        String result = new Day01().part1(input);

        // Then
        assertEquals("7", result);
    }

    @Test
    public void testPart2(){
        // Given
        ArrayList<String> block = new ArrayList<>();

        block.add("199");
        block.add("200");
        block.add("208");
        block.add("210");
        block.add("200");
        block.add("207");
        block.add("240");
        block.add("269");
        block.add("260");
        block.add("263");

        List<String> input = block;

        // When
        String result = new Day01().part2(input);

        // Then
        assertEquals("5", result);
    }
}
