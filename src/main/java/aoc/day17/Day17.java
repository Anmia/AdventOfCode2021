package aoc.day17;

import aoc.Day;

import java.util.List;

public class Day17 implements Day {

	@Override
	public String part1(List<String> input) {
		String output = "wip";

		int[][] searchArea = transformInput(input);
		int[] velocity = new int[2];

		//find minimum velocity for x
		int xVelocity = xMin(searchArea);

		//find max velocity for y
		int yVelocity = yMax(xVelocity, searchArea);

		output = yVelocity + "";

		return output;
	}

	public int yMax(int xVelocity, int[][] searchArea) {
		int output = 0;

		int yMax = searchArea[1][0];
		int yMin = searchArea[1][1];
		int yLow = 0;

		for (int i = 0; i < 1000; i++) {
			int velocity = i;
			int pos = 0;
			boolean hit = false;
			int highest = 0;
			while (pos >= yMax) {
				pos = pos + velocity;
				velocity = changeVelocityY(velocity);
				if (pos > highest) {
					highest = pos;
				}

				if (pos <= yMin && pos >= yMax) {
					if (highest > yLow) {
						yLow = highest;
					}
				}
			}

		}

		return yLow;

	}

	public int changeVelocityY(int yVelocity) {
		//Gravity always pulls down by 1
		return yVelocity - 1;
	}

	public int xMin(int[][] searchArea) {
		int output = 0;
		int xMin = searchArea[0][0];
		int xMax = searchArea[0][1];
		
		int xLow = 0;
		int index = 1;
		boolean done = false;

		while (!done) {
			xLow += index;
			if (xLow > xMin) {
				output = index;
				done = true;
			}
			index++;
		}

		return output;
	}

	public int changeVelocityX(int xVelocity){
		//Drag reduces velocity towards zero
		if(xVelocity < 0) {
			xVelocity = xVelocity + 1;
		} else if (xVelocity > 0) {
			xVelocity = xVelocity - 1;
		}

		return xVelocity;
	}

	public int[][] transformInput(List<String> input) {
		String line = input.get(0);
		int[][] output = {{0, 0},{0, 0}};

		int whereIsX = line.indexOf("x");
		line = line.substring(whereIsX);
		String[] line2 = line.split(", ");
		String[] x = line2[0].substring(2).split("\\.\\.");
		String[] y = line2[1].substring(2).split("\\.\\.");
		output[0][0] = Integer.parseInt(x[0]);
		output[0][1] = Integer.parseInt(x[1]);
		output[1][0] = Integer.parseInt(y[0]);
		output[1][1] = Integer.parseInt(y[1]);
		return output;
	}

	@Override
	public String part2(List<String> input) {
		String output = "wip";

		return output;
	}
}
