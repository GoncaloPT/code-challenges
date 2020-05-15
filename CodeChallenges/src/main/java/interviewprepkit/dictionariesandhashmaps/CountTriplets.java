package interviewprepkit.dictionariesandhashmaps;

import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;

/*
 * Create by: @author silvagc
 * 12/05/2020
 *
 * ou are given an array and you need to find number of tripets of indices (i,j,k)  such that the elements at those indices are
 * in geometric progression for a given common ratio r and i < j < k.
 */
public class CountTriplets {


    /**
     * Algorithm creates a map of expected values and repetions in order to figure out if we have a triplet
     *
     * @param arr
     * @param r
     * @return
     */
    long countTripletsAttempt2(List<Long> arr, long r) {
        long triplets = 0;
        Map<Long, Long> expectedLevel2 = new HashMap<>();
        Map<Long, Long> expectedLevel3 = new HashMap<>();

        for (Long curr : arr) {
            long expectedValue = curr * r;
            if (expectedLevel3.containsKey(curr)) {
                triplets += expectedLevel3.get(curr);
            }
            if (expectedLevel2.containsKey(curr)) {
                Long count = expectedLevel2.get(curr);
                expectedLevel3.put(expectedValue, expectedLevel3.getOrDefault(expectedValue, 0L) + count);
            }

            expectedLevel2.put(expectedValue, expectedLevel2.getOrDefault(expectedValue, 0L) + 1);

        }
        return triplets;
    }

    /**
     * Optimizing for performance
     * optimization 1 )Remove repeated value and store them in a map
     * Still failing in one of the perf. test from hackerrank
     *
     * @param arr
     * @param r
     * @return
     */
    long countTripletsPerformance(List<Long> arr, long r) {
        long triplets = 0;
        Map<Long, Integer> repetionCount = new HashMap<>();
        List<Long> values = new ArrayList<>();
        for (Long curr : arr) {
            // is multiple of r
            if (!repetionCount.containsKey(curr)) {
                values.add(curr);
            }
            repetionCount.put(curr, repetionCount.getOrDefault(curr, -1) + 1);
        }

        if (values.size() < 3) {
            if (r == 1) {
                return combination(repetionCount.get(values.iterator().next()) + 1, 3);
            }
            return 0L;
        }
        Iterator<Long> it = values.iterator();
        Long curr = it.next();
        Long next = it.next();
        Long afterNext = it.next();
        boolean loopContinue = true;
        do {
            if (curr * r == next && next * r == afterNext) {
                triplets++;
                Integer currRepetitions = repetionCount.getOrDefault(curr, 0);
                Integer nextRepetitions = repetionCount.getOrDefault(next, 0);
                Integer afterNextRepetitions = repetionCount.getOrDefault(afterNext, 0);
                triplets += currRepetitions + nextRepetitions + afterNextRepetitions;
            }
            curr = next;
            next = afterNext;
            if (it.hasNext())
                afterNext = it.next();
            else
                loopContinue = false;
        }
        while (loopContinue);

        return triplets;

    }

    /**
     * nCr = (n!) / (r! * (n-r)!)
     *
     * @param n
     * @param r
     * @return
     */
    static long combination(int n, int r) {
        System.out.println("n " + n);
        System.out.println("r " + r);
        long comb = factorial(n).divide(
                (factorial(r).multiply(factorial(n - r)))).longValue();
        System.out.println("comb: " + comb);
        return comb;
    }

    static BigInteger factorial(int n) {
        BigInteger res = BigInteger.valueOf(1);
        for (int i = 2; i <= n; i++) {

            res = res.multiply(BigInteger.valueOf(i));
        }

        return res;
    }

    long countTriplets(List<Long> arr, long r) {
        long triplets = 0;
        for (int i = 0; i < arr.size(); i++) {
            Long iValue = arr.get(i);
            for (int j = i + 1; j < arr.size(); j++) {
                Long jValue = arr.get(j);
                if (iValue * r == jValue) {
                    for (int k = j + 1; k < arr.size(); k++) {
                        Long kValue = arr.get(k);
                        if (kValue == jValue * r) {
                            triplets++;
                        }
                    }
                }
            }
        }
        return triplets;

    }
}
