import java.util.Scanner;

public class NoDuplicatesArrayWithExtraArray {

    public static boolean findElementWithinArray(int[] myArray, int elementToFind, int index) {
        int i = index+1;
        boolean foundElement = false;
        while (!foundElement && i < myArray.length) {
            foundElement = false;
            if (myArray[i] == elementToFind) {
                foundElement = true;
            }
            i++;
        }

        return foundElement;
    }

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

        //declarare array de output
        int[] array2 = new int[arrayLength];
        int uniqueElements = 0;
        for (int i = 0; i < array1.length; i++) {
            if (!findElementWithinArray(array1, array1[i], i)) {
                array2[uniqueElements] = array1[i];
                uniqueElements++;
            }
        }

        //afisare array output
        System.out.print("The uniques array is: ");
        for (int i = 0; i < uniqueElements; i++) {
            System.out.print(array2[i] + " ");
        }

    }
}
