package day21;

import aoc.day19.Day19;
import aoc.day21.Day21;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Day21Test {

    @Test
    public void testPart1(){
        // Given
        ArrayList<String> block = new ArrayList<>();

        String test = "Player 1 starting position: 4\n" +
                "Player 2 starting position: 8";

        String[] toBlock = test.split("\n");

        for (String item : toBlock) {
            block.add(item);
        }


        List<String> input = block;

        // When
        String result = new Day21().part1(input);

        // Then
        assertEquals("739785", result);
    }

    @Test
    public void testPart2(){
        // Given
        ArrayList<String> block = new ArrayList<>();

        block.add("3,4,3,1,2");

        List<String> input = block;

        // When
        String result = new Day21().part2(input);

        // Then
        assertEquals("wip", result);
    }
}
