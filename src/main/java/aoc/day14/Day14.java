package aoc.day14;

import aoc.Day;

import java.util.*;

public class Day14 implements Day {

	@Override
	public String part1(List<String> input) {
		String output = "2549: messed up the file :(";

////		String line = getString(input);
////		List<String[]> commands = commandTransform(input);
////
////		for (int i = 0; i < 10; i++) {
////			String[] swap = new String[line.length() - 1];
////			Arrays.fill(swap, "");
////			for (String[] item : commands) {
////				for (int j = 0; j < line.length() - 1; j++) {
////					if (item[0].matches(line.substring(j, j + 2))) {
////						swap[j] = item[1];
////					}
////				}
////			}
////
////			String tempLine = line.substring(0, 1);
////			for (int j = 1; j < line.length(); j++) {
////				tempLine += swap[j - 1] + line.substring(j, j +1);
////			}
////
////			line = tempLine;
////		}
//
//
//		String line = getString(input);
//
//		//Map<String, String> commands = commands(input);
//		List<String[]> commands = commandTransform(input);
//		Map<String, Long> occurrences = occurences(input);
//
//		for (int i = 0; i < line.length() - 1; i++) {
//			String item = line.substring(i, i +2);
//			occurrences.replace(item, occurrences.get(item) + 1); //this will be needed!
//		}
//
//
//
//		for (int i = 0; i < 39; i++) {
//			for (String[] item : commands) {
//				String item1 = item[0].substring(0, 1) + item[1];
//				String item2 = item[1] + item[0].substring(0, 1);
//				long amount = occurrences.get(item[0]);
//				occurrences.replace(item1, occurrences.get(item1) + amount);
//				occurrences.replace(item2, occurrences.get(item2) + amount);
//			}
//		}
//
//		//int[] count = new int[doom.length()];
//
//		long[] cout = getAnddSort(occurrences);
//
//		String doom = "";
//
//
//
//		for (int i = 0; i < line.length(); i++) {
//			if (!doom.contains(line.substring(i, i + 1)) || doom.length() == 0) {
//				doom += line.substring(i, i + 1);
//			}
//		}
//
//
//
////		for (int i = 0; i < line.length(); i++) {
////			int index = doom.indexOf(line.charAt(i));
////			count[index] += 1;
////		}
//
//		int high = 0;
//		int low = 999999999;
//
//		for (int item : count){
//			if (high < item) {high = item;}
//			if (item < low) {low = item;}
//		}
//
//		output = (high - low) + "";

		return output;
	}

//	public long[] getAnddSort(Map<String, Long> input) {
//
//
//		List<String> letters = new ArrayList<>();
//
//		for (Map.Entry<String, Long> entry : input.entrySet()) {
//			if (!letters.contains(entry.getKey().substring(0, 1))) {
//				letters.add(entry.getKey().substring(0, 1));
//			}
//			if (!letters.contains(entry.getKey().substring(1, 2))) {
//				letters.add(entry.getKey().substring(1, 2));
//			}
//		}
//		long[] count = new long[letters.size()];
//
//
//		int index = 0;
//		for (Map.Entry<String, Long> entry : input.entrySet()) {
//			count[index] = entry.getValue();
//			index++;
//		}
//
//	}

	public String getString(List<String> input) {
		return input.get(0);
	}

	public List<String[]> commandTransform(List<String> input) {
		List<String[]> output = new ArrayList<>();

		for (String item : input) {
			if (item.contains(" -> ")) {
				String[] temp = item.split(" -> ");
				output.add(temp);
			}
		}

		return output;
	}

	public Map<String, String> commands(List<String> input) {
		Map<String, String> output = new HashMap<>();

		for (String item : input) {
			if (item.contains(" -> ")) {
				String[] temp = item.split(" -> ");
				output.put(temp[0], temp[1]);
			}
		}

		return output;
	}

	public Map<String, Long> occurences(List<String> input) {
		Map<String, Long> output = new HashMap<>();

		for (String item : input) {
			if (item.contains(" -> ")) {
				String[] temp = item.split(" -> ");
				long tmp = 0;
				output.put(temp[0], tmp);
			}
		}

		return output;
	}

	@Override
	public String part2(List<String> input) {
		String output = "Maybe some other day :(";

//		String line = getString(input);
//
//		//Map<String, String> commands = commands(input);
//		List<String[]> commands = commandTransform(input);
//		Map<String, Long> occurrences = occurences(input);
//
//		for (int i = 0; i < line.length() - 1; i++) {
//			String item = line.substring(i, i +2);
//			occurrences.replace(item, occurrences.get(item) + 1); //this will be needed!
//		}
//
//
//
//		for (int i = 0; i < 40; i++) {
//			for (String[] item : commands) {
//				String item1 = item[0].substring(0, 1) + item[1];
//				String item2 = item[1] + item[0].substring(0, 1);
//				long amount = occurrences.get(item[0]);
//				occurrences.replace(item1, occurrences.get(item1) + amount);
//				occurrences.replace(item2, occurrences.get(item2) + amount);
//			}
//		}
//
//
//
//

		return output;
	}
}
