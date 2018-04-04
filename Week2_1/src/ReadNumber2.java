import java.util.Scanner;

public class ReadNumber2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int nr1 = 1548;
        int nr2 = 5897;
        System.out.print("Type next number: ");
        int nr3 = sc.nextInt();
        System.out.print("Type next number: ");
        int nr4 = sc.nextInt();
        System.out.print("Type next number: ");
        int nr5 = sc.nextInt();

        System.out.println("You typed " + nr1 + ", " + nr2 + ", " + nr3 + ", " + nr4 + ", " + nr5);
    }
}
