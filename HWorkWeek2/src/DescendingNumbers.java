import java.util.Scanner;

public class DescendingNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Input the number of numbers: ");
        int n = sc.nextInt();

        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Input next number: ");
            numbers[i] = sc.nextInt();
        }
        System.out.print("Your input was: ");
        for (int i = 0; i < n; i++) {
            System.out.print(numbers[i] + ", ");
        }
        System.out.println();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (numbers[i] > numbers[j]) {
                    int temp = numbers[j];
                    numbers[j] = numbers[i];
                    numbers[i] = temp;
                }
            }
        }
        System.out.print("Your input in descending order is: ");
        for (int i = 0; i < n; i++) {
            System.out.print(numbers[i] + ", ");
        }
    }
}
