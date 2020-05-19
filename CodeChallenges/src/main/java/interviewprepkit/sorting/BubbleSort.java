package interviewprepkit.sorting;

import java.io.PrintStream;

/*
 * Created by: @author Gonçalo Silva
 * 18/05/2020
 *
 *
 * Given an array of integers, sort the array in ascending order using the Bubble Sort algorithm above. Once sorted, print the following three lines:
 *
 *  Array is sorted in numSwaps swaps., where  is the number of swaps that took place.
 *  First Element: firstElement, where  is the first element in the sorted array.
 *  Last Element: lastElement, where  is the last element in the sorted array.
 *  Hint: To complete this challenge, you must add a variable that keeps a running tally of all swaps that occur during execution.
 */
public class BubbleSort {


    private final PrintStream out;
    public BubbleSort(PrintStream out){
        this.out = out;
    }

    // Complete the countSwaps function below.
    void countSwaps(int[] a) {
        int count = 0 ;
        //do the bubbleSort
        for(int pass = 0 ; pass < a.length ; pass++){
            for(int i = 0; i < a.length - pass -1; i++){
                if( a[i] > a[i+1] ){
                    int temp = a[i];
                    a[i] = a[i+1];
                    a[i+1] = temp;
                    count++;
                }
            }
        }

        out.println(String.format("Array is sorted in %d swaps.", count));
        out.println("First Element: " + a[0]);
        out.println("Last Element: " + a[a.length-1]);


    }
}
