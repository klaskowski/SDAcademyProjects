import java.util.Scanner;

public class XPrimSauNu {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Input the value of X: ");
        int x = sc.nextInt();
        int noDiv = 0;
        for(int i = 2; i < x; i++){
            if(x % i == 0){
                noDiv ++;
            }
        }
        if(noDiv == 0){
            System.out.println(x + " is a prime number");
        } else{
            System.out.println(x + " isn't a prime number");
        }
    }
}
