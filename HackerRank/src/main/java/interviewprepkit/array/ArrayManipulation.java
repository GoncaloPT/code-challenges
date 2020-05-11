package interviewprepkit.array;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;


/*
 * Create by: @author silvagc
 * 05/05/2020
 */
public class ArrayManipulation {




    public long arrayManipulation(int n, int[][] queries){
        long[] arr = new long[n + 1];
        int [] diffArray = new int[n+2];

        for(int[] query : queries){
            int leftIndex = query[0];
            int rightIndex = query[1];
            int valueToSum = query[2];

            //update diff array
            diffArray[leftIndex] += valueToSum;
            diffArray[rightIndex +1] -= valueToSum;
        }
        arr[0] = diffArray[0];
        long max = arr[0];
        for(int i = 1 ; i < arr.length ; i++){
            arr[i] = diffArray[i] + arr[i-1];
            if(max <arr[i]){
                max = arr[i];
            }
        }
        return max;
    }

    /**
     * First solution, poor performance
     * @param n
     * @param queries
     * @return
     */
    public long arrayManipulationOn2(int n, int[][] queries) {
        //position 0 not used...
        long[] arr = new long[n + 1];
        long max = Integer.MIN_VALUE;
        for (int[] query : queries) {
            int leftIndex = query[0];
            int rightIndex = query[1];
            int valueToSum = query[2];

            for (int i = leftIndex; i <= rightIndex; i++) {
                arr[i] += valueToSum;
                if (max < arr[i]) {
                    max = arr[i];
                }
            }

        }
        return max;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        int[][] queries = new int[m][3];

        for (int i = 0; i < m; i++) {
            String[] queriesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 3; j++) {
                int queriesItem = Integer.parseInt(queriesRowItems[j]);
                queries[i][j] = queriesItem;
            }
        }

        long result = new ArrayManipulation().arrayManipulation(n, queries);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
