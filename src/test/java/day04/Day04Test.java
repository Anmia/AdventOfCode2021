package day04;

import aoc.day04.Day04;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Day04Test {

    @Test
    public void testPart1(){
        // Given
        ArrayList<String> block = new ArrayList<>();

        block.add("7,4,9,5,11,17,23,2,0,14,21,24,10,16,13,6,15,25,12,22,18,20,8,19,3,26,1");
        block.add("");
        block.add("22 13 17 11  0");
        block.add(" 8  2 23  4 24");
        block.add("21  9 14 16  7");
        block.add(" 6 10  3 18  5");
        block.add(" 1 12 20 15 19");
        block.add("");
        block.add(" 3 15  0  2 22");
        block.add(" 9 18 13 17  5");
        block.add("19  8  7 25 23");
        block.add("20 11 10 24  4");
        block.add("14 21 16 12  6");
        block.add("");
        block.add("14 21 17 24  4");
        block.add("10 16 15  9 19");
        block.add("18  8 23 26 20");
        block.add("22 11 13  6  5");
        block.add(" 2  0 12  3  7");


        List<String> input = block;

        // When
        String result = new Day04().part1(input);

        // Then
        assertEquals("4512", result);
    }

    @Test
    public void testPart2(){
        // Given
        ArrayList<String> block = new ArrayList<>();

        block.add("7,4,9,5,11,17,23,2,0,14,21,24,10,16,13,6,15,25,12,22,18,20,8,19,3,26,1");
        block.add("");
        block.add("22 13 17 11  0");
        block.add(" 8  2 23  4 24");
        block.add("21  9 14 16  7");
        block.add(" 6 10  3 18  5");
        block.add(" 1 12 20 15 19");
        block.add("");
        block.add(" 3 15  0  2 22");
        block.add(" 9 18 13 17  5");
        block.add("19  8  7 25 23");
        block.add("20 11 10 24  4");
        block.add("14 21 16 12  6");
        block.add("");
        block.add("14 21 17 24  4");
        block.add("10 16 15  9 19");
        block.add("18  8 23 26 20");
        block.add("22 11 13  6  5");
        block.add(" 2  0 12  3  7");

        List<String> input = block;

        // When
        String result = new Day04().part2(input);

        // Then
        assertEquals("1924", result);
    }
}
