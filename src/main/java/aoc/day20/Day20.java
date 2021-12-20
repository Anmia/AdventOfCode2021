package aoc.day20;

import aoc.Day;

import java.util.Arrays;
import java.util.List;

public class Day20 implements Day {

	@Override
	public String part1(List<String> input) {
		String output = "wip";

		char[] algo = getAlgorithm(input);
		char [][] image = getImage(input);

		image = enhancer(algo, image, 2);


		output = counter(image) + "";

		return output;
	}

	public long counter(char[][] image) {
		long count = 0;

		for (int i = 0; i < image.length; i++) {
			for (int j = 0; j < image[i].length; j++) {
				if (image[i][j] == '#') {
					count++;
				}
			}
		}

		return count;
	}

	public char[][] enhancer(char[] algo, char[][] image, int levels) {
		//As the image we get is a location on an infinite field we can pad with dark spaces
		for (int iteration = 0; iteration < levels; iteration++) {
			char [][] tempImage = new char[image.length][image[0].length];
			for (char[] item : tempImage) {
				Arrays.fill(item, '.');
			}

			char spaceChar = image[0][0];
			for (int i = 0; i < image.length; i++) {
				for (int j = 0; j < image[i].length; j++) {
					String temp = "";

					// nw n ne, w c e, sw s se

					//NW
					if (i != 0 && j != 0) {
						temp += image[i - 1][j - 1];
					} else {
						temp += spaceChar;
					}

					//N
					if (i != 0) {
						temp += image[i - 1][j];
					} else {
						temp += spaceChar;
					}

					//NE
					if (i != 0 && j != image[i].length - 1) {
						temp += image[i - 1][j + 1];
					} else {
						temp += spaceChar;
					}

					//W
					if (j != 0) {
						temp += image[i][j - 1];
					} else {
						temp += spaceChar;
					}

					//C
					temp += image[i][j];

					//E
					if (j != image[i].length - 1) {
						temp += image[i][j + 1];
					} else {
						temp += spaceChar;
					}

					//SW
					if (i != image.length - 1 && j != 0) {
						temp += image[i + 1][j - 1];
					} else {
						temp += spaceChar;
					}
					//S
					if (i != image.length -1) {
						temp += image[i + 1][j];
					} else {
						temp += spaceChar;
					}

					//SE
					if (i != image.length - 1 && j != image[i].length - 1) {
						temp += image[i + 1][j + 1];
					} else {
						temp += spaceChar;
					}

					tempImage[i][j] = algo[binaryCalculator(temp)];
				}
			}
			image = tempImage;
		}

		return image;
	}

	public int binaryCalculator (String input) {
		int output = 0;
		String flip = "";
		for (int i = input.length() - 1; i >= 0 ; i--) {
			flip += input.substring(i, i + 1);
		}

		for (int i = 0; i < flip.length(); i++) {
			if (flip.substring(i, i + 1).matches("#")) {
				output += Math.pow(2, i);
			}
		}
		return output;
	}

	public char[][] getImage(List<String> input) {
		char[][] output = new char[input.size() + 98][input.get(input.size() -1).length() + 100];
		for (char[] item : output) {
			Arrays.fill(item, '.');
		}

		for (int i = 0; i < output.length - 100; i++) {
			for (int j = 0; j < output[i].length - 100; j++) {
				output[i + 50][j + 50] = input.get(i + 2).charAt(j);
			}
		}

		return output;
	}

	public char[] getAlgorithm(List<String> input) {
		char[] output = new char[input.get(0).length()];

		for (int i = 0; i < input.get(0).length(); i++) {
			output[i] = input.get(0).charAt(i);
		}

		return output;
	}

	@Override
	public String part2(List<String> input) {
		String output = "wip";
		char[] algo = getAlgorithm(input);
		char [][] image = getImage(input);

		image = enhancer(algo, image, 50);


		output = counter(image) + "";
		return output;
	}
}
