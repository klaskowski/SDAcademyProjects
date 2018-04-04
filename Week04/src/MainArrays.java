import java.util.Scanner;

public class MainArrays {

    public static void printArray(int[] a, int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + "\t");
        }
    }

    public static int positionOfElementInArray(int[] a, int n, int e) {
        //pp initial ca acesta nu exista in array - primeste pozitia -1
        int pozitia = -1;
        int i = 0;
        while (pozitia < 0 && i < n) {
            if (a[i] == e) {
                pozitia = i;
            }
            i++;
        }
        return pozitia;
    }

    public static void removeDuplicates(int[] myArray, int n){
        int[] myUnique = new int[n];
        int nrOfUniqueElementsFound = 0;
        for(int i = 0; i < n; i++){
            int position = positionOfElementInArray(myArray, n, myArray[i]);
            if(position == i){
                myUnique[nrOfUniqueElementsFound] = myArray[i];
                nrOfUniqueElementsFound++;
            }
        }
       printArray(myUnique, nrOfUniqueElementsFound);
    }

    public static void main(String[] args) {
        /**
         *pozitie element in array
         */

        Scanner sc = new Scanner(System.in);
        System.out.print("Cititi n: ");
        int n = sc.nextInt();

        //citire array
        System.out.print("Cititi " + n + " elemente: ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        //afisare array
        printArray(a, n);
        System.out.println();

        //citim elementul cautat
        System.out.print("Cititi element cautat: ");
        int e = sc.nextInt();
        int pozitia = positionOfElementInArray(a, n, e);
        if (pozitia >= 0) {
            System.out.println("pozitia lui " + e + " este " + pozitia);
        } else {
            System.out.println("Elementul nu exista in array");
        }
        System.out.println("The array of unique is: ");
        removeDuplicates(a, n);
    }
}
