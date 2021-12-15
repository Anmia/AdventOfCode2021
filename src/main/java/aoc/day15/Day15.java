package aoc.day15;

import aoc.Day;

import java.util.ArrayList;
import java.util.List;

public class Day15 implements Day {

	@Override
	public String part1(List<String> input) {
		String output = "wip";

		paths.clear();
		int[][] map = gridTransform(input);
		smallPath(0, 0, 0, map);

		int[] list = new int[paths.size()];

		for (int i = 0; i < list.length; i++) {
			list[i] = Integer.parseInt(paths.get(i));
		}

		//list = bubblesort(list);

		//int result = list[0] - map[0][0];

		//output = result + "";

		output = (shorthPathLength - map[0][0]) + "";


		return output;
	}

	public int[][] gridTransform(List<String> input) {
		int [][] output = new int[input.size()][input.get(0).length()];
		for (int i = 0; i < input.size(); i++) {
			for (int j = 0; j < input.get(i).length(); j++) {
				output[i][j] = Integer.parseInt(input.get(i).substring(j, j + 1));
			}
		}
		return output;
	}

	public static int[] bubblesort(int[] numbers) {
		boolean swapped = true;
		for(int i = numbers.length - 1; i > 0 && swapped; i--) {
			swapped = false;
			for (int j = 0; j < i; j++) {
				if (numbers[j] > numbers[j+1]) {
					int temp = numbers[j];
					numbers[j] = numbers[j+1];
					numbers[j+1] = temp;
					swapped = true;
				}
			}
		}
		return numbers;
	}

	public List<String> paths = new ArrayList<>();
	public long shorthPathLength = 300;

	public void smallPath(int x, int y, long path, int[][] grid) {
		path += grid[y][x];

		System.out.println();

		if (x == grid[y].length - 1 && y == grid.length - 1) {
			//paths.add(path + "");
			if (path < shorthPathLength) {
				shorthPathLength = path;
			}
		}

		if (path < shorthPathLength) {
			if (x < grid[0].length - 1) {
				smallPath(x + 1, y, path, grid);
			}

			if (y < grid.length - 1) {
				smallPath(x, y + 1, path, grid);
			}
		}


	}

	@Override
	public String part2(List<String> input) {
		String output = "wip";

		return output;
	}
}
