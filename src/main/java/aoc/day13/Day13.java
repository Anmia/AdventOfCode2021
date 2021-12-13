package aoc.day13;

import aoc.Day;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day13 implements Day {

	@Override
	public String part1(List<String> input) {
		String output = "wip";

		int [][] coordinates = transformInputCoordinates(input);
		List<String[]> folds = transformInputFolds(input);

		int xSize = 0;
		int ySize = 0;

		//Find largest dimensions
		for (int[] item : coordinates) {
			if (xSize < item[0]) {
				xSize = item[0];
			}

			if (ySize < item[1]) {
				ySize = item[1];
			}
		}

		int xFold = xSize + 1; //Sets where to search to on x axis
		int yFold = ySize + 1; //Same for y axis

		char[][] grid = new char[ySize + 1][xSize +1];
		grid =  fillGrid(coordinates, grid);

		int count = 0;
		for (String[] item : folds) {
			count++;
			if (item[0].contains("x")) { //fold on [][]
				int xPos = Integer.parseInt(item[1]);
				for (int y = 0; y < yFold; y++) {
					for (int x = 0; x < xFold - xPos; x++) {
						if (grid[y][xPos + x] == '#') {
							grid[y][xPos - x] = '#';
							grid[y][xPos + x] = '+';
						}

						if (x == 0) {
							grid[y][xPos] = '0';
						}
					}
				}
				xFold = xPos;
			} else if (item[0].contains("y")) { //fold on []
				int yPos = Integer.parseInt(item[1]);
				for (int y = 0; y < yFold - yPos; y++) {
					for (int x = 0; x < xFold; x++) {
						if (grid[yPos + y][x] == '#') {
							grid[yPos - y][x] = '#';
							grid[yPos + y][x] = '+';
						}

						if (y == 0) {
							grid[yPos][x] = '0';
						}
					}
				}
				yFold = yPos;
			}

			if (count == 1) {
				break;
			}
		}

		long finalCount = 0;
		for (int y = 0; y < yFold; y++) {
			for (int x = 0; x < xFold; x++) {
				if (grid[y][x] == '#') {
					finalCount++;
				}
			}
		}

		output = finalCount + "";

		return output;
	}

	public char[][] fillGrid(int[][] coordinates, char[][] grid) {
		for (char[] item : grid) {
			Arrays.fill(item, '.');
		}

		for (int[] item : coordinates) {
			grid[item[1]][item[0]] = '#';
		}
		return grid;
	}

	public int[][] transformInputCoordinates(List<String> input) {
		int count = 0;
		for (int i = 0; i < input.size(); i++) {
			if (!input.get(i).contains("fold") && input.get(i).length() != 0) {
				count++;
			}
		}

		int[][] output = new int[count][2];
		for (int i = 0; i < input.size(); i++) {
			if (!input.get(i).contains("fold") && input.get(i).length() != 0) {
				String[] split = input.get(i).split(",");
				output[i][0] = Integer.parseInt(split[0]);
				output[i][1] = Integer.parseInt(split[1]);
			}
		}
		return output;
	}

	public List<String[]> transformInputFolds(List<String> input) {
		List<String[]> output = new ArrayList<>();

		for (String item : input) {
			if (item.contains("fold") && item.length() != 0) {
				output.add(item.replace("fold along ", "").split("="));
			}
		}
		return output;
	}

	@Override
	public String part2(List<String> input) {
		String output = "wip";

		int [][] coordinates = transformInputCoordinates(input);
		List<String[]> folds = transformInputFolds(input);

		int xSize = 0;
		int ySize = 0;

		//Find largest dimensions
		for (int[] item : coordinates) {
			if (xSize < item[0]) {
				xSize = item[0];
			}

			if (ySize < item[1]) {
				ySize = item[1];
			}
		}

		int xFold = xSize + 1; //Sets where to search to on x axis
		int yFold = ySize + 1; //Same for y axis

		char[][] grid = new char[ySize + 1][xSize +1];
		grid =  fillGrid(coordinates, grid);


		for (String[] item : folds) {
			if (item[0].contains("x")) { //fold on [][]
				int xPos = Integer.parseInt(item[1]);
				for (int y = 0; y < yFold; y++) {
					for (int x = 0; x < xFold - xPos; x++) {
						if (grid[y][xPos + x] == '#') {
							grid[y][xPos - x] = '#';
							grid[y][xPos + x] = '.';
						}

						if (x == 0) {
							grid[y][xPos] = '0';
						}
					}
				}
				xFold = xPos;
			} else if (item[0].contains("y")) { //fold on []
				int yPos = Integer.parseInt(item[1]);
				for (int y = 0; y < yFold - yPos; y++) {
					for (int x = 0; x < xFold; x++) {
						if (grid[yPos + y][x] == '#') {
							grid[yPos - y][x] = '#';
							grid[yPos + y][x] = '.';
						}

						if (y == 0) {
							grid[yPos][x] = '0';
						}
					}
				}
				yFold = yPos;
			}
		}

		output = "\n";

		for (int y = 0; y < yFold; y++) {
			for (int x = 0; x < xFold; x++) {
				output += grid[y][x];
			}
			output += "\n";
		}

		return output;
	}
}
