import java.util.Scanner;

public class PrimeNumbersAscend {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input the number of primes: ");
        int n = sc.nextInt();
        System.out.print("Input he maximum value: ");
        int max = sc.nextInt();

        System.out.println("The primes your are looking for are (in ascending order): ");
        for (int i = 0, j = 2; i < n; ) {

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
            if (j == max) {
                return;
            } else {
                j++;
            }
        }
    }
}
