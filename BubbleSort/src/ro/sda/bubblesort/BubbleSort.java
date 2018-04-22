package ro.sda.bubblesort;

public class BubbleSort {

    public void sortArray(int[] array){
        boolean ordered = false;
        while (!ordered){
            ordered  = true;
            for (int i = 0; i < array.length-1; i++){
                if (array[i] > array[i+1]){
                    swapElements(array, i, i+1);
                    ordered = false;
                }
            }
        }
    }

    private void swapElements(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }



}
