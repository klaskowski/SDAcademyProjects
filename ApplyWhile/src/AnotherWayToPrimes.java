import java.util.Scanner;

public class AnotherWayToPrimes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input the max number of primes: ");
        int maxPrimeNo = sc.nextInt();
        int primeCount = 0;
        int number = 2;

        while (primeCount < maxPrimeNo) {
            if (checkPrime(number) == true) {
                primeCount++;
            }
            number++;
        }
    }

    static boolean checkPrime(int x) {
        boolean prime = true;
        int i = 2;
        while (i <= (x / 2)) {
            if (x % i == 0) {
                System.out.println(x + " modulo " + i + " is 0. Exit.");
                prime = false;
                break;
            }
            System.out.println(x + " modulo " + i + " isn't 0. Continue.");
            i++;
        }
        /*for (int i = 2; i <= (x / 2); i++) {
            if (x % i == 0) {
                System.out.println(x + " modulo " + i + " is 0. Exit.");
                prime = false;
                break;
            } else {
                System.out.println(x + " modulo " + i + " isn't 0. Continue.");
            }
        }*/
        if (prime == true) {
            System.out.println(x + " is prime.");
        }
        return prime;
    }
}
