package ro.sda.bubblesort;

import java.util.Scanner;

public class Menu {
    private final int EXIT_OPTION = 0;

    public void displayMenu() {
        displayMenu(new int[0]);
    }

    private void displayMenu(int[] array) {
        int option = -1;
        displayOptions();
        option = readOption();
        int[] newArray = processOption(option, array);
        if(option!=EXIT_OPTION) {
            displayMenu(newArray);
        }
    }

    private void displayOptions() {
        System.out.println("1. Read Array");
        System.out.println("2. Sort Array");
        System.out.println("3. Display Array");
        System.out.println("0. Exit");
        System.out.println();
    }

    private int readOption() {
        System.out.print("Option: ");
        return new Scanner(System.in).nextInt();
    }

    private int[] readArray() {
        System.out.print("Input length: ");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Input element " + i + ": ");
            array[i] = scanner.nextInt();
        }
        return array;
    }

    private void displayArray(int[] array) {
        System.out.print("Your array is: [");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println("]");
    }

    private int[] processOption(int option, int[] array) {
        BubbleSort bs = new BubbleSort();
        switch (option) {
            case 1:
                return readArray();
            case 2:
                bs.sortArray(array);
                break;
            case 3:
                displayArray(array);
            case 0:
            default:
        }
        return array;
    }
}
