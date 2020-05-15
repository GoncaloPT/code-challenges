package interviewprepkit.array;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

/**
 * https://www.hackerrank.com/challenges/2d-array/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=arrays
 *
 * A major improvement would be to iterate only half of the array
 */
public class TwoDArrayDS {

    /**
     * receives an array and the start point
     *
     * @param square
     * @return
     */
    public static int sumHourGlass(int[][] arr, int startX, int startY) {

        if(arr.length < startY+3 || arr[startY].length < startX+3)
            return Integer.MIN_VALUE;
        int[][] clone = Arrays.stream(arr)
                .skip(startY).limit(startY+3)
                .map(a -> Arrays.copyOfRange(a,startX,startX+3))
                .toArray(int[][]::new);


        int sum = 0;
        clone[1][0] = 0;
        clone[1][2] = 0;
        for (int yIndex = 0; yIndex < 3; yIndex++) {

            for (int xIndex = 0; xIndex < 3; xIndex++) {
                System.out.print(clone[yIndex][xIndex]+ " ");
                sum += clone[yIndex][xIndex];
            }
            System.out.println(" ");
        }
        System.out.println(" ");
        return sum;

    }

    // Complete the hourglassSum function below.
    public static int hourglassSum(int[][] arr) {
        int max = Integer.MIN_VALUE;
        for (int y = 0; y < arr.length; y++) {
            for (int x = 0; x < arr[y].length; x++) {
                int sum = sumHourGlass(arr, x, y);
                if (sum > max) {
                    max = sum;
                }
                ;
            }
        }
        return max;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //Writer out = new FileWriter(System.getenv("OUTPUT_PATH"));
        Writer out = new OutputStreamWriter(new BufferedOutputStream(System.out));
        BufferedWriter bufferedWriter = new BufferedWriter(out);

        int[][] arr = new int[6][6];
/*
        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }
*/
        int result = hourglassSum(matrix);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }

    static int[][] matrix =
            {
                    {
                            -1, -1, 0, -9, -2, -2
                    },
                    {
                            -2, -1, -6, -8, -2, -5
                    },
                    {
                            -1, -1, -1, -2, -3, -4
                    },
                    {
                            -1, -9, -2, -4, -4, -5
                    },
                    {
                            -7, -3, -3, -2, -9, -9
                    },
                    {
                            -1, -3, -1, -2, -4, -5
                    }
            };
}
