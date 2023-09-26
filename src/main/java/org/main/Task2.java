package org.main;

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter sequence of numbers separated by spaces (N<10):");
        String input = scanner.nextLine();

        String[] numbers = input.split(" ");
        int numbersCount = numbers.length;

        if (numbersCount >= 3 && numbersCount < 10) {
            int[] sequence = new int[numbersCount];
            for (int i = 0; i < numbersCount; i++) {
                sequence[i] = Integer.parseInt(numbers[i]);
            }

            int[] nextElements = calculateNextElements(sequence, 3);

            System.out.println("Next three elements of sequence:");
            for (int i = 0; i < 3; i++) {
                System.out.print(nextElements[i] + " ");
            }
        } else {
            System.out.println("Incorrect number of numbers. N must be greater than or equal to 3 and less than 10.");
        }

        scanner.close();
    }

    public static int[] calculateNextElements(int[] sequence, int count) {
        int n = sequence.length;
        int[] result = new int[count];

        if (n >= 3) {
            int d1 = sequence[1] - sequence[0];
            int d2 = sequence[2] - sequence[1];

            int nextElement = sequence[n - 1] + d2;

            result[count - 3] = nextElement;
            result[count - 2] = nextElement + d1;
            result[count - 1] = nextElement + d1 + d2;
        } else if (n == 2) {
            int d1 = sequence[1] - sequence[0];
            int nextElement = sequence[1] + d1;

            result[count - 2] = nextElement;
            result[count - 1] = nextElement + d1;
        } else if (n == 1) {
            int nextElement = sequence[0] + 1;

            result[count - 1] = nextElement;
        }

        return result;
    }
}
