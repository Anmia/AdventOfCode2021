package day11;

import aoc.day09.Day09;
import aoc.day11.Day11;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Day11Test {

    @Test
    public void testPart1(){
        // Given
        ArrayList<String> block = new ArrayList<>();

        block.add("5483143223");
        block.add("2745854711");
        block.add("5264556173");
        block.add("6141336146");
        block.add("6357385478");
        block.add("4167524645");
        block.add("2176841721");
        block.add("6882881134");
        block.add("4846848554");
        block.add("5283751526");


        List<String> input = block;

        // When
        String result = new Day11().part1(input);

        // Then
        assertEquals("1656", result);
    }

    @Test
    public void testPart2(){
        // Given
        ArrayList<String> block = new ArrayList<>();

        block.add("5483143223");
        block.add("2745854711");
        block.add("5264556173");
        block.add("6141336146");
        block.add("6357385478");
        block.add("4167524645");
        block.add("2176841721");
        block.add("6882881134");
        block.add("4846848554");
        block.add("5283751526");


        List<String> input = block;

        // When
        String result = new Day11().part2(input);

        // Then
        assertEquals("195", result);
    }
}
