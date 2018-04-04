package ro.sda;

import java.util.Scanner;

public class Hello {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] name = new String[5];
        for (Integer i = 0; i < 5; i++) {
            System.out.print("Type name: ");
            name[i] = scanner.nextLine();
        }
        System.out.println("Hey");
        for (Integer i = 0; i < 5; i++) {
            System.out.print(name[i] + ", ");
        }
        System.out.println();
        System.out.println("Welcome to sda!");
    }


}
