package aoc.day08;

import aoc.Day;
import aoc.day10.Day10;

import java.util.*;

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

		long count = 0;


		for (int i = 0; i < input.size(); i++) { // Checks each line
			String[] firstSplit = input.get(i).split(" \\| ");
			String[] patterns = firstSplit[0].split(" ");

			patterns = stringSorter(patterns);

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

			for (int j = 0; j < 3; j++) { //Find wire "a"
				if (!numbers.get("1").contains(numbers.get("7").substring(j, j + 1))) {
					wires.replace("a", numbers.get("7").substring(j, j + 1));
				}
			}

			for (String item : patterns) { //find 5
				if (item.length() == 5) {
					int notFound = 0;
					int notInSeven = 0;
					int notInFour = 0;
					for (int j = 0; j < item.length(); j++) { //Find 5
						String chr = item.substring(j, j + 1);
						if (!numbers.get("7").contains(chr) && !numbers.get("4").contains(chr)){
							notFound++;
						}
						if (!numbers.get("4").contains(chr)) {
							notInFour++;
						}
						if (!numbers.get("7").contains(chr)) {
							notInSeven++;
						}
					}

					if (notFound == 1 && notInSeven == 3 && notInFour == 2) {
						numbers.replace("5", item);
						break;
					}
				}
			}



			for (String item : patterns) { //find 9
				if (item.length() == 6) {
					boolean isNine = true;
					for (int j = 0; j < item.length(); j++) {
						String chr = item.substring(j, j + 1);
						if (!numbers.get("7").contains(chr) && !numbers.get("5").contains(chr)){
							isNine = false;
							break;
						}
					}

					if (isNine) {
						numbers.replace("9", item);
						break;
					}
				}
			}

			//Find wire g
			for (int j = 0; j < numbers.get("9").length(); j++) {
				String chr = numbers.get("9").substring(j, j + 1);
				if (!numbers.get("7").contains(chr) && !numbers.get("4").contains(chr)) {
					wires.replace("g", chr);
					break;
				}
			}

			//Find wire "e"
			String alpha = "abcdefg";
			for (int j = 0; j < alpha.length(); j++) {
				String chr = alpha.substring(j, j + 1);
				if (!numbers.get("9").contains(chr)) {
					wires.replace("e", chr);
					break;
				}
			}

			//Find 6
			for (String item : patterns) {
				if (item.length() == 6) {
					boolean isSix = true;
					for (int j = 0; j < item.length(); j++) {
						String chr = item.substring(j, j + 1);
						if (!numbers.get("5").contains(chr) && !wires.get("e").contains(chr)) {
							isSix = false;
							wires.replace("b", chr);
							break;
						}
					}
					if (isSix) {
						numbers.replace("6", item);
					}
				}
			}

			//Find 0
			for (String item : patterns) {
				if (item.length() == 6 && !item.equals(numbers.get("9")) && !item.equals(numbers.get("6"))) {
					numbers.replace("0", item);
					break;
				}
			}

			//find d
			for (int j = 0; j < numbers.get("8").length(); j++) {
				String chr = numbers.get("8").substring(j, j + 1);
				if (!numbers.get("0").contains(chr)) {
					wires.replace("d", chr);
					break;
				}
			}

			//find 3
			for (String item : patterns) {
				if (item.length() == 5) {
					boolean isThree = true;
					for (int j = 0; j < item.length(); j++) {
						String chr = item.substring(j, j + 1);
						if (!numbers.get("7").contains(chr) && !wires.get("d").contains(chr) && !wires.get("g").contains(chr)) {
							isThree = false;
							break;
						}
					}

					if (isThree) {
						numbers.replace("3", item);
					}
				}
			}

			//Finaly complete the number set and find 2
			for (String item : patterns) {
				if (item.length() == 5 && !item.equals(numbers.get("3")) && !item.equals(numbers.get("5"))) {
					numbers.replace("2", item);
				}
			}

			String[] digitalOutput = firstSplit[1].split(" ");
			digitalOutput = stringSorter(digitalOutput);

			String number = "";
			for (String item : digitalOutput) {
				if (item.equals(numbers.get("0"))) {
					number += "0";
				} else if (item.equals(numbers.get("1"))) {
					number += "1";
				}else if (item.equals(numbers.get("2"))) {
					number += "2";
				} else if (item.equals(numbers.get("3"))) {
					number += "3";
				}else if (item.equals(numbers.get("4"))) {
					number += "4";
				}else if (item.equals(numbers.get("5"))) {
					number += "5";
				} else if (item.equals(numbers.get("6"))) {
					number += "6";
				} else if (item.equals(numbers.get("7"))) {
					number += "7";
				}else if (item.equals(numbers.get("8"))) {
					number += "8";
				}else if (item.equals(numbers.get("9"))) {
					number += "9";
				}
			}
			count += Long.parseLong(number);
		}

		output = count + "";

		return output;
	}

	public String[] stringSorter(String[] input) {
		String[] output = new String[input.length];
		String alpha = "abcdefg";
		for (int j = 0; j < input.length; j++) {
			int[] tempStorage = new int[input[j].length()];
			for (int i = 0; i < input[j].length(); i++) {
				tempStorage[i] = input[j].charAt(i);
			}
			tempStorage = bubblesort(tempStorage);


			String tempString = "";

			for (int i = 0; i < tempStorage.length; i++) {
				char tempChar = alpha.charAt(tempStorage[i] - 97);
				tempString += tempChar;
			}
			output[j] = tempString;
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
}
