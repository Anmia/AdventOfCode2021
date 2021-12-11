package aoc.day11;

import aoc.Day;

import java.util.List;

public class Day11 implements Day {

	@Override
	public String part1(List<String> input) {
		String output = "wip";

		int[][][] map = makeAMap(input); //energy

		long count = 0;

		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < map.length; j++) {
				for (int k = 0; k < map[j].length; k++) {
					map[j][k][0] = map[j][k][0] + 1;
					map[j][k][1] = 0;
					map[j][k][2] = 0;
					map[j][k][3] = 0;

				}
			}

			boolean allFlash = true;

			while (allFlash) {
				for (int j = 0; j < map.length; j++) {
					for (int k = 0; k < map[j].length; k++) {
						if (map[j][k][0] + map[j][k][2] > 9 && map[j][k][1] != 1) {
							map[j][k][1] = 1; //Set flash
							//Increase surrounding flashes
							//NW
							if (j != 0 && k != 0) {
								map[j - 1][k - 1][2] = map[j - 1][k - 1][2] + 1;
							}
							//N
							if (j != 0) {
								map[j - 1][k][2] = map[j - 1][k][2] + 1;
							}
							//NE
							if (j != 0 && k < map[j].length -1) {
								map[j - 1][k + 1][2] = map[j - 1][k + 1][2] + 1;
							}
							//E
							if (k < map[j].length - 1) {
								map[j][k + 1][2] = map[j][k + 1][2] + 1;
							}
							//SE
							if (j < map.length - 1 && k < map[j].length - 1) {
								map[j + 1][k + 1][2] = map[j + 1][k + 1][2] + 1;
							}
							//S
							if (j < map.length - 1) {
								map[j + 1][k][2] = map[j + 1][k][2] + 1;
							}
							//SW
							if (j < map.length - 1 && k != 0) {
								map[j + 1][k - 1][2] = map[j + 1][k - 1][2] + 1;
							}
							//W
							if (k != 0) {
								map[j][k - 1][2] = map[j][k - 1][2] + 1;
							}
						}
					}
				}

				allFlash = false;

				for (int j = 0; j < map.length; j++) {
					for (int k = 0; k < map[j].length; k++) {
						if (map[j][k][0] + map[j][k][2] > 9 && map[j][k][1] != 1) {
							allFlash = true;
						}
					}
				}
			}

			for (int j = 0; j < map.length; j++) {
				for (int k = 0; k < map[j].length; k++) {
					if (map[j][k][0] + map[j][k][2] > 9 && map[j][k][1] == 1) {
						count++;
						map[j][k][0] = 0;
					}

					if (map[j][k][0] + map[j][k][2] <= 9 && map[j][k][1] != 1) {
						map[j][k][0] = map[j][k][0] + map[j][k][2];
					}
				}
			}

			if (i == 79) {
				System.out.println("!");
			}
		}

		output = count + "";

		return output;
	}

	public int[][][] makeAMap(List<String> input) {
		int[][][] output = new int[input.size()][input.get(0).length()][4];

		for (int i = 0; i < input.size(); i++) {
			for (int j = 0; j < input.get(0).length(); j++) {
				output[i][j][0] = Integer.parseInt(input.get(i).substring(j, j + 1));
				output[i][j][1] = 0;
				output[i][j][2] = 0;
				output[i][j][3] = 0;
			}
		}

		return output;
	}

	@Override
	public String part2(List<String> input) {
		String output = "wip";
		int[][][] map = makeAMap(input); //energy

		long count = 0;

		boolean sync = false;
		while (!sync) {
			count++;
			boolean allInSync = false;
			int flashCount = 0;

			for (int j = 0; j < map.length; j++) {
				for (int k = 0; k < map[j].length; k++) {
					map[j][k][0] = map[j][k][0] + 1;
					map[j][k][1] = 0;
					map[j][k][2] = 0;
					map[j][k][3] = 0;

				}
			}

			boolean allFlash = true;

			while (allFlash) {
				for (int j = 0; j < map.length; j++) {
					for (int k = 0; k < map[j].length; k++) {
						if (map[j][k][0] + map[j][k][2] > 9 && map[j][k][1] != 1) {
							map[j][k][1] = 1; //Set flash
							//Increase surrounding flashes
							//NW
							if (j != 0 && k != 0) {
								map[j - 1][k - 1][2] = map[j - 1][k - 1][2] + 1;
							}
							//N
							if (j != 0) {
								map[j - 1][k][2] = map[j - 1][k][2] + 1;
							}
							//NE
							if (j != 0 && k < map[j].length -1) {
								map[j - 1][k + 1][2] = map[j - 1][k + 1][2] + 1;
							}
							//E
							if (k < map[j].length - 1) {
								map[j][k + 1][2] = map[j][k + 1][2] + 1;
							}
							//SE
							if (j < map.length - 1 && k < map[j].length - 1) {
								map[j + 1][k + 1][2] = map[j + 1][k + 1][2] + 1;
							}
							//S
							if (j < map.length - 1) {
								map[j + 1][k][2] = map[j + 1][k][2] + 1;
							}
							//SW
							if (j < map.length - 1 && k != 0) {
								map[j + 1][k - 1][2] = map[j + 1][k - 1][2] + 1;
							}
							//W
							if (k != 0) {
								map[j][k - 1][2] = map[j][k - 1][2] + 1;
							}
						}
					}
				}

				allFlash = false;

				for (int j = 0; j < map.length; j++) {
					for (int k = 0; k < map[j].length; k++) {
						if (map[j][k][0] + map[j][k][2] > 9 && map[j][k][1] != 1) {
							allFlash = true;
						}
					}
				}
			}

			for (int j = 0; j < map.length; j++) {
				for (int k = 0; k < map[j].length; k++) {
					if (map[j][k][0] + map[j][k][2] > 9 && map[j][k][1] == 1) {
						flashCount++;
						map[j][k][0] = 0;
					}

					if (map[j][k][0] + map[j][k][2] <= 9 && map[j][k][1] != 1) {
						map[j][k][0] = map[j][k][0] + map[j][k][2];
					}
				}
			}

			if (flashCount == 100) {
				sync = true;
			}
		}

		output = count + "";

		return output;
	}
}
