import java.util.Scanner;

public class ReadNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] number = new int[5];
        number[0] = 10;
        number[1] = 56;

        for (int i = 2; i < number.length-1; i++) {
            System.out.print("Type next number: ");
            number[i] = scanner.nextInt();
        }
        System.out.println("Hey, you entered: ");
        for (int i = 0; i < 5; i++) {
            System.out.print(number[i] + ", ");
        }
    }
}
