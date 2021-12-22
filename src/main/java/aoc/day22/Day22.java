package aoc.day22;

import aoc.Day;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

public class Day22 implements Day {

	@Override
	public String part1(List<String> input) {
		String output = "wip";

		int[][][] commands = inputTransform(input);
		int[][] extremis = {{-50, 0}, {-50, 0}, {-50, 0}};
		commands = normalizeCommandsToZero(commands, extremis); //just adds 50 to everything

		output = activatedReactors(commands) + "";

		return output;
	}

	@Override
	public String part2(List<String> input) {
		String output = "wip";

		int[][][] commands = inputTransform(input);

		long count = 0;

		BigInteger[] values = new BigInteger[commands.length];
		BigInteger[][] intersections = new BigInteger[commands.length][commands.length];

		BigInteger zero = new BigInteger("0");

		for (int i = 0; i < commands.length; i++) {
			long[] x = {commands[i][1][0], commands[i][1][1]};
			long[] y = {commands[i][2][0], commands[i][2][1]};
			long[] z = {commands[i][3][0], commands[i][3][1]};

			long xLength = Math.abs(x[0] - x[1]) + 1;
			BigInteger xBig = new BigInteger(Long.toString(xLength));
			long yLength = Math.abs(y[0] - y[1]) + 1;
			BigInteger yBig = new BigInteger(Long.toString(yLength));
			long zLength = Math.abs(z[0] - z[1]) + 1;
			BigInteger zBig = new BigInteger(Long.toString(zLength));

			BigInteger size = xBig.multiply(yBig);
			size = size.multiply(zBig);


			if (commands[i][0][0] == 1) {
				values[i] = size;
			} else {
				values[i] = zero;
			}


		}


		for (int i = 0; i < commands.length; i++) {
			long[] x1 = {commands[i][1][0], commands[i][1][1]};
			long[] y1 = {commands[i][2][0], commands[i][2][1]};
			long[] z1 = {commands[i][3][0], commands[i][3][1]};
			for (int j = 0; j <= i; j++) {
				if (i != j) {

					long[] x2 = {commands[j][1][0], commands[j][1][1]};
					long[] y2 = {commands[j][2][0], commands[j][2][1]};
					long[] z2 = {commands[j][3][0], commands[j][3][1]};

					long x  = overlap(x1[0], x1[1], x2[0], x2[1]);
					BigInteger xL = new BigInteger(Long.toString(x));
					long y = overlap(y1[0], y1[1], y2[0], y2[1]);
					BigInteger yL = new BigInteger(Long.toString(y));
					long z = overlap(z1[0], z1[1], z2[0], z2[1]);
					BigInteger zL = new BigInteger(Long.toString(z));
					BigInteger size = xL.multiply(yL);
					size = size.multiply(zL);

					if (x != 0 && y != 0 && z != 0 && (commands[i][0][0] == 1 || commands[j][0][0] == 1)) {
						values[j] = values[j].subtract(size);
					}
				}
			}
		}

		BigInteger score = new BigInteger("0");

		for (int i = 0; i < values.length; i++) {
			if (values[i] != null) {
				score = score.add(values[i]);
			}
		}


//		for (int i = 0; i < intersections.length; i++) {
//			for (int j = 0; j <= i; j++) {
//				score = score.subtract(intersections[i][j]);
//			}
//		}

		output = score + "";

		return output;
	}

	public long overlap(long min1, long max1, long min2, long max2) {
		long start = Math.max(min1, min2);
		long end = Math.min(max1, max2);

		long test = Math.abs(end - start);

		if (end <= start) {
			return 0;
		} else {
			return Math.abs(end - start);
		}
	}

	public long activatedReactors(int[][][] commands) {
		boolean[][][] reactors = new boolean[101][101][101];

		for (boolean[][] depth : reactors) {
			for (boolean[] height : depth) {
				Arrays.fill(height, false);
			}
		}

		for (int[][] command : commands) {
			int startX = command[1][0];
			int endX = command[1][1];
			int startY = command[2][0];
			int endY = command[2][1];
			int startZ = command[3][0];
			int endZ = command[3][1];
			boolean changeX = false, changeY = false, changeZ = false;

			if (startX < 100 && endX > 0) {
				changeX = true;
				if (startX < 0) {
					startX = 0;
				}

				if (endX > 100) {
					endX = 100;
				}
			}

			if (startY < 100 && endY > 0) {
				changeY = true;
				if (startY < 0) {
					startY = 0;
				}

				if (endY > 100) {
					endY = 100;
				}
			}

			if (startZ < 100 && endZ > 0) {
				changeZ = true;
				if (startZ < 0) {
					startZ = 0;
				}

				if (endZ > 100) {
					endZ = 100;
				}
			}

			if (changeX && changeY && changeZ) {
				for (int z = startZ; z <= endZ; z++) {
					for (int y = startY; y <= endY; y++) {
						for (int x = startX; x <= endX; x++) {
							if (command[0][0] == 1) {
								reactors[z][y][x] = true;
							} else {
								reactors[z][y][x] = false;
							}
						}
					}
				}
			}
		}

		long count = 0;
		for (int z = 0; z < 101; z++) {
			for (int y = 0; y < 101; y++) {
				for (int x = 0; x < 101; x++) {
					if (reactors[z][y][x]) {
						count++;
					}
				}
			}
		}
		return count;
	}

	public int[][][] inputTransform(List<String> input) {
		int[][][] output = new int[input.size()][4][2];

		for (int i = 0; i < input.size(); i++) {
			int whereIsCommand = input.get(i).indexOf(" ");
			if (input.get(i).substring(0, whereIsCommand).matches("on")) {
				output[i][0][0] = 1;
				output[i][0][1] = 1;
			} else {
				output[i][0][0] = 0;
				output[i][0][1] = 0;
			}

			String[] item = input.get(i).substring(whereIsCommand + 1).split(",");

			for (int j = 0; j < 3; j++) {
				String[] item2 = item[j].substring(2).split("\\.\\.");
				output[i][j + 1][0] = Integer.parseInt(item2[0]);
				output[i][j + 1][1] = Integer.parseInt(item2[1]);
			}
		}

		return output;
	}

	public int[][][] normalizeCommandsToZero (int[][][] commands, int[][] extremis) {
		int x = extremis[0][0] * -1;
		int y = extremis[1][0] * -1;
		int z = extremis[2][0] * -1;

		for (int i = 0; i < commands.length; i++) {
			commands[i][1][0] = commands[i][1][0] + x;
			commands[i][1][1] = commands[i][1][1] + x;

			commands[i][2][0] = commands[i][2][0] + y;
			commands[i][2][1] = commands[i][2][1] + y;

			commands[i][3][0] = commands[i][3][0] + z;
			commands[i][3][1] = commands[i][3][1] + z;
		}

		return commands;
	}
}
