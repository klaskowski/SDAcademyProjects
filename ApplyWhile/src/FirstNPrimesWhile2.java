import java.util.Scanner;

public class FirstNPrimesWhile2 {

    public static void printArray(int[] myArray){

        for (int i = 0; i < myArray.length; i++) {
            System.out.print(myArray[i] + " ");
        }

    }

    public static void findFirstNPrimes(int x){
        int count = 0;
        int number = 2;
        int[] numberList = new int[x];

        while (count < x) {
            int noDiv = 0;
            int j = 2;

            while (j <= (number / 2) && noDiv == 0) {
                if (number % j == 0) {
                    noDiv++;
                }
                j++;
            }

            if (noDiv == 0) {
                numberList[count] = number;
                count++;
            }
            number++;
        }
        printArray(numberList);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input number of primes: ");
        int countMax = sc.nextInt();
        findFirstNPrimes(countMax);

        System.out.print("Your prime numbers are: ");



    }
}
