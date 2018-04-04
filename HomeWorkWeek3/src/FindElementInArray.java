import java.util.Scanner;

public class FindElementInArray {
    static Scanner sc = new Scanner(System.in);

    public static void readArray(int size, int[] myArray) {
        for (int i = 0; i < size; i++) {
            System.out.print("Input element " + i + " :");
            myArray[i] = sc.nextInt();
        }
    }

    public static void findElementWithinArray(int[] myArray, int elementToFind) {
        int i = 0;
        boolean foundElement = false;
        while (!foundElement && i < myArray.length) {

            if(myArray[i] == elementToFind){
                foundElement = true;
                System.out.print("Element position is " + i);
            }
            i++;
        }
        if(!foundElement){
            System.out.println("No such element!");
        }
    }

    public static void main(String[] args) {

        System.out.print("Input array size: ");
        int arraySize = sc.nextInt();

        int[] array1 = new int[arraySize];
        System.out.println("Input array elements: ");
        readArray(arraySize, array1);

        System.out.print("Your array is: ");

        for(int i = 0; i < arraySize; i++){
            System.out.println(array1[i] + " ");
        }

        System.out.println("Done reading array!");
        System.out.println();

        System.out.println("Input element to find: ");
        int elementToFind = sc.nextInt();
        System.out.println("Element to find is " + elementToFind);

        findElementWithinArray(array1, elementToFind);
    }

}
