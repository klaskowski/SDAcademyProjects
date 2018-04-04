import java.util.Scanner;

public class ReadNumbersHigherThen0 {
    public static void main(String[] args) {
        checkNumbers(5);
    }

    static void checkNumbers(int maxNumbers) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input number: ");
        int number = sc.nextInt();
        int max = number;
        int min = number;
        int countPoz = 0;
        if (number > 0) {
            countPoz++;
        }
        int totalCount = 1;
        while (countPoz < maxNumbers) {
            System.out.println("Input number: ");
            number = sc.nextInt();
            if (number > 0) {
                countPoz++;
            }
            if (number > max) {
                max = number;
            }
            if (number < min) {
                min = number;
            }
            totalCount++;
        }
        System.out.println("You entered " + maxNumbers + " numbers higher then 0, out of " + totalCount + " numbers");
        System.out.println("The maximum number is: " + max + " and the minimum is: " + min);
    }
}
