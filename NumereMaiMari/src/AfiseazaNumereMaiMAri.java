import java.util.Scanner;

public class AfiseazaNumereMaiMAri {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Type a number: ");
        int nr1 = sc.nextInt();
        int max = nr1;

        System.out.print("Type a number: ");
        int nr2 = sc.nextInt();
        if(max < nr2){
            max = nr2;
        }
        System.out.print("Type next number: ");
        int nr3 = sc.nextInt();
        if(max < nr3){
            max = nr3;
        }
        System.out.print("Type another number: ");
        int nr4 = sc.nextInt();
        if(max < nr4){
            max = nr4;
        }
        System.out.print("And another number: ");
        int nr5 = sc.nextInt();
        if(max < nr5){
            max = nr5;
        }
        System.out.println("Maximum number is " + max);

        System.out.print("Numbers higher then " + nr1 + " are: ");
        if (nr2 > nr1) System.out.print(nr2 + " ");
        if (nr3 > nr1) System.out.print(nr3 + " ");
        if (nr4 > nr1) System.out.print(nr4 + " ");
        if (nr5 > nr1) System.out.print(nr5 + " ");
        System.out.println();
        int sum = nr1 + nr2 + nr3 + nr4 + nr5;
        if (sum == 100) {
            System.out.println("The sum is equal to 100");
        } else if (sum < 100) {
            System.out.println("The sum is lower then 100");
        } else {
            System.out.println("The sum in higher then 100");
        }
        /*int[] numbers = new int[5];

        for (int i = 0; i < 5; i++) {
            System.out.print("Type a number: ");
            numbers[i] = sc.nextInt();
        }
        int sum = numbers[0];
        System.out.print("Numbers higher then " + numbers[0] + " are: ");
        for (int i = 1; i < 5; i++) {
            if (numbers[i] > numbers[0]) System.out.print(numbers[i] + ", ");
            sum += numbers[i];
        }
        System.out.println();
        if (sum == 100) {
            System.out.println("The sum is equal to 100");
        } else if(sum < 100){
            System.out.println("The sum is lower then 100");
        } else {
            System.out.println("The sum is higher then 100");
        }
        int avg = sum/5;
        System.out.println("The average is: " + avg);
        System.out.println();
        System.out.print("The even numbers are: ");
        for(int i = 0; i < 5; i++){
            if(numbers[i] % 2 == 0){
                System.out.print(numbers[i] + " ");
            }
        }*/
    }
}

