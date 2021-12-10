package aoc.day06;

import aoc.Day;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day06 implements Day {

	@Override
	public String part1(List<String> input) {
		String output = "";

		String[] line = input.get(0).split(",");
		int[] counter = new int[9];

		Arrays.fill(counter, 0);

		for (int i = 0; i < line.length; i++) {
			counter[Integer.parseInt(line[i])] = counter[Integer.parseInt(line[i])] + 1;
		}

		for (int i = 0; i < 80; i++) {
			int[] tempCounter = new int[9];
			Arrays.fill(tempCounter, 0);

			for (int j = 0; j < counter.length; j++) {
				if (j == 0) {
					tempCounter[6] = counter[j];
					tempCounter[8] = counter[j];
				} else {
					tempCounter[j - 1] = tempCounter[j - 1] + counter[j];
				}
			}

			counter = tempCounter;
		}

		int sum = 0;

		for (int item : counter) {
			sum += item;
		}

		output = sum + "";

		return output;
	}

	@Override
	public String part2(List<String> input) {
		String output = "";

		String[] line = input.get(0).split(",");
		long[] counter = new long[9];

		Arrays.fill(counter, 0);

		for (int i = 0; i < line.length; i++) {
			counter[Integer.parseInt(line[i])] = counter[Integer.parseInt(line[i])] + 1;
		}

		for (int i = 0; i < 256; i++) {
			long[] tempCounter = new long[9];
			Arrays.fill(tempCounter, 0);

			for (int j = 0; j < counter.length; j++) {
				if (j == 0) {
					tempCounter[6] = counter[j];
					tempCounter[8] = counter[j];
				} else {
					tempCounter[j - 1] = tempCounter[j - 1] + counter[j];
				}
			}

			counter = tempCounter;
		}

		long sum = 0;

		for (long item : counter) {
			sum += item;
		}

		output = sum + "";

		return output;
	}
}
