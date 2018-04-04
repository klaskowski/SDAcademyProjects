import java.util.Scanner;

public class NoDuplicatesArray {

    public static void findElementWithinArray(int[] myArray, int elementToFind, int index) {
        int i = index+1;
        boolean foundElement = false;
        while (!foundElement && i < myArray.length) {
            foundElement = false;

            if(myArray[i] == elementToFind){
                foundElement = true;

            } else{
                foundElement = false;
            }
            i++;
        }
        if(!foundElement){
            System.out.print(elementToFind + " ");
        }
    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        //Reading + displaying initial array
        System.out.print("Input number of elements in array: ");
        int arrayLength = sc.nextInt();
        int[] array1 = new int[arrayLength];
        System.out.println("Input array elements: ");
        for(int i = 0; i < arrayLength; i++){
            array1[i] = sc.nextInt();
        }
        System.out.print("Your initial array is: ");
        for(int i = 0; i < arrayLength; i++){
            System.out.print(array1[i] + " ");
        }
        System.out.println();

        System.out.print("The array of uniques is: ");
        for(int i = 0; i < array1.length; i++){
            findElementWithinArray(array1, array1[i], i);
        }
    }
}
