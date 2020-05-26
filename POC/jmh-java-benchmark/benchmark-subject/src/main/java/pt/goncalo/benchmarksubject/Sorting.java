package pt.goncalo.benchmarksubject;

import java.util.Arrays;
import java.util.Objects;

/*
 * Created by: @author Gonçalo Silva
 * 26/05/2020
 */
public class Sorting {


    /**
     * Creates a copy from the received array and sort it before returning
     * @param arr
     * @return copied array sorted in natural order
     * @throws IllegalArgumentException, if the array is empty
     * @throws NullPointerException, is the array is null
     */
    public static int[] sort(int [] arr){
        if(arr.length < 1){
            throw new IllegalArgumentException("arr should have values");
        }
        Objects.requireNonNull(arr, "Array should not be null");

        int[] copy = new int[arr.length];
        System.arraycopy(arr,0,copy, 0, arr.length);
        Arrays.sort(arr);
        return copy;
    }

    public static int[] bubbleSort(int[] arr) {
        if(arr.length < 1){
            throw new IllegalArgumentException("arr should have values");
        }
        Objects.requireNonNull(arr, "Array should not be null");
        int[] copy = new int[arr.length];
        System.arraycopy(arr,0,copy, 0, arr.length);
        for(int pass = 0 ; pass < copy.length ; pass++){
            for(int i = 0 ; i < copy.length-pass-1; i++){
                if (copy[i] > copy[i+1]){
                    //swap
                    int temp = copy[i];
                    copy[i] = copy[i+1];
                    copy[i+1] = temp;
                }
            }
        }
        return copy;
    }
}
