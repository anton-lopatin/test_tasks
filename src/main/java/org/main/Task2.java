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

            int[] nextElements = findNextTreeElems(sequence);

            System.out.println("Next three elements of sequence:");
            for (int i = 0; i < 3; i++) {
                System.out.print(nextElements[i] + " ");
            }
        } else {
            System.out.println("Incorrect number of numbers. N must be greater than or equal to 3 and less than 10.");
        }

        scanner.close();
    }

    private static int[] calculateDifference(int[] sequence) {
        int length = sequence.length;

        if (length <= 1) {
            return sequence;
        }

        for (int index = 0; index < length - 1; index++) {
            if (sequence[index + 1] - sequence[index] == 0) {
                return sequence;
            }
        }

        int[] subArray = new int[length - 1];
        for (int index = 0; index < subArray.length; index++) {
            subArray[index] = sequence[index + 1] - sequence[index];
        }

        return calculateDifference(subArray);
    }

    private static int[] findNextTreeElems(int[] sequence) {
        double triangleNumber = (Math.sqrt(8 * sequence[0] + 1) - 1) / 2;
        if (triangleNumber == (int) triangleNumber && (int) triangleNumber != 1) {
            int[] differences = calculateDifference(sequence);
            int dif = sequence.length * differences[0] + 1;
            int nextElem1 = sequence[sequence.length - 1] + dif + differences[0];
            dif += differences[0];
            int nextElem2 = nextElem1 + dif + differences[1];
            dif += differences[0];
            int nextElem3 = nextElem2 + dif + differences[2];

            return new int[]{nextElem1, nextElem2, nextElem3};
        }

        int length = sequence.length;
        int[] result = new int[3];

        if (length >= 3) {
            int difference1 = sequence[1] - sequence[0];
            int difference2 = sequence[2] - sequence[1];

            int nextElement = sequence[length - 1] + difference2;

            result[0] = nextElement;
            result[1] = nextElement + difference1;
            result[2] = nextElement + difference1 + difference2;
        } else if (length == 2) {
            int d1 = sequence[1] - sequence[0];
            int nextElement = sequence[1] + d1;

            result[1] = nextElement;
            result[0] = nextElement + d1;
        } else {
            int nextElement = sequence[0] + 1;
            result[0] = nextElement;
        }
        return result;
    }
}
