package chapter6;

import java.util.List;
import java.util.stream.IntStream;

public class Chapter6 {
    /**
     * The code in Example 6-10 sequentially sums the squares of numbers in a Stream. Make it run in parallel using streams.
     * Example 6-10. Sequentially summing the squares of numbers in a list public static int sequentialSumOfSquares(IntStream range) {
     * return range.map(x -> x * x)
     * .sum();
     * }
     */
    public Integer exercise1(IntStream range) {
        return range.parallel().map(x -> x * x).sum();
    }

    /**
     * The code in Example 6-11 multiplies every
     * number in a list together and multiplies the result by 5.
     * This works fine sequentially, but has a bug when running in parallel.
     * Make the code run in parallel using streams and fix the bug.
     */
    public int exercise2(List<Integer> linkedListOfNumbers) {
        /**
         * Original code
         * return linkedListOfNumbers.stream()
         *                 .reduce(5, (acc, x) -> x * acc);
         */
        return linkedListOfNumbers.parallelStream()
                .reduce(1, (acc, x) -> x * acc) * 5;

    }

    /**
     * The code in Example 6-12 also calculates the sum of the squares of numbers in a list.
     * You should try to improve the performance of this code without degrading its quality.
     * I’m only looking for you to make a couple of simple changes.
     * @return
     */
    public int exercise3(List<Integer> linkedListOfNumbers){
        /**
         * Original code
         */
        /*return linkedListOfNumbers.parallelStream()
                .map(x -> x * x)
                .reduce(0, (acc, x) -> acc + x);
        */
        return linkedListOfNumbers.parallelStream()
                .map(x -> x * x)
                .reduce(0, (acc, x) -> acc + x);


    }


}
