package aoc.day05;

import aoc.Day;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day05 implements Day {

	@Override
	public String part1(List<String> input) {
		String output = "";

		int[][] lines = lineSplitter(input);
		int[][] grid = prefilledGrid(lines); //a grid filled with 0 that is as big as it needs to be

		for (int i = 0; i < lines.length; i++) { //Go through the list of commands
			int x1 = lines[i][0];
			int y1 = lines[i][1];
			int x2 = lines[i][2];
			int y2 = lines[i][3];
			if (y1 == y2) { //check for horizontal match
				int high, low;
				if (x1 > x2) {
					high = x1;
					low = x2;
				} else {
					high = x2;
					low = x1;
				}

				for (int j = 0; j <= high - low; j++) {
					grid[y1][low + j] = grid[y1][low + j] + 1;
				}

			}

			if (x1 == x2) { //Check vertical match
				int high, low;
				if (y1 > y2) { //sets max and min for X
					high = y1;
					low = y2;
				} else {
					high = y2;
					low = y1;
				}

				for (int j = 0; j <= high - low; j++) {
					grid[low + j][x1] = grid[low + j][x1] + 1;
				}
			}
		}

		int count = 0;

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] > 1) {
					count++;
				}
			}
		}

		output = count + "";

		return output;
	}

	public static int[][] lineSplitter(List<String> input) {
		int[][] output = new int[input.size()][4];

		for (int i = 0; i < input.size(); i++) {
			String[] firstSplit = input.get(i).split(" -> ");
			String[] temp1 = firstSplit[0].split(",");
			String[] temp2 = firstSplit[1].split(",");

			for (int j = 0; j < 2; j++) {
				output[i][j] = Integer.parseInt(temp1[j]);
				output[i][j + 2] = Integer.parseInt(temp2[j]);
			}
		}
		return output;
	}

	public static int[][] prefilledGrid(int[][] input) {
		int xMax = 0;
		int yMax = 0;

		for (int i = 0; i < input.length; i++) {
			for (int j = 0; j < 3; j += 2) {
				if (input[i][j] > xMax) {
					xMax = input[i][j];
				}

				if (input[i][j + 1] > yMax) {
					yMax = input[i][j + 1];
				}
			}
		}

		int[][] output = new int[yMax + 1][xMax + 1];

		for (int[] rows : output) {
			Arrays.fill(rows, 0);
		}

		return output;
	}

	@Override
	public String part2(List<String> input) {
		String output = "";

		int[][] lines = lineSplitter(input);
		int[][] grid = prefilledGrid(lines); //a grid filled with 0 that is as big as it needs to be

		for (int i = 0; i < lines.length; i++) { //Go through the list of commands
			int x1 = lines[i][0];
			int y1 = lines[i][1];
			int x2 = lines[i][2];
			int y2 = lines[i][3];

			if (y1 == y2) { //check for horizontal match
				int high, low;
				if (x1 > x2) {
					high = x1;
					low = x2;
				} else {
					high = x2;
					low = x1;
				}

				for (int j = 0; j <= high - low; j++) {
					grid[y1][low + j] = grid[y1][low + j] + 1;
				}

			}

			if (x1 == x2) { //Check vertical match
				int high, low;
				if (y1 > y2) { //sets max and min for X
					high = y1;
					low = y2;
				} else {
					high = y2;
					low = y1;
				}

				for (int j = 0; j <= high - low; j++) {
					grid[low + j][x1] = grid[low + j][x1] + 1;
				}
			}

			int x = x1 - x2;
			if (x < 0) {
				x = x * -1;
			}

			int y = y1 - y2;
			if (y < 0) {
				y = y * -1;
			}

			if (x == y) {
				int highX, lowX, highY, lowY;

				if (y1 > y2) { //sets max and min for X
					highY = y1;
					lowY = y2;
				} else {
					highY = y2;
					lowY = y1;
				}

				if (x1 > x2) {
					highX = x1;
					lowX = x2;
				} else {
					highX = x2;
					lowX = x1;
				}

				if (x1 - y1 != x2 - y2) {
					for (int j = 0; j <= highX - lowX; j++) {
						grid[highY - j][lowX + j] = grid[highY - j][lowX + j] + 1;
					}
				} else {
					for (int j = 0; j <= highX - lowX; j++) {
						grid[lowY + j][lowX + j] = grid[lowY + j][lowX + j] + 1;
					}
				}
			}
		}

		int count = 0;

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] > 1) {
					count++;
				}
			}
		}

		output = count + "";
		return output;
	}
}
