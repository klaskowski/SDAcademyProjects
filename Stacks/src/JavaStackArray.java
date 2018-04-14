import java.util.Scanner;
import java.util.Stack;

public class JavaStackArray {
    public static void main(String[] args) {

        int top = -1;

        Scanner sc = new Scanner(System.in);
        System.out.println("Input the number of elements in stack: ");
        int maxSize = sc.nextInt();

        int[] stackArray = new int[maxSize];
        System.out.println("Input stack elements: ");
        for (int i = 0; i < maxSize; i++) {
            top++;
            stackArray[top] = sc.nextInt();

//            System.out.println("The top element is: " + stackArray[top + 1]);
        }

        if(top < maxSize - 1){

        }

    }

}
