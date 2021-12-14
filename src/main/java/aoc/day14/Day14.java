package aoc.day14;

import aoc.Day;

import java.util.*;

public class Day14 implements Day {

	@Override
	public String part1(List<String> input) {
		String output = "wip";

		String line = getString(input);
		List<String[]> commands = commandTransform(input);

		for (int i = 0; i < 10; i++) {
			String[] swap = new String[line.length() - 1];
			Arrays.fill(swap, "");
			for (String[] item : commands) {
				for (int j = 0; j < line.length() - 1; j++) {
					if (item[0].matches(line.substring(j, j + 2))) {
						swap[j] = item[1];
					}
				}
			}

			String tempLine = line.substring(0, 1);
			for (int j = 1; j < line.length(); j++) {
				tempLine += swap[j - 1] + line.substring(j, j +1);
			}

			line = tempLine;
		}

		String doom = "";

		for (int i = 0; i < line.length(); i++) {
			if (!doom.contains(line.substring(i, i + 1)) || doom.length() == 0) {
				doom += line.substring(i, i + 1);
			}
		}

		int[] count = new int[doom.length()];

		for (int i = 0; i < line.length(); i++) {
			int index = doom.indexOf(line.charAt(i));
			count[index] += 1;
		}

		int high = 0;
		int low = 999999999;

		for (int item : count){
			if (high < item) {high = item;}
			if (item < low) {low = item;}
		}

		output = (high - low) + "";

		return output;
	}

	public String getString(List<String> input) {
		return input.get(0);
	}

	public List<String[]> commandTransform(List<String> input) {
		List<String[]> output = new ArrayList<>();

		for (String item : input) {
			if (item.contains(" -> ")) {
				String[] temp = item.split(" -> ");
				output.add(temp);
			}
		}

		return output;
	}

	@Override
	public String part2(List<String> input) {
		String output = "wip";

		String line = getString(input);
		List<String[]> commands = commandTransform(input);



//		for (int i = 0; i < 40; i++) {
//			String[] swap = new String[line.length() - 1];
//			Arrays.fill(swap, "");
//			for (String[] item : commands) {
//				for (int j = 0; j < line.length() - 1; j++) {
//					if (item[0].matches(line.substring(j, j + 2))) {
//						swap[j] = item[1];
//					}
//				}
//			}
//
//			String tempLine = line.substring(0, 1);
//			for (int j = 1; j < line.length(); j++) {
//				tempLine += swap[j - 1] + line.substring(j, j +1);
//			}
//
//			line = tempLine;
//		}
//
//		String doom = "";
//
//		for (int i = 0; i < line.length(); i++) {
//			if (!doom.contains(line.substring(i, i + 1)) || doom.length() == 0) {
//				doom += line.substring(i, i + 1);
//			}
//		}
//
//		long[] count = new long[doom.length()];
//
//		for (int i = 0; i < line.length(); i++) {
//			int index = doom.indexOf(line.charAt(i));
//			count[index] += 1;
//		}
//
//		long high = 0;
//		long low = 999999999;
//
//		for (long item : count){
//			if (high < item) {high = item;}
//			if (item < low) {low = item;}
//		}
//
//		output = (high - low) + "";

		return output;
	}
}
