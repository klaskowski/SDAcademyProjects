import java.util.Scanner;

public class TypeNPrimesNumbers {

    static void isPrime(int x){
        int count = 0;
        int number = 2;
        while(count < x){
            int noDiv = 0;
            for(int i = 2; i < (number/2); i++){
                if(number % i == 0){
                    noDiv++;
                }
            }
            if(noDiv == 0){
                count++;
                System.out.println(number + " is prime.");
            }
            number++;
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Input number of primes: ");
        int countMax = sc.nextInt();
            isPrime(countMax);

    }
}
