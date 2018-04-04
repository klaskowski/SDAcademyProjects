import java.util.Scanner;

public class NumberDays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Type a month:");
        int month = sc.nextInt();
        System.out.print("Type an year");
        int year = sc.nextInt();

        if ((month == 1) || (month == 3) || (month == 5) || (month == 7) || (month == 8) || (month == 10) || (month == 12)) {
            System.out.println("Your month has 31 days");
        }
        if ((month == 4) || (month == 6) || (month == 9) || (month == 11)) {
            System.out.println("Your month has 30 days");
        }
        if (month == 2) {
            if (year % 4 != 0) {
                System.out.println("Your month has 28 days");
            } else if (year % 100 != 0) {
                System.out.println("Your month has 29 days");
            } else if (year % 400 != 0) {
                System.out.println("Your month has 28 days");
            } else {
                System.out.println("Your month has 29 days");
            }
        }

    }
}
