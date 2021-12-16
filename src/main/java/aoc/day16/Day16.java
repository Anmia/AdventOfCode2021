package aoc.day16;

import aoc.Day;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day16 implements Day {

	List<String> lim = new ArrayList<>();
	int god1 = 0;

	@Override
	public String part1(List<String> input) {
		String output = "wip";

		String line = input.get(0);
		Map<String, String> hexValues = hexValues();

		String translation = "";

		for (int i = 0; i < line.length(); i++) {
			translation += hexValues.get(line.substring(i, i + 1));
		}

		//output = dealer(translation, 0) + "";

		//dealer(translation);
		//output = god1 + "";

		return output;
	}

	public void dealer(String input) {
		String v = input.substring(0, 3);
		String t = input.substring(3, 6);
		String l = input.substring(6, 7);

		lim.add(v);

		int vInt = readBinary(v);

		if (t.matches("100")) {
			ifId4(input, vInt);
		} else {
			if (l.matches("0")) {
				not4is0(input.substring(7), vInt);
			} else if (l.matches("1")) {
				not4is1(input.substring(7), vInt);
			}
		}

		//return output;
	}

	public void ifId4(String input, int v) {
		god1 += v;
		boolean isZero = false;
		int index = 6;
		String tmp = "";
		while (!isZero){
			if (input.substring(index, index + 1).matches("0")){
				isZero = true;
			}

			tmp += input.substring(index + 1, index + 5);
			index += 5;
		}
		//return output;
	}

	public void not4is0(String input, int v) {
		god1 += v;
		int leng = readBinary(input.substring(0, 15));

		dealer(input.substring(15, 15 + leng));

		//return output;
	}

	public void not4is1(String input, int v) {
		god1 += v;
		int subPackLength = readBinary(input.substring(0, 11));

		int pos = 0;
		int temp = 0;

		for (int i = 0; i < subPackLength; i++) {
			dealer(input.substring(pos, pos + 11));
			pos += 11;
		}



		//return output;
	}

	public int readBinary(String input){
		int output = 0;
		String flip = "";
		for (int i = input.length() - 1; i >= 0 ; i--) {
			flip += input.substring(i, i + 1);
		}

		for (int i = 0; i < flip.length(); i++) {
			if (flip.substring(i, i + 1).matches("1")) {
				output += Math.pow(2, i);
			}
		}
		return output;
	}

	public Map<String, String> hexValues() {
		Map<String, String> output = new HashMap<>();

		output.put("0", "0000");
		output.put("1", "0001");
		output.put("2", "0010");
		output.put("3", "0011");
		output.put("4", "0100");
		output.put("5", "0101");
		output.put("6", "0110");
		output.put("7", "0111");
		output.put("8", "1000");
		output.put("9", "1001");
		output.put("A", "1010");
		output.put("B", "1011");
		output.put("C", "1100");
		output.put("D", "1101");
		output.put("E", "1110");
		output.put("F", "1111");

		return output;
	}

	public Map<String, String> binaryValues() {
		Map<String, String> output = new HashMap<>();

		output.put("0000", "0");
		output.put("0001", "1");
		output.put("0010", "2");
		output.put("0011", "3");
		output.put("0100", "4");
		output.put("0101", "5");
		output.put("0110", "6");
		output.put("0111", "7");
		output.put("1000", "8");
		output.put("1001", "9");
		output.put("1010", "A");
		output.put("1011", "B");
		output.put("1100", "C");
		output.put("1101", "D");
		output.put("1110", "E");
		output.put("1111", "F");

		return output;
	}

	@Override
	public String part2(List<String> input) {
		String output = "wip";

		return output;
	}
}
