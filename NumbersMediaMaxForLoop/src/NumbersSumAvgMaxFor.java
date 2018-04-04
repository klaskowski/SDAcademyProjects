import java.util.Scanner;

public class NumbersSumAvgMaxFor {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[] numbers = new int[5];
        int sum = 0;


        for(int i = 0; i < 5; i++) {
            System.out.print("Input number " + (i + 1) + ": ");
            numbers[i] = sc.nextInt();
            sum += numbers[i];
        }
        //The sum of the numbers
        int avg = sum/5;
        System.out.println("The sum of your numbers is: " + sum + " and the average is " + avg);
//Max and Min of the numbers
        int max = numbers[0];
        int min = numbers[0];
        for(int i = 1; i < 5; i++){
            if(max < numbers[i]){
                max = numbers[i];
            }
            if(min > numbers[i]){
                min = numbers[i];
            }
        }
        System.out.println("The maximum is: " + max);
        System.out.println("The minimum is: " + min);

//first element in the array to the power of the following = first element to the power of the product of the last four
        //multiply the last 4 elements
        long prod = 1;
        for(int i = 1; i < 5; i++) {
            prod = prod * numbers[i];
        }
        //raise the first element to the product of the last four elements
        long power = 1;

        for(int i = 1; i <= prod; i++){
            power = power * numbers[0];
        }
        System.out.println(power);

        System.out.println(Math.pow(numbers[0], prod));
    }
}
