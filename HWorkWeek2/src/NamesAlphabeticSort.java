import java.util.Scanner;

public class NamesAlphabeticSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input number of names: ");
        int n = sc.nextInt();

        String[] names = new String[n];
        System.out.println("Input names: ");
        for (int i = 0; i < n; i++) {
            System.out.print("Name " + (i + 1) + ": ");
            names[i] = sc.next();
        }
        System.out.println();
        System.out.println("You entered the names!");
        System.out.println();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (names[i].compareTo(names[j]) < 0) {
                    String temp = names[i];
                    names[i] = names[j];
                    names[j] = temp;
                }
            }
        }
        System.out.println("Your ordered name list (alphabetically) is: ");
        for (int i = 0; i < n; i++) {
            System.out.println(names[i]);
        }
    }
}
