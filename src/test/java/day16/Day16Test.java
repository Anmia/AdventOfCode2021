package day16;

import aoc.day12.Day12;
import aoc.day16.Day16;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Day16Test {

    @Test
    public void testPart11(){
        // Given
        ArrayList<String> block = new ArrayList<>();

        block.add("8A004A801A8002F478");


        List<String> input = block;

        // When
        String result = new Day16().part1(input);

        // Then
        assertEquals("16", result);
    }

//    @Test
//    public void testPart12(){
//        // Given
//        ArrayList<String> block = new ArrayList<>();
//
//        block.add("620080001611562C8802118E34");
//
//
//        List<String> input = block;
//
//        // When
//        String result = new Day16().part1(input);
//
//        // Then
//        assertEquals("12", result);
//    }
//
//    @Test
//    public void testPart13(){
//        // Given
//        ArrayList<String> block = new ArrayList<>();
//
//        block.add("C0015000016115A2E0802F182340");
//
//
//        List<String> input = block;
//
//        // When
//        String result = new Day16().part1(input);
//
//        // Then
//        assertEquals("23", result);
//    }

    @Test
    public void testPart2(){
        // Given
        ArrayList<String> block = new ArrayList<>();

        block.add("3,4,3,1,2");

        List<String> input = block;

        // When
        String result = new Day16().part2(input);

        // Then
        assertEquals("wip", result);
    }
}
