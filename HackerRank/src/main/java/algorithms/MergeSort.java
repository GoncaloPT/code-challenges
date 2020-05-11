package algorithms;

import java.util.Arrays;
import java.util.stream.IntStream;

/*
 * Create by: @author silvagc
 * 04/05/2020
 */
public class MergeSort {



    public void merge(int[] arr, int leftIndex, int rightIndex,int middle){
        int[] leftArray = Arrays.copyOfRange(arr,leftIndex, middle+1);
        int[] rightArray = Arrays.copyOfRange(arr,middle+1, rightIndex+1);
        int i = 0,j = 0;

        //k will start with leftIndex
        int k = leftIndex;

        while(i < leftArray.length && j < rightArray.length){
            if(leftArray[i] <= rightArray[j]){
                arr[k] = leftArray[i];
                i++;
            }
            else{
                //right is smaller
                arr[k] = rightArray[j];
                j++;
            }
            k++;
        }

        // check other elements, if any
        while ( i < leftArray.length){
            arr[k] = leftArray[i];
            i++;
            k++;
        }
        while ( j < rightArray.length){
            arr[k] = rightArray[j];
            j++;
            k++;
        }


    }
    public void sort(int [] arr, int leftIndex, int rightIndex){
        if(leftIndex < rightIndex){
            int middle = (rightIndex+leftIndex)/2;
            //left sort
            sort(arr,leftIndex,middle);
            //right sort
            sort(arr,middle+1,rightIndex);
            merge(arr,leftIndex,rightIndex,middle);
        }


    }

    public static void main(String [] args){
        int [] arr = {1,3,4,2,5};
        int [] expectedArr = IntStream.range(1,5).toArray();

        new MergeSort().sort(arr, 0, arr.length-1);

        IntStream.of(arr).forEach(System.out::print);


    }
}
