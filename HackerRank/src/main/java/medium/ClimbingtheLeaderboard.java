package medium;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class ClimbingtheLeaderboard {

    private static final Scanner scanner = new Scanner(System.in);

    static int[] climbingLeaderboardOptimized(int[] scores, int[] alice) {
        int[] alicePosArray = new int[alice.length];
        int pos = 1;
        int aliceIndex = alice.length - 1;
        int lastPlace = 0;
        for (int i = 0; i < scores.length && aliceIndex >= 0; ) {
            if( scores[i] > alice[aliceIndex]){
                if (i == 0 || scores[i] != scores[i - 1]) {
                    pos++;
                }
                if(i == scores.length-1){
                    alicePosArray[aliceIndex] = lastPlace!=0?lastPlace:pos;
                    lastPlace = alicePosArray[aliceIndex];
                    aliceIndex--;
                }
                else{
                    i++;
                }
            }
            else if (scores[i] <= alice[aliceIndex]) {
                alicePosArray[aliceIndex] = pos;
                aliceIndex--;
                System.out.println("FOUND alicePosArray[" + aliceIndex + "] = " + pos);
            }
            System.out.println("i " + i);

            System.out.println("-------------------------");
        }
        System.out.println("LastAliceIndex = " + aliceIndex);
        System.out.println("Lastpos= " + pos);
        if (alicePosArray[0] < 1) {
            alicePosArray[0] = pos;
        }


        return alicePosArray;
    }

    // Complete the climbingLeaderboard function below.
    static Integer[] climbingLeaderboard(Integer[] scores, int[] alice) {

        List<Integer> alicePos = new ArrayList<Integer>(alice.length);

        Deque<Integer> scoreDeque = new ArrayDeque<Integer>() {
            @Override
            public boolean add(Integer e) {
                return !this.contains(e) && super.add(e);
            }

            @Override
            public boolean addAll(Collection<? extends Integer> c) {
                for (Integer element : c) {
                    this.add(element);
                }
                return true;
            }
        };

        scoreDeque.addAll(Arrays.asList(scores));

        for (Integer curAlice : alice) {
            int pos = 1;
            //Is alice last or first?
            if (curAlice > scoreDeque.getFirst()) {
                alicePos.add(pos);
            } else if (curAlice < scoreDeque.getLast()) {
                alicePos.add(scoreDeque.size() + 1);
            } else {
                for (Integer curScore : scoreDeque) {
                    if (curScore <= curAlice) {
                        alicePos.add(pos);
                        ;
                        break;
                    }
                    pos++;
                }
            }

        }

        return alicePos.<Integer>toArray(new Integer[0]);
    }

    public static void main2(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int scoresCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        Integer[] scores = new Integer[scoresCount];

        String[] scoresItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < scoresCount; i++) {
            int scoresItem = Integer.parseInt(scoresItems[i]);
            scores[i] = scoresItem;
        }

        int aliceCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] alice = new int[aliceCount];

        String[] aliceItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < aliceCount; i++) {
            int aliceItem = Integer.parseInt(aliceItems[i]);
            alice[i] = aliceItem;
        }

        Integer[] result = climbingLeaderboard(scores, alice);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }

    public static void main(String[] args) {
        int[] scores = new int[]{100, 100, 50, 40, 40, 20, 10};
        int[] scores2 = new int[]{100, 90, 90, 80, 75, 60};
        int[] scores3 = new int[]{
                295, 294, 291, 287, 287, 285, 285, 284, 283, 279, 277, 274, 274, 271, 270,
                268, 268, 268, 264, 260, 259, 258, 257, 255, 252, 250, 244, 241, 240, 237,
                236, 236, 231, 227, 227, 227, 226, 225, 224, 223, 216, 212, 200, 197, 196,
                194, 193, 189, 188, 187, 183, 182, 178, 177, 173, 171, 169, 165, 143, 140,
                137, 135, 133, 130, 130, 130, 128, 127, 122, 120, 116, 114, 113, 109, 106,
                103, 99, 92, 85, 81, 69, 68, 63, 63, 63, 61, 57, 51, 47, 46, 38, 30, 28, 25, 22
                , 15, 14, 12, 6, 4
        };

        int[] alice = new int[]{0,0,5, 25, 50, 120};
        int[] alice2 = new int[]{50, 65, 77, 90, 102};
        int[] alice3 = new int[]{
                5, 5, 6, 14, 19, 20, 23, 25, 29, 29, 30, 30, 32, 37, 38, 38, 38, 41, 41, 44, 45, 45, 47, 59, 59, 62, 63, 65, 67, 69, 70, 72, 72, 76, 79, 82, 83, 90, 91, 92, 93, 98, 98, 100, 100, 102, 103, 105, 106, 107, 109, 112, 115, 118, 118, 121, 122, 122, 123, 125, 125, 125, 127, 128, 131, 131, 133, 134, 139, 140, 141, 143, 144, 144, 144, 144, 147, 150, 152, 155, 156, 160, 164, 164, 165, 165, 166, 168, 169, 170, 171, 172, 173, 174, 174, 180, 184, 187, 187, 188, 194, 197, 197, 197, 198, 201, 202, 202, 207, 208, 211, 212, 212, 214, 217, 219, 219, 220, 220, 223, 225, 227, 228, 229, 229, 233, 235, 235, 236, 242, 242, 245, 246, 252, 253, 253, 257, 257, 260, 261, 266, 266, 268, 269, 271, 271, 275, 276, 281, 282, 283, 284, 285, 287, 289, 289, 295, 296, 298, 300, 300, 301, 304, 306, 308, 309, 310, 316, 318, 318, 324, 326, 329, 329, 329, 330, 330, 332, 337, 337, 341, 341, 349, 351, 351, 354, 356, 357, 366, 369, 377, 379, 380, 382, 391, 391, 394, 396, 396, 400
        };
        //Integer[] results = climbingLeaderboard(scores2, alice2);
        int[] results = climbingLeaderboardOptimized(scores, alice);
        Arrays.stream(results).forEach(System.out::println);
    }
}
