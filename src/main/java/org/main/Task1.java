package org.main;

import java.util.Arrays;
import java.util.Scanner;

public class Task1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter message to be encrypted: ");
        String line = scanner.nextLine();
        String[] parts = line.split(" ");
        int key = parts[0].length();
        String text = parts[1];


        System.out.println("Matrix: ");
        fillMatrix(key, text);

        scanner.close();
    }

    private static String[][] fillMatrix(int key, String input) {
        int numRows = (int) Math.ceil((double) input.length() / key);
        String[][] matrix = new String[numRows][key];
        int index = 0;
        boolean isD = true;

        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < key; col++) {
                if (index < input.length()) {
                    if (isD) {
                        matrix[row][col] = input.substring(index, Math.min(index + 2, input.length()));
                        index += 2;
                    } else {
                        matrix[row][col] = input.substring(index, index + 1);
                        index += 1;
                    }
                    isD = !isD;
                } else {
                    matrix[row][col] = "EOF";
                }
            }
        }
        return matrix;
    }
}
