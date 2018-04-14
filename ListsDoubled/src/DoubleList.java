import java.util.Scanner;

public class DoubleList {

    static int capacity = 5;
    static int[] list = new int[capacity];
    static int lastPosition = -1;
    static Scanner sc = new Scanner(System.in);

    static void readList(int n) {
        for (int i = 0; i < n; i++) {
            add(sc.nextInt());
        }
    }

    static void increaseCapacity(){
        int[] newList = new int[capacity*2];
        copyList(list, newList);
        capacity = capacity*2;
        list = newList;
    }

    static void copyList(int[] source, int[] target){
        for(int i = 0; i < source.length; i++){
            target[i] = source[i];
        }
    }

    static void add(int value) {
        if(capacity == lastPosition+1){
            increaseCapacity();
        }
        list[lastPosition+1] = value;
        lastPosition++;

    }

    static void copyListDecrease(int[] source, int[] target, int count){
        for(int i = 0; i < count; i++)
            target[i] = source[i];
    }
//de testat!!!!!!!!!!!!!
    static void decreaseCapacity(){
        int[] newList = new int[capacity/2];
        copyListDecrease(list, newList, capacity/2);
        capacity /=2;
        list = newList;

    }


    static void remove(int index) {
        if (index >= 0 && index <= lastPosition) {
            int removedItem = list[index];
            for (int i = index; i < lastPosition; i++) {
                list[i] = list[i + 1];
            }
            lastPosition--;
            if(lastPosition < (capacity/2)){
                decreaseCapacity();
            }
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
        System.out.println("Input list elements: ");
        readList(n);

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
        System.out.println("Capacity is " + capacity);
        System.out.println();


//removing extra elements
        System.out.println("Input element to remove: ");
        int removeIndex1 = sc.nextInt();
        remove(removeIndex1);
        System.out.println("The list with element removed is: ");
        iterate();
        System.out.println("Capacity is " + capacity);
        System.out.println();
        System.out.println("Input element to remove: ");
        int removeIndex2 = sc.nextInt();
        remove(removeIndex2);
        System.out.println("The list with element removed is: ");
        iterate();
        System.out.println("Capacity is " + capacity);
        System.out.println();
//done removing extra elements


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
