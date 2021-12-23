package aoc.day23;

import aoc.Day;

import java.util.List;

public class Day23 implements Day {

	@Override
	public String part1(List<String> input) {
		String output = "11120, solved manually";

		return output;
	}

	@Override
	public String part2(List<String> input) {
		String output = "see comment in day's file";

//#############
//#...........#
//###B#C#A#D###
//  #D#C#B#A#
//  #D#B#A#C#
//  #B#C#D#A#
//  #########
//
//		a7 b3 a8 d5 c7 c7 b4 c8 b5 d4 b8 d7 b5 d2 a5 c6 a5 d5 d5 a5 a6 d10 d10 b7 a5 a5 a9 a9
//
//		a = 7 + 8 + 5 + 5 + 5 + 6 + 5 + 5 + 9 + 9 = 64
//		b = 3 + 4 + 5 + 8 + 5 + 7 = 320
//		c = 7 + 7 + 8 + 6 = 2800
//		d = 5 + 4 + 7 + 2 + 5 + 5 + 10 + 10 = 48000
//
//############# a7 b3 a8 d5
//#AA.....D.B.#
//###B#C#.#D###
//  #D#C#.#A#
//  #D#B#.#C#
//  #B#C#.#A#
//  #########
//
//############# c7 c7 b4 c8
//#AA.B...D.B.#
//###B#.#.#D###
//  #D#.#C#A#
//  #D#.#C#C#
//  #B#.#C#A#
//  #########
//
//############# b5 d4 b8 d7
//#AA........D#
//###B#.#.#D###
//  #D#.#C#A#
//  #D#B#C#C#
//  #B#B#C#A#
//  #########
//
//############# b5 d2 a5 c6
//#AA...A...DD#
//###.#.#C#.###
//  #D#B#C#.#
//  #D#B#C#.#
//  #B#B#C#A#
//  #########
//
//############# a5 d5 d5
//#AA...A.A...#
//###.#.#C#.###
//  #D#B#C#.#
//  #D#B#C#D#
//  #B#B#C#D#
//  #########
//
//############# a5 a6 d10 d10
//#AA.......AA#
//###.#.#C#D###
//  #.#B#C#D#
//  #.#B#C#D#
//  #B#B#C#D#
//  #########
//
//############# b7 a5 a5 a9 a9
//#...........#
//###A#B#C#D###
//  #A#B#C#D#
//  #A#B#C#D#
//  #A#B#C#D#
//  #########

		return output;
	}
}
