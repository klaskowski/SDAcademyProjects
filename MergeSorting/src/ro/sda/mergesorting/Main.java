package ro.sda.mergesorting;

public class Main {
    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        //int[] array = {3, 5, 8, 1, 2, 4, 7, 6};
        int[] array = {3, 5, 8, 1};
        display(array);
        mergeSort.sort(array);
        display(array);
    }

    private static void display(int[] array){
        for (int i = 0; i < array.length; i++){
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
