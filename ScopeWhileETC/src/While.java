import java.util.Scanner;

public class While {
    static void isPrimeNumber(int x){

        int i = 2;
        while(i < x){
            int noDiv = 0;
            if(x % i == 0){
                noDiv++;
            }
            if(noDiv == 0){
                System.out.println("Numarul " + x + " este prim.");
            }
            i++;
        }

    }

    static void showPrimesUntilN(int n){
        for(int i = 2; i < n; i++){
            isPrimeNumber(i);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input number: ");
        int n = sc.nextInt();

        showPrimesUntilN(n);

    }
}
