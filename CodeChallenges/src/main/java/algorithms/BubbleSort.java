package algorithms;

import java.util.Scanner;
import java.util.stream.Stream;

/**
 * https://practice.geeksforgeeks.org/problems/bubble-sort/1
 * Bubble Sort is the simplest sorting algorithm that works by repeatedly swapping the adjacent elements if they are in wrong order.
 *
 *
 *
 */
public class BubbleSort {

    /**
     * Bubble sort:
     *
     * @param elements
     * @return
     */
    public static void bubbleSort(int[] elements){

        for(int pass = 0 ; pass < elements.length -1; pass++){

            for(int i = 0; i < elements.length-pass-1 ; i++){
                //compare with the next and swap if value[i] > value[i+1]
                if(elements[i] > elements[i+1]){
                    int temp = elements[i+1];
                    elements[i+1] = elements[i];
                    elements[i] = temp;
                }
            }
        }
    }

    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);

        Integer numOfTestCases = scanner.nextInt();
        int[][] testValues = new int[numOfTestCases][];
        for(int testCase = 0; testCase < numOfTestCases; testCase++){
            int sizeOfInput = scanner.nextInt();
            testValues[testCase] = new int[sizeOfInput];
            for(int size = 0; size < sizeOfInput; sizeOfInput++){
                testValues[testCase][size] = scanner.nextInt();
            }
            bubbleSort(testValues[testCase]);
        }

        Stream.of(testValues).forEach(x -> Stream.of(x).forEach(System.out::println));
    }
}
