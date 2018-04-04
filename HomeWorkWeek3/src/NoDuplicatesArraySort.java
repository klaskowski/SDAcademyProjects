import java.util.Scanner;

public class NoDuplicatesArraySort {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //Reading + displaying initial array
        System.out.print("Input number of elements in array: ");
        int arrayLength = sc.nextInt();
        int[] array1 = new int[arrayLength];
        System.out.println("Input array elements: ");
        for (int i = 0; i < arrayLength; i++) {
            array1[i] = sc.nextInt();
        }
        System.out.print("Your initial array is: ");
        for (int i = 0; i < arrayLength; i++) {
            System.out.print(array1[i] + " ");
        }
        System.out.println();

        //making a copy of the array and displaying it
        int[] array2 = new int[arrayLength];
        for (int i = 0; i < arrayLength; i++) {
            array2[i] = array1[i];
        }
        System.out.print("The copy of the array is: ");
        for (int i = 0; i < arrayLength; i++) {
            System.out.print(array2[i] + " ");
        }
        System.out.println();

        //order the array
        for (int i = 0; i < array2.length; i++) {
            for (int j = 0; j < array2.length; j++) {
                if (array2[i] < array2[j]) {
                    int aux = array2[j];
                    array2[j] = array2[i];
                    array2[i] = aux;
                }
            }
        }

        System.out.print("The ordered array is: ");
        for (int i = 0; i < array2.length; i++) {
            System.out.print(array2[i] + " ");
        }


        //checking for duplicates
        int index = array2.length;
        int[] noDuplicatesArray = new int[index];
        int i = 1;
        noDuplicatesArray[0] = array2[0];
        for (int j = 0; j < array2.length - 1; j++) {
            if (array2[j] != array2[j + 1]) {
                noDuplicatesArray[i] = array2[j+1];
                i++;
            } else {
                index--;
            }
        }

        System.out.println();
        System.out.print("The array with uniques is: ");
        for (int j = 0; j < index; j++) {
            System.out.print(noDuplicatesArray[j] + " ");
        }


    }

}
