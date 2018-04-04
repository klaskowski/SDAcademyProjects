import java.util.Scanner;

public class LuniAnArr {
    public static void main(String[] args) {
        String[] monthNames = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};

        for(String i : monthNames){
            System.out.println(i);
        }

        Scanner sc = new Scanner(System.in);
        System.out.print("Type the number of a month: ");
        int monthNumber = sc.nextInt();
        if (monthNumber < 1 || monthNumber > 12) {
            System.out.println("Input a valid month number");
        } else {
            String monthName = monthNames[monthNumber - 1];
            System.out.println("Your month is: " + monthName);
        }
    }
}
