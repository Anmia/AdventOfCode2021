package aoc.day08;

import aoc.Day;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day08 implements Day {

	@Override
	public String part1(List<String> input) {
		String output = "";
// SOLVE IT YOURSELF <3 you can do it :D

		Map<String, String> numbers = new HashMap<>();
		numbers.put("1", "");
		numbers.put("4", "");
		numbers.put("7", "");
		numbers.put("8", "");

		int count = 0;

		for (int i = 0; i < input.size(); i++) {
			String[] firstSplit = input.get(i).split(" \\| ");
			String[] patterns = firstSplit[0].split(" ");

			for (String item : patterns) { //Assign 1,4 ,7 ,8 to the map
				switch (item.length()) {
					case 2:
						numbers.replace("1", item);
						break;
					case 4:
						numbers.replace("4", item);
						break;
					case 3:
						numbers.replace("7", item);
						break;
					case 7:
						numbers.replace("8", item);
						break;
				}
			}

			String[] digitalOutput = firstSplit[1].split(" ");

			for (String item : digitalOutput) {
				String compare = "";
				boolean check = false;
				switch (item.length()) {
					case 2:
						compare = numbers.get("1");
						check = true;
						break;
					case 4:
						compare = numbers.get("4");
						check = true;
						break;
					case 3:
						compare = numbers.get("7");
						check = true;
						break;
					case 7:
						compare = numbers.get("8");
						check = true;
						break;
				}


				if (check) {
					boolean match = true;
					for (int j = 0; j < compare.length(); j++) {
						if (!item.contains(compare.substring(j, j + 1))) {
							match = false;
						}
					}

					if (match) {
						count++;
					}
				}
			}

		}


		output = count + "";

		return output;
	}


	@Override
	public String part2(List<String> input) {
		String output = "";
// SOLVE IT YOURSELF <3 you can do it :D

		Map<String, String> numbers = new HashMap<>();
		numbers.put("1", "");
		numbers.put("2", "");
		numbers.put("3", "");
		numbers.put("4", "");
		numbers.put("5", "");
		numbers.put("6", "");
		numbers.put("7", "");
		numbers.put("8", "");
		numbers.put("9", "");
		numbers.put("0", "");

		Map<String, String> wires = new HashMap<>();
		wires.put("a", "");
		wires.put("b", "");
		wires.put("c", "");
		wires.put("d", "");
		wires.put("e", "");
		wires.put("f", "");
		wires.put("g", "");

		int count = 0;

		for (int i = 0; i < input.size(); i++) {
			String[] firstSplit = input.get(i).split(" \\| ");
			String[] patterns = firstSplit[0].split(" ");

			for (String item : patterns) { //Assign 1,4 ,7 ,8 to the map
				switch (item.length()) {
					case 2:
						numbers.replace("1", item);
						break;
					case 4:
						numbers.replace("4", item);
						break;
					case 3:
						numbers.replace("7", item);
						break;
					case 7:
						numbers.replace("8", item);
						break;
				}
			}

			for (int j = 0; j < 3; j++) {
				if (!numbers.get("1").contains(numbers.get("7").substring(j, j + 1))) {
					wires.replace("a", numbers.get("7").substring(j, j + 1));
				}
			}


			for (int j = 0; j < 5; j++) {
				String seven = numbers.get("7");
			}

			String[] digitalOutput = firstSplit[1].split(" ");

			for (String item : digitalOutput) {
				String compare = "";
				boolean check = false;
				switch (item.length()) {
					case 2:
						compare = numbers.get("1");
						check = true;
						break;
					case 4:
						compare = numbers.get("4");
						check = true;
						break;
					case 3:
						compare = numbers.get("7");
						check = true;
						break;
					case 7:
						compare = numbers.get("8");
						check = true;
						break;
				}


				if (check) {
					boolean match = true;
					for (int j = 0; j < compare.length(); j++) {
						if (!item.contains(compare.substring(j, j + 1))) {
							match = false;
						}
					}

					if (match) {
						count++;
					}
				}
			}

		}


		output = count + "";

		return output;
	}
}
