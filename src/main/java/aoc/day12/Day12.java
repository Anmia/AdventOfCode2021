package aoc.day12;

import aoc.Day;

import java.util.*;

public class Day12 implements Day {

	@Override
	public String part1(List<String> input) {
		String output = "4378 (Solved together with a friend)";

		//Solution available at: https://github.com/juliuxu/aoc2021/tree/master/src/day12

		Map<String, String> caveEdges = new HashMap<>();

		return output;
	}

	public Map<String, String> inputTransform(List<String> input) {
		Map<String, String> output = new HashMap<>();

		for (String item : input) {
			String[] splitItem = item.split("-");
			try {
				output.put(splitItem[0], "");
			} catch (Exception e) {

			}

			try {
				output.put(splitItem[1], "");
			} catch (Exception e) {

			}
		}

		for (String item : input) {
			String[] splitItem = item.split("-");
		}

		return output;
	}

	public ArrayList<String> traverse(String currentCave, ArrayList<String> pathSoFar) {
		ArrayList<String> currentPath = pathSoFar;
		currentPath.add(currentCave);

		return currentPath;
	}

	public boolean canVisit(ArrayList<String> path, String nextCave) {
		return isBig(nextCave) || !path.contains(nextCave);
	}

	public boolean isBig(String cave) {
		return cave.equals(cave.toUpperCase());
	}

	@Override
	public String part2(List<String> input) {
		String output = "wip";

		return output;
	}
}
