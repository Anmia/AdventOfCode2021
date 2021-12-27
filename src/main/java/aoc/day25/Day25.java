package aoc.day25;

import aoc.Day;

import java.util.Arrays;
import java.util.List;

public class Day25 implements Day {

	@Override
	public String part1(List<String> input) {
		String output = "wip";

		char[][] map = inputTransform(input);
		char[][] newMap = map;
		boolean done = false;
		int counter = 0;

		while (!done) {
			counter++;
			newMap = moveEast(map);
			boolean matches = true;

			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[i].length; j++) {
					if (map[i][j] != newMap[i][j]) {
						matches = false;
					}
				}
			}

			if (matches) {
				done = true;
			} else {
				map = newMap;
			}
		}

		output = counter + "";

		return output;
	}

	@Override
	public String part2(List<String> input) {
		String output = "wip";

		return output;
	}

	public char[][] moveEast(char[][] map) {
		char[][] tempMap = new char[map.length][map[0].length];
		for (char[] item : tempMap) {
			Arrays.fill(item, '.');
		}

		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (map[i][j] == '>') {
					if (j < map[i].length - 1 && map[i][j + 1] == '.') {
						tempMap[i][j + 1] = '>';
					} else if (j == map[i].length - 1 && map[i][0] == '.') {
						tempMap[i][0] = '>';
					} else {
						tempMap[i][j] = '>';
					}
				}


				if (map[i][j] == 'v') {
					tempMap[i][j] = 'v';
				}
			}
		}

		map = moveSouth(tempMap);

		return map;
	}

	public char[][] moveSouth(char[][] map) {
		char[][] tempMap = new char[map.length][map[0].length];
		for (char[] item : tempMap) {
			Arrays.fill(item, '.');
		}

		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (map[i][j] == 'v') {
					if (i < map.length - 1 && map[i + 1][j] == '.') {
						tempMap[i + 1][j] = 'v';
					} else if (i == map.length - 1 && map[0][j] == '.') {
						tempMap[0][j] = 'v';
					} else {
						tempMap[i][j] = 'v';
					}
				}


				if (map[i][j] == '>') {
					tempMap[i][j] = '>';
				}
			}
		}

		map = tempMap;

		return map;
	}

	public char[][] inputTransform(List<String> input)  {
		char[][] output = new char[input.size()][input.get(0).length()];
		for (int i = 0; i < output.length; i++) {
			for (int j = 0; j < output[i].length; j++) {
				output[i][j] = input.get(i).charAt(j);
			}
		}
		return output;
	}
}
