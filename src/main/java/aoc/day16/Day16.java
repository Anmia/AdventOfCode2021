package aoc.day16;

import aoc.Day;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day16 implements Day {

	@Override
	public String part1(List<String> input) {
		String output = "wip";

		String line = input.get(0);
		Map<String, String> hexValues = hexValues();
		Map<String, String> binaryValues = binaryValues();

		String translation = "";

		for (int i = 0; i < line.length(); i++) {
			translation += hexValues.get(line.substring(i, i + 1));
		}

		String v = translation.substring(0, 3);
		String t = translation.substring(3, 6);
		String l;

		if (!t.matches("100")) {
			l = translation.substring(6, 7);
		}



		return output;
	}

	public Map<String, String> hexValues() {
		Map<String, String> output = new HashMap<>();

		output.put("0", "0000");
		output.put("1", "0001");
		output.put("2", "0010");
		output.put("3", "0011");
		output.put("4", "0100");
		output.put("5", "0101");
		output.put("6", "0110");
		output.put("7", "0111");
		output.put("8", "1000");
		output.put("9", "1001");
		output.put("A", "1010");
		output.put("B", "1011");
		output.put("C", "1100");
		output.put("D", "1101");
		output.put("E", "1110");
		output.put("F", "1111");

		return output;
	}

	public Map<String, String> binaryValues() {
		Map<String, String> output = new HashMap<>();

		output.put("0000", "0");
		output.put("0001", "1");
		output.put("0010", "2");
		output.put("0011", "3");
		output.put("0100", "4");
		output.put("0101", "5");
		output.put("0110", "6");
		output.put("0111", "7");
		output.put("1000", "8");
		output.put("1001", "9");
		output.put("1010", "A");
		output.put("1011", "B");
		output.put("1100", "C");
		output.put("1101", "D");
		output.put("1110", "E");
		output.put("1111", "F");

		return output;
	}

	@Override
	public String part2(List<String> input) {
		String output = "wip";

		return output;
	}
}
