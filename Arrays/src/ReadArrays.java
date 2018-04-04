import java.util.Scanner;

public class ReadArrays {

    public static void printArray(int[] myArray){
        System.out.println("Your array is: ");
        for(int i = 0; i < myArray.length; i++){
            System.out.print(myArray[i] + " ");
        }
    }

    public static void readArray(int[] myArray){
        Scanner sc = new Scanner(System.in);
        System.out.println("Input Array elements: ");
        for(int i = 0; i < myArray.length; i++){
            myArray[i] = sc.nextInt();
        }
    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        System.out.print("Input no elements");
        int x = sc.nextInt();
        int[] array1 = new int[x];
        readArray(array1);
        printArray(array1);



    }
}
