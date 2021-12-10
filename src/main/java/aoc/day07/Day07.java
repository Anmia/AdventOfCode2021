package aoc.day07;

import aoc.Day;

import java.util.Arrays;
import java.util.List;

public class Day07 implements Day {

	@Override
	public String part1(List<String> input) {
		String output = "";
		int[] positions = intConverter(input);

		int shortPath = 999999999;

		for (int i = 0; i < positions.length; i++) {
			int path = 0;

			for (int j = 0; j < positions.length; j++) {
				int distance = Math.abs(positions[i] - positions[j]);
				path = path + (distance);
			}

			if (path < shortPath) {
				shortPath = path;
			}
		}

		output = shortPath + "";

		return output;
	}

	public static int[] intConverter(List<String> input) {
		String[] temp = input.get(0).split(",");
		int[] output = new int[temp.length];
		for (int i = 0; i < output.length; i++) {
			output[i] = Integer.parseInt(temp[i]);
		}

		return output;
	}

	@Override
	public String part2(List<String> input) {
		String output = "";
		int[] positions = intConverter(input);

		int shortPath = 999999999;

		int greater = 0;

		for (int i = 0; i < positions.length; i++) {
			if (greater < positions[i]) {
				greater = positions[i];
			}
		}


		for (int i = 0; i < greater; i++) {
			int path = 0;
			for (int j = 0; j < positions.length; j++) {
				int difference = Math.abs(i - positions[j]);
				int distance = (difference * (1 + difference)) / 2;
				path = path + distance;
			}

			if (path < shortPath) {
				shortPath = path;
			}
		}

		output = shortPath + "";
		return output;
	}
}
