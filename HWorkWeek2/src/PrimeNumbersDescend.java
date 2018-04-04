import java.util.Scanner;

public class PrimeNumbersDescend {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Input the number of primes: ");
        int n = sc.nextInt();

        System.out.print("Input the maximum value: ");
        int max = sc.nextInt();

        for (int i = 0, j = max; j >= 2; ) {

            int nrDiv = 0;
            for (int k = 1; k <= j; k++) {
                if (j % k == 0) {
                    nrDiv++;
                }
            }
            if (nrDiv == 2) {
                i++;
                System.out.println(i + ": " + j);
            }
            if (i == n) {
                return;
            } else {
                j--;
            }
        }
    }
}
