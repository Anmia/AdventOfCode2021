package aoc.day21;

import aoc.Day;

import java.util.List;

public class Day21 implements Day {

	@Override
	public String part1(List<String> input) {
		String output = "wip";

		long[] positions = inputTransform(input);
		long[] scores = {0, 0};

		boolean[] winner = {false, false};
		boolean done = false;
		long dice = 0;
		int turn = 0;
		long rolls = 0;
		long result = 0;

		while (!done) {
			long move = 0;
			for (int i = 0; i < 3; i++) {
				rolls++;
				dice = dice + 1;
				dice = diceWrapper(dice);
				move += dice;
			}

			positions[turn] = positionWrapper(positions[turn], move);
			scores[turn] = scores[turn] + positions[turn];

			if (scores[turn] >= 1000) {
				done = true;
			}

			if (turn == 0) {
				turn = 1;
			} else {
				turn = 0;
			}

			if (done) {
				result = scores[turn] * rolls;
			}
		}

		output = result + "";

		return output;
	}

	public long positionWrapper(long position, long move) {
		long destination = position + move;
		while (destination > 10) {
			destination = destination - 10;
		}
		return destination;
	}

	public long diceWrapper(long dice){
		if (dice > 100) {
			dice = dice - 100;
		}
		return dice;
	}

	public long[] inputTransform(List<String> input){
		long[] output = new long[2];

		for (int i = 0; i < input.size(); i++) {
			output[i] = Long.parseLong(input.get(i).substring(input.get(i).length() - 1));
		}
		return output;
	}

	@Override
	public String part2(List<String> input) {
		String output = "wip";

		return output;
	}
}
