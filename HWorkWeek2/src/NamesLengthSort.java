import java.util.Scanner;

public class NamesLengthSort {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Input the number of names:");
        int n = sc.nextInt();

        String[] names = new String[n];

        System.out.println("Input names: ");

        for(int i = 0; i < n; i++){
            System.out.print("Name " + (i+1) + ": ");
            names[i] = sc.next();
        }

        //sort array after length

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(names[i].length() < names[j].length()){
                    String temp = names[i];
                    names[i] = names[j];
                    names[j] = temp;
                }
            }
        }

        System.out.println("Your ordered list (by length) is: ");
        for(int i = 0; i < n; i++){
            System.out.println(names[i]);
        }
    }
}
