package aoc.day15;

import aoc.Day;

import java.util.Arrays;
import java.util.List;

public class Day15 implements Day {
	public int shorthPathLength = Integer.MAX_VALUE;
	public long itterator = 0;
	public int[][] score;

	@Override
	public String part1(List<String> input) {
		String output = "wip";

		int[][] map = gridTransform(input);



		int leng1 = map[0].length;
		int leng2 = map.length;

		score = new int[leng2][leng1];

		for (int[] item : score) {
			Arrays.fill(item, Integer.MAX_VALUE);
		}

		smallPath(0, 0, 0, map);


		output = (shorthPathLength - map[0][0]) + "";

		//output = "790, skipped actual code for speedy result later days <3";
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

	public void smallPath(int x, int y, int path, int[][] grid) {
		path += grid[y][x];
		itterator++;

		if (path <= score[y][x]) {
			score[y][x] = path;

			if (x == grid[y].length - 1 && y == grid.length - 1) {
				if (path < shorthPathLength) {
					shorthPathLength = path;
					System.out.println(x + " " + y + " " + path + " " + itterator);
				}
			}

			if (path < shorthPathLength) {
				if (y < grid.length - 1) {
					smallPath(x, y + 1, path, grid);
				}

				if (x < grid[0].length - 1) {
					smallPath(x + 1, y, path, grid);
				}
			}
		}


	}

	@Override
	public String part2(List<String> input) {
		String output = "wip";

		int[][] map = gridTransform(input);

		map = transformGridAgain(map);

		int leng1 = map[0].length;
		int leng2 = map.length;

		score = new int[leng2][leng1];

		for (int[] item : score) {
			Arrays.fill(item, Integer.MAX_VALUE);
		}

		shorthPathLength = Integer.MAX_VALUE;
		//smallPath(0, 0, 0, map);


	//	output = (shorthPathLength - map[0][0]) + "";


		return output;
	}

	public int[][] transformGridAgain(int[][] input) {
		int y = input.length;
		int x = input[input.length - 1].length;
		int[][] output = new int[y * 5][x * 5];


		for (int k = 0; k < output.length; k++) {
			for (int l =0; l < output.length; l++) {
				int temp = input[k % y][l % y];
				int add = Math.floorDiv(k , y) + Math.floorDiv(l, x);
				temp = temp + add;
				if (temp > 9) {
					temp = temp - 9;
					if (temp > 9) {
						temp = temp - 9;
					}
				}

				output[k][l] = temp;
			}
		}

//		for (int i = 0; i < 5; i++) {
//			for (int j = 0; j < 5; j++) {
//				for (int k = 0; k < y; k++) {
//					for (int l =0; l < x; l++) {
//						int temp = input[k][l] + i + j;
//						if (temp > 9) {
//							temp = temp - 9;
//							if (temp > 9) {
//								temp = temp - 9;
//							}
//						}
//						output[k + (10 * i)][l + (10 * j)] = temp;
//					}
//				}
//			}
//		}

		return output;
	}
}
