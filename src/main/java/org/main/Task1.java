package org.main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Task1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter message to be encrypted: ");
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            String[] parts = line.split(" ");
            int columns = parts[0].length();
            String key = parts[0];
            String text = parts[1];


            String encryptedMessage = encode(key, fillMatrix(columns, text));
            System.out.println("Matrix: " + encryptedMessage);
        }
        scanner.close();
    }

    private static String[][] fillMatrix(int numColumns, String input) {
        int numRows = input.length() / numColumns;
        String[][] matrix = new String[numRows][numColumns];
        int index = 0;
        boolean isDigraph = true;

        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numColumns; col++) {
                if (index < input.length()) {
                    if (isDigraph) {
                        matrix[row][col] = input.substring(index, Math.min(index + 2, input.length()));
                        index += 2;
                    } else {
                        matrix[row][col] = input.substring(index, index + 1);
                        index += 1;
                    }
                    isDigraph = !isDigraph;
                } else {
                    matrix[row][col] = "";
                }
            }
        }

        printMatrix(numRows, numColumns, matrix);

        return matrix;
    }

    private static String encode(String keyString, String[][] matrix) {
        List<Integer> keyList = new ArrayList<>();
        StringBuilder encryptedText = new StringBuilder();
        for (int index = 0; index < keyString.split("").length; index++) {
            keyList.add(Integer.parseInt(keyString.split("")[index]));
        }

        for (int key = 0; key < keyList.size(); key++) {
            Integer minValue = Collections.min(keyList);
            int minIndex = keyList.indexOf(minValue);
            for (String[] strings : matrix) {
                if (!strings[minIndex].equals("")) {
                    encryptedText.append(strings[minIndex]);
                }
            }
            keyList.set(minIndex, Integer.MAX_VALUE);
        }
        return encryptedText.toString();
    }

    private static void printMatrix(int numRows, int numColumns, String[][] matrix) {
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numColumns; col++) {
                System.out.print((row + 1) + "." + (col + 1) + ")" + matrix[row][col]);
                if (col < numColumns - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
