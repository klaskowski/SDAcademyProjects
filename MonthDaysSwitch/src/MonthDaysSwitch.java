import java.util.Scanner;

public class MonthDaysSwitch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Type a month: ");
        int month = sc.nextInt();
        System.out.print("Type an year: ");
        int year = sc.nextInt();
        int daysCount = 0;
        switch (month) {

            case 2:
                if (year % 4 != 0) {
                    daysCount = 28;
                } else if (year % 100 != 0) {
                    daysCount = 29;
                } else if (year % 400 != 0) {
                    daysCount = 28;
                } else {
                    daysCount = 29;
                }
                break;
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                daysCount = 31;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                daysCount = 30;
                break;
            default:
                System.out.println("Invalid month!");
                break;
        }
        System.out.println("Month " + month + " has " + daysCount + " days");

    }
}
