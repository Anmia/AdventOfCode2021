package aoc.day03;

import aoc.Day;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day03 implements Day {

    @Override
    public String part1(List<String> input) {
        String output;

        int leng = input.get(0).length();

        int[] ones = new int[leng];

        Arrays.fill(ones, 0);

        for (String s : input) {
            for (int j = 0; j < s.length(); j++) {
                ones[j] = ones[j] + Integer.parseInt(s.substring(j, j + 1));
            }
        }

        String gamma = "";
        String epsilon = "";

        for (int one : ones) {
            if (one < (input.size() - one)) {
                gamma = gamma + "0";
                epsilon = epsilon + "1";
            } else {
                gamma = gamma + "1";
                epsilon = epsilon + "0";
            }
        }

        int x = binaryInt(gamma);
        int y = binaryInt(epsilon);

        output = (x * y) + "";

        return output;
    }

    public int binaryInt(String input) {
        int x = 1;
        int out = 0;

        for (int i = input.length(); i > 0; i--) {
            if (Integer.parseInt(input.substring(i - 1, i)) == 1) {
                out = out + x;
            }
            x = x * 2;
        }
        return out;
    }

    @Override
    public String part2(List<String> input) {
        String output;

        List<String> oxygenList = input;
        List<String> carbonList = input;
        String oxygen = "";
        String carbon = "";

        int length = input.get(0).length();

        for (int i = 0; i < length; i++) {
            int ones = bitCounter(oxygenList, i);
            int lengthOfList = oxygenList.size();
            int target = 0;
            if (ones >= lengthOfList - ones) {
                target = 1;
            }

            oxygenList = pruner(target, i, oxygenList);
            lengthOfList = oxygenList.size();
            if (lengthOfList == 1) {
                oxygen = oxygenList.get(0);
            }
        }

        for (int i = 0; i < length; i++) {
            int ones = bitCounter(carbonList, i);
            int lengthOfList = carbonList.size();
            int target = 0;
            if (ones < lengthOfList - ones) {
                target = 1;
            }

            carbonList = pruner(target, i, carbonList);
            lengthOfList = carbonList.size();
            if (lengthOfList == 1) {
                carbon = carbonList.get(0);
            }
        }

        int x = binaryInt(oxygen);
        int y = binaryInt(carbon);

        output = (x * y) + "";

        return output;
    }

    public int bitCounter (List<String> input, int position) {
        int output = 0;

        for (String item : input) {
            if (1 == Integer.parseInt(item.substring(position, position + 1))) {
                output++;
            }
        }

        return output;
    }

    public List<String> pruner(int target, int position, List<String> input) {
        List<String> output = new ArrayList<>();

        if (input.size() == 1) {
            output.add(input.get(0));
            return output;
        }

        for (String item : input) {
            if (Integer.parseInt(item.substring(position, position + 1)) == target) {
                output.add(item);
            }
        }

        return output;
    }
}
