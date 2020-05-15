package algorithms;

import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * For insertion sort a marker is placed after the first element
 * Left of the marker we have sorted elements, at right of the marker we have unsorted elements
 *
 */
public class InsertionSort {

    public static void sort(int[] elements){
        for(int markerPosition = 1 ; markerPosition < elements.length-1; markerPosition++ ){
            int temp = elements[markerPosition+1];
            for(int i = markerPosition; i >= 0 && temp < elements[i] ; i--) {
                elements[i + 1] = elements[i];
                elements[i] = temp;
            }
        }

    }


    public static void main(String [] args){

        /*
        Scanner scanner = new Scanner(System.in);

        Integer numOfTestCases = scanner.nextInt();
        int[][] testValues = new int[numOfTestCases][];
        for(int testCase = 0; testCase < numOfTestCases; testCase++){
            int sizeOfInput = scanner.nextInt();
            testValues[testCase] = new int[sizeOfInput];
            for(int size = 0; size < sizeOfInput; sizeOfInput++){
                testValues[testCase][size] = scanner.nextInt();
            }
            sort(testValues[testCase]);
        }
                 */
        int[][] testValues = new int[1][];
        testValues[0] = new int[]{1,5,3,4,9,2,0};
        sort(testValues[0]);

        Stream.of(testValues).forEach(x -> IntStream.of(x).forEach(System.out::println));


    }
}
