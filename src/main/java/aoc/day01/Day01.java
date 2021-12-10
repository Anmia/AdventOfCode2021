package aoc.day01;

import aoc.Day;

import java.util.ArrayList;
import java.util.List;

public class Day01 implements Day {

	@Override
	public String part1(List<String> input) {
		int result = 0;

		for (int i = 0; i < input.size() - 1; i++) {
			if (Integer.parseInt(input.get(i)) < Integer.parseInt(input.get(i + 1))) {
				result++;
			}
		}

		String boom = "" + result;

		return boom;
	}

	@Override
	public String part2(List<String> input) {
		int a;

		ArrayList<String> output = new ArrayList<>();

		for (int i = 0; i < input.size() - 2; i++) {
			a = Integer.parseInt(input.get(i)) + Integer.parseInt(input.get(i + 1)) + Integer.parseInt(input.get(i + 2));
			output.add(a + "");
		}

		String boom = part1(output);

		return boom;

	}

}
