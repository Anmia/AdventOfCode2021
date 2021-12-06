package aoc.day04;

import aoc.Day;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day04 implements Day {

    @Override
    public String part1(List<String> input) {
        String output = "";

        String[] splitString = input.get(0).split(",");
        int[] draw = new int[splitString.length];

        for (int i = 0; i < draw.length; i++) {
            draw[i] = Integer.parseInt(splitString[i]);
        }

        int[][][] boardLines = stringSplitter(input);

        int board = -1;
        int completionNumber = -1;
        int occurrence = 0;
        int bingoBall = 0;

        for (int i = 0; i < draw.length; i++) { // Number to check
            bingoBall = draw[i];
            for (int j = 0; j < boardLines.length; j++) { //Goes through rows and check occurrences
                for (int k = 0; k < 5; k++) {
                    int number = boardLines[j][k][0];
                    if (bingoBall == number) {
                        boardLines[j][k][1] = 1;
                    }
                }
            }

            for (int j = 0; j < boardLines.length - 1; j += 5) { //check for row or column completion for board
                for (int k = j; k < j + 5 && k < boardLines.length; k++) { // board rows
                    if (board != -1) {
                        break;
                    }
                    for (int l = 0; l < 5; l++) { //column
                        if (boardLines[k][l][1] == 1) {
                            occurrence++;
                        }
                    }

                    if (occurrence == 5) {
                        board = j;
                        completionNumber = bingoBall;
                        k = j + 5;
                        j = boardLines.length;
                        i = draw.length;
                    } else {
                        occurrence = 0;
                    }
                }

                if (completionNumber == -1) {
                    for (int k = 0; k < 5; k++) {
                        for (int l = j; l < j + 5 && k < boardLines.length; l++) {
                            if (boardLines[l][k][1] == 1) {
                                occurrence++;
                            }
                        }

                        if (occurrence == 5) {
                            board = j;
                            completionNumber = bingoBall;
                            k = 6;
                            j = boardLines.length + 1;
                            i = draw.length + 1;
                        } else {
                            occurrence = 0;
                        }
                    }
                }
            }
        }

        int sum = 0;
        for (int i = board; i < board + 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (boardLines[i][j][1] != 1) {
                    sum += boardLines[i][j][0];
                }
            }
        }

        output = (sum * completionNumber) + "";
        return output;
    }

    public int[][][] stringSplitter(List<String> input) {
        int length = 0;
        List<String> temp = new ArrayList<>();
        for (int i = 2; i < input.size(); i++) {
            if (input.get(i).length() != 0) {
                length++;
                temp.add(input.get(i));
            }
        }

        int[][][] output = new int[length][5][2];
        String line = "";
        String tempLine = "";

        for (int i = 0; i < temp.size(); i++) {
            line = temp.get(i);
            for (int j = 0; j < 5; j++) {
                tempLine = line.substring(j * 3, (j * 3) + 2);
                if (tempLine.contains(" ")){
                    output[i][j][0] = Integer.parseInt(tempLine.substring(1, 2));
                } else {
                    output[i][j][0] = Integer.parseInt(tempLine);
                }
                output[i][j][1] = 0;
            }
        }

        return output;
    }

    @Override
    public String part2(List<String> input) {
        String output = "";

        String[] splitString = input.get(0).split(",");
        int[] draw = new int[splitString.length];

        for (int i = 0; i < draw.length; i++) {
            draw[i] = Integer.parseInt(splitString[i]);
        }

        int[][][] boardLines = stringSplitter(input);

        int[] checkLine = new int[(boardLines.length + 1) / 5];
        Arrays.fill(checkLine, 0);

        for (int i = 0; i < boardLines.length; i += 5) {
            for (int j = 0; j < draw.length; j++) { // bingo balls
                int bingoBall = draw[j];
                for (int k = i; k < i + 5; k++) { //Goes through rows and check occurrences
                    for (int l = 0; l < 5; l++) {
                        int number = boardLines[k][l][0];
                        if (bingoBall == number) {
                            boardLines[k][l][1] = 1;
                        }
                    }
                }

                boolean boardRows = false;
                boolean boardColumn = false;
                for (int k = i; k < i + 5; k++) { //Check rows
                    boolean row = true;
                    for (int l = 0; l < 5; l++) {
                        if (boardLines[k][l][1] == 0) {
                            row = false;
                        }
                    }
                    if (row) {
                        boardRows = true;
                        break;
                    }
                }

                for (int k = 0; k < 5; k++) {
                    boolean column = true;
                    for (int l = i; l < i + 5; l++) {
                        if (boardLines[l][k][1] == 0) {
                            column = false;
                        }
                    }
                    if (column) {
                        boardColumn = true;
                        break;
                    }
                }

                if (boardRows || boardColumn) {
                    checkLine[i / 5] = j;
                    break;
                }
            }
        }

        int bigDraw = 0;
        int bigBoard = 0;

        for (int i = 0; i < checkLine.length; i++) {
            if (checkLine[i] > bigDraw) {
                bigDraw = checkLine[i];
                bigBoard = i * 5;
            }
        }

        bigDraw = draw[bigDraw];

        int sum = 0;
        for (int i = bigBoard; i < bigBoard + 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (boardLines[i][j][1] != 1) {
                    sum += boardLines[i][j][0];
                }
            }
        }

        output = (sum * bigDraw) + "";

        return output;
    }
}
