package interviewprepkit.array;
/*
 * Create by: @author silvagc in 04/05/2020
 */

import java.io.PrintStream;
import java.util.Scanner;
import java.util.Set;

public class NewYearChaos {
    private static final String INVALID_STATE_MESSAGE = "Too chaotic";
    private final PrintStream out;
    public NewYearChaos(PrintStream out) {
        this.out = out;
    }

    public NewYearChaos() {
        this.out = System.out;
    }

    /**
     * With custom algorithm
     * The idea is to check how many have bribed me
     *
     * @param q
     */
    void minimumBribes(int[] q) {
        int bribes = 0;
        for (int i = 0; i < q.length; i++) {
            int currentValue = q[i];
            int expectedValue = i +1;

            if (currentValue - expectedValue > 2) {
                out.println(INVALID_STATE_MESSAGE);
                return;
            }
            for (int bribeIndex = i-1; bribeIndex >= 0 && bribeIndex > currentValue -3; bribeIndex--) {
                if (currentValue < q[bribeIndex]) {
                    //i was bribed
                    bribes++;
                }
            }
        }
        out.println(bribes);
    }


    // trying bubbleSort first, it works but it-s slow O(n^2)
    void minimumBribesBubble(int[] q) {
        int bribes = 0;

        for (int pass = 0; pass < q.length - 1; pass++) {
            for (int i = 0; i < q.length - pass - 1; i++) {
                int currentValue = q[i];
                int expectedValue = i + 1;
                if (currentValue > expectedValue) {
                    if (currentValue - expectedValue > 2) {
                        out.println(INVALID_STATE_MESSAGE);
                        return;
                    }
                }

                // sort
                if (q[i] > q[i + 1]) {
                    q[i] = q[i + 1];
                    q[i + 1] = currentValue;
                    bribes++;
                }
            }
        }


        out.println(bribes);

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] q = new int[n];

            String[] qItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int qItem = Integer.parseInt(qItems[i]);
                q[i] = qItem;
            }

            new NewYearChaos().minimumBribes(q);
        }

        scanner.close();
    }

}
