package org.main;

import java.util.Scanner;

public class Task1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter message to be encrypted: ");
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.equals("EOF")) {
                break;
            }

            String[] parts = line.split(" ");
            int key = Integer.parseInt(parts[0]);
            String text = parts[1];

            String encryptedText = encrypt(text, key);
            System.out.println(encryptedText);
        }

        scanner.close();
    }

    public static String encrypt(String text, int key) {
        int numRows = (int) Math.ceil((double) text.length() / key);
        char[][] grid = new char[numRows][key];

        int index = 0;
        int textLength = text.length();

        for (int col = 0; col < key; col++) {
            for (int row = 0; row < numRows; row++) {
                if (index < textLength) {
                    grid[row][col] = text.charAt(index);
                    index++;
                } else {
                    grid[row][col] = ' ';
                }
            }
        }

        StringBuilder result = new StringBuilder();

        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < key; col++) {
                char currentChar = grid[row][col];
                if (currentChar != ' ') {
                    result.append(currentChar);
                }
            }
        }

        return result.toString();
    }
}
