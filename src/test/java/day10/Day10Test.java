package day10;

import aoc.day09.Day09;
import aoc.day10.Day10;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Day10Test {

    @Test
    public void testPart1(){
        // Given
        ArrayList<String> block = new ArrayList<>();

        block.add("[({(<(())[]>[[{[]{<()<>>");
        block.add("[(()[<>])]({[<{<<[]>>(");
        block.add("{([(<{}[<>[]}>{[]{[(<()>");
        block.add("(((({<>}<{<{<>}{[]{[]{}");
        block.add("[[<[([]))<([[{}[[()]]]");
        block.add("[{[{({}]{}}([{[{{{}}([]");
        block.add("{<[[]]>}<{[{[{[]{()[[[]");
        block.add("[<(<(<(<{}))><([]([]()");
        block.add("<{([([[(<>()){}]>(<<{{");
        block.add("<{([{{}}[<[[[<>{}]]]>[]]");


        List<String> input = block;

        // When
        String result = new Day10().part1(input);

        // Then
        assertEquals("26397", result);
    }

    @Test
    public void testPart2(){
        // Given
        ArrayList<String> block = new ArrayList<>();

        block.add("[({(<(())[]>[[{[]{<()<>>");
        block.add("[(()[<>])]({[<{<<[]>>(");
        block.add("{([(<{}[<>[]}>{[]{[(<()>");
        block.add("(((({<>}<{<{<>}{[]{[]{}");
        block.add("[[<[([]))<([[{}[[()]]]");
        block.add("[{[{({}]{}}([{[{{{}}([]");
        block.add("{<[[]]>}<{[{[{[]{()[[[]");
        block.add("[<(<(<(<{}))><([]([]()");
        block.add("<{([([[(<>()){}]>(<<{{");
        block.add("<{([{{}}[<[[[<>{}]]]>[]]");

        List<String> input = block;

        // When
        String result = new Day10().part2(input);

        // Then
        assertEquals("wip", result);
    }
}
