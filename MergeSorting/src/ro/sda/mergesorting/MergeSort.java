package ro.sda.mergesorting;

public class MergeSort {
    public void sort(int[] array){
        mergeSort(array, 0, array.length-1);
    }

    private void mergeSort(int[] array, int i, int j){
        if(j-i > 1){
            int mid = (int)Math.floor((i + j) / 2);
            mergeSort(array, i, mid);
            mergeSort(array, mid+1, j);
            merge(array, i, j);
        }else if(array[i] > array[j]){
            swap(array, i, j);
        }
    }

    private void swap(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private void merge(int[] array,int start, int end){
        int mid = (int)Math.floor((start + end) / 2);
        int i = start;
        int j = mid + 1;
        int position = 0;
        int dimension = end - start + 1;
        int[] buffer = new int[dimension];
        while(position < dimension && i <= mid && j <= end){
            if(array[i] < array[j]){
                buffer[position] = array[i];
                i++;
            }else{
                buffer[position] = array[j];
                j++;
            }
            position++;
        }
        if(i <= mid){
            copyArray(array, buffer, position, i, mid-i);
        } else if(j <= end){
            copyArray(array, buffer, position, j, end-j);
        }
        copyArray(buffer, array, 0, start, dimension);

    }


    private void copyArray(int[] source, int[] dest, int destStart, int sourceStart, int dimension){
        for(int i = sourceStart, j = destStart, k= 0; k < dimension; i++, j++, k++){
            dest[j] = source[i];
        }
    }
}
