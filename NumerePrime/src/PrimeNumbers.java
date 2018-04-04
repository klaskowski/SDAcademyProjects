import java.util.Scanner;

public class PrimeNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Type number: ");
        int primeCount = sc.nextInt();
        int[] primes = new int[primeCount];

        for (int i = 0, j = 2; i < primeCount; j++) {
            int nrDiviz = 0;
            for(int k = 1; k <= j; k++){
                if(j % k == 0){
                    nrDiviz ++;
                }
            }
            if(nrDiviz == 2){
                primes[i] = j;
                i++;
            }
        }
        System.out.println("The first " + primeCount + " prime numbers are: ");
        for(int z = 0; z < primes.length; z++){
            System.out.println(primes[z]);
        }
    }
}
