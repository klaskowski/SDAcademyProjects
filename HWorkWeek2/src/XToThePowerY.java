import java.util.Scanner;

public class XToThePowerY {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Input the value of X: ");
        int x = sc.nextInt();
        System.out.print("input the value of Y: ");
        int y = sc.nextInt();

        long power = 1;
        for(int i = 1; i <= y; i++){
            power = power*x;
        }
        System.out.println("X to the power of Y is: " + power);
    }
}
