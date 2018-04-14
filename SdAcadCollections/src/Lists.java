import java.util.Scanner;

public class Lists {

    static int[] list = new int[5];
    static int lastPosition;
    static int capacity;
    static Scanner sc = new Scanner(System.in);

    static void readList(int lastPosition) {
        for (int i = 0; i <= lastPosition; i++) {
            list[i] = sc.nextInt();
        }
    }

    static void add(int value) {

        list[lastPosition+1] = value;
        lastPosition++;

    }

    static void remove(int index) {
        if (index >= 0 && index <= lastPosition) {
            int removedItem = list[index];
            for (int i = index; i < lastPosition; i++) {
                list[i] = list[i + 1];
            }
            lastPosition--;
        } else {
            System.out.println("Element out of bounds!!!");
        }
    }

    static void iterate() {
        for (int i = 0; i <= lastPosition; i++) {
            System.out.print(list[i] + " ");
        }
    }

    static int get(int index) {
        return list[index];
    }

    static void swap(int i, int j){
        int aux = list[i];
        list[i] = list[j];
        list[j] = aux;
    }

    static void sort(){
        for(int i = 0; i <= lastPosition; i++){
            for(int j = i; j <= lastPosition; j++){
                if(list[i] > list[j]){
                    swap(i, j);
                }
            }
        }
    }


    public static void main(String[] args) {

        System.out.println("Input n: ");
        int n = sc.nextInt();
        lastPosition = n-1;
        System.out.println("Input list elements: ");
        readList(lastPosition);

        System.out.print("The list is: ");
        iterate();
        System.out.println();

        System.out.println("Input element to add to the list: ");
        int value = sc.nextInt();
        add(value);
        System.out.print("The list with element added is: ");
        iterate();
        System.out.println();

        System.out.println("Input element to remove: ");
        int removeIndex = sc.nextInt();
        remove(removeIndex);
        System.out.println("The list with element removed is: ");
        iterate();
        System.out.println();

        System.out.println("What element you want to find?");
        int findIndex = sc.nextInt();
        System.out.println();
        System.out.print("The element in position " + findIndex + " is: ");
        System.out.println(get(findIndex));
        System.out.println();

        System.out.print("The ordered list is: ");
        sort();
        iterate();
    }
}
