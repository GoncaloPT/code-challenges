package interviewprepkit.array;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * https://www.hackerrank.com/challenges/minimum-swaps-2/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=arrays
 */
public class MinimumSwap {

    // Complete the minimumSwaps function below.
    static int minimumSwaps(int[] arr) {
        //find smallest - always starts in 1

        /*
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (min > arr[i]) {
                min = arr[i];
            }
        }
        */

        int swaps = 0;
        Map<Integer, Integer> misplaced = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int curVal = arr[i];
            if (curVal != (i + 1)) {
                //its out of place
                misplaced.put(curVal, i);
            }
        }
        misplaced.entrySet().stream().forEach(entry-> System.out.println("value: " + entry.getKey() + " index " + entry.getValue()));

        for (int i = 0; i < arr.length; i++) {
            int curVal = arr[i];
            int expectedValue = i +1;
            if (curVal != expectedValue) {
                //it's out of place
                //let's find it, and them swap
                int index = misplaced.get(expectedValue);
                arr[i] = expectedValue;
                arr[index] = curVal;
                // misplaced must be updated
                misplaced.put(curVal,index);
                swaps++;
            }
        }
        return swaps;
    }

    // Complete the minimumSwaps function below.
    static int minimumSwaps2(int[] arr) {
        //find smallest
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (min > arr[i]) {
                min = arr[i];
            }
        }
        //first position
        int expectedValue = min;
        int position = 0;
        int swaps = 0;
        while (position < arr.length) {
            for (int i = position; i < arr.length; i++) {
                if (expectedValue == arr[i] && i != position) {
                    int temp = arr[position];
                    arr[position] = arr[i];
                    arr[i] = temp;
                    swaps++;
                }
            }
            expectedValue = arr[position] + 1;
            position++;

        }
        return swaps;
    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int res = minimumSwaps(arr);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}