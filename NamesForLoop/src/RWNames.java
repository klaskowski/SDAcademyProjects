import java.util.Scanner;

public class RWNames {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] names = new String[5];

        for (int i = 0; i < 5; i++) {
            System.out.println("Type a name: ");
            names[i] = sc.nextLine();
        }
        System.out.println("Your name list is: ");

        /*for (String i : names) {
            System.out.println(i);
        }*/
        for (int i = 0; i < 5; i++) {
            System.out.println((i + 1) + "." + names[i]);
        }
        System.out.println("Your reversed name list: ");
        for (int i = 4,  j= 1; i >= 0; i--, j++) {
            //int j = 1;
            System.out.println(j + ". " + names[i]);
            //j++;
        }

        //for(String i: Arrays.reverse(names))
    }
}
