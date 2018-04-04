import java.util.Scanner;

public class PrimesArrayGreaterThenM {
    static int n;
    static int m;

    static void printArray(int[] myArray){
        for(int i = 0; i < n; i++){
            System.out.print(myArray[i] + "\t");
        }
    }

    static boolean checkPrime(int m){
            boolean prime = false;
            int i = 2;
            int noDiv = 0;
            while(i <= (m/2)) {
                if (m % i == 0) {
                    noDiv++;
                }
                i++;
            }
            if(noDiv == 0){
                prime = true;
            }
            return prime;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Input number of primes(n): ");
        n = sc.nextInt();
        System.out.print("Input minimum value of primes(m): ");
        m = sc.nextInt();
        int[] primesArray = new int[n];

        int checkedNo = m;
        int primesFound = 0;
        while(primesFound < n){
            if(checkPrime(checkedNo)){
                primesArray[primesFound] = checkedNo;
                primesFound++;
            }
            checkedNo++;
        }
        System.out.println("The first " + n + " primes greater then " + m + " are: ");
        printArray(primesArray);
    }
}
