package aoc.day10;

import aoc.Day;

import java.util.List;

public class Day10 implements Day {

	@Override
	public String part1(List<String> input) {
		String output = "wip";

		int score = 0;
		int[] errorOccurrence = {0, 0, 0, 0}; //), ], }, >


		for (String item : input) {
			String expectations = "";
			char errorChar = 'a';
			for (int i = 0; i < item.length(); i++) {
				char chr = item.charAt(i);
				if (chr != '>' && chr != '}' && chr != ']' && chr != ')') {
					switch (chr) {
						case '<':
							expectations += ">";
							break;
						case '(':
							expectations += ")";
							break;
						case '{':
							expectations += "}";
							break;
						case '[':
							expectations += "]";
							break;
					}
				} else {
					if (expectations.length() != 0) {
						if (chr == expectations.charAt(expectations.length() - 1)) {
							expectations = expectations.substring(0, expectations.length() - 1);
						} else {
							errorChar = chr;
							break;
						}
					}
				}
			}

			if (errorChar != 'a') {
				switch (errorChar) {
					case ')':
						errorOccurrence[0] += 1;
						score += 3;
						break;
					case ']':
						errorOccurrence[1] += 1;
						score += 57;
						break;
					case '}':
						errorOccurrence[2] += 1;
						score += 1197;
						break;
					case '>':
						errorOccurrence[3] += 1;
						score += 25137;
						break;
				}
			}

		}

		output = score + "";

		return output;
	}

	@Override
	public String part2(List<String> input) {
		String output = "wip";

		int score = 0;
		int[] errorOccurrence = {0, 0, 0, 0}; //), ], }, >


		for (String item : input) {
			String expectations = "";
			String complete = "";
			boolean corrupt = false;
			for (int i = 0; i < item.length(); i++) {
				char chr = item.charAt(i);
				if (chr != '>' && chr != '}' && chr != ']' && chr != ')') {
					switch (chr) {
						case '<':
							expectations += ">";
							break;
						case '(':
							expectations += ")";
							break;
						case '{':
							expectations += "}";
							break;
						case '[':
							expectations += "]";
							break;
					}
				} else {
					if (expectations.length() != 0) {
						if (chr == expectations.charAt(expectations.length() - 1)) {
							expectations = expectations.substring(0, expectations.length() - 1);
						} else {
							corrupt = true;
							break;

						}
					}
				}
			}

			if (!corrupt) {
				int tempScore = 0;
				for (int i = 0; i < complete.length(); i++) {
					switch (complete.charAt(i)) {
						case ')':
							tempScore = (tempScore * 5) + 1;
							break;
						case ']':
							tempScore = (tempScore * 5) + 2;
							break;
						case '}':
							tempScore = (tempScore * 5) + 3;
							break;
						case '>':
							tempScore = (tempScore * 5) + 4;
							break;
					}
				}
			}


		}

		output = score + "";

		return output;
	}
}
