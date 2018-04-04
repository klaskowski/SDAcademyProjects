import java.util.Scanner;

public class PrimesUntilNBoolean {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input number: ");
        int n = sc.nextInt();

        for (int i = 2; i < n; i++) {
            isPrimeNumber(i);
        }
    }

    static void isPrimeNumber(int x) {
        boolean noDiv = true;
        for (int i = 2; i < x; i++) {
            if (x % i == 0) {
                noDiv = false;
                return;
            }
        }

        if (noDiv = true) {
            System.out.println("Numarul " + x + " este prim.");
        }

    }
}
