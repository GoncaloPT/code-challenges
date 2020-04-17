package codility.arrays;


import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Find value that occurs in odd number of elements.
 * A non-empty array A consisting of N integers is given. The array contains an odd number of elements, and each element of the array can be paired with another element that has the same value, except for one element that is left unpaired.
 * <p>
 * For example, in array A such that:
 * <p>
 * A[0] = 9  A[1] = 3  A[2] = 9
 * A[3] = 3  A[4] = 9  A[5] = 7
 * A[6] = 9
 * the elements at indexes 0 and 2 have value 9,
 * the elements at indexes 1 and 3 have value 3,
 * the elements at indexes 4 and 6 have value 9,
 * the element at index 5 has value 7 and is unpaired.
 * Write a function:
 * <p>
 * class Solution { public int solution(int[] A); }
 * <p>
 * that, given an array A consisting of N integers fulfilling the above conditions, returns the value of the unpaired element.
 * <p>
 * For example, given array A such that:
 * <p>
 * A[0] = 9  A[1] = 3  A[2] = 9
 * A[3] = 3  A[4] = 9  A[5] = 7
 * A[6] = 9
 * the function should return 7, as explained in the example above.
 * <p>
 * Write an efficient algorithm for the following assumptions:
 * <p>
 * N is an odd integer within the range [1..1,000,000];
 * each element of array A is an integer within the range [1..1,000,000,000];
 * all but one of the values in A occur an even number of times.
 */
public class UnpairedElements {


    public int solution(int[] a) {
        Map<Integer, Boolean> uniqueElements = new HashMap();
        for (int i = 0; i < a.length; i++) {
            uniqueElements.compute(a[i], (k, v) -> v == null || !v);
        }
        for (Map.Entry<Integer, Boolean> key : uniqueElements.entrySet()) {
            if (key.getValue()) {
                return key.getKey();
            }
        }
        return -1;
    }

    public int functionSolution(int[] a) {
        Optional<Map.Entry<Integer, Long>> optEntry = IntStream.of(a).parallel()
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .parallelStream()
                .filter(entry -> entry.getValue() < 2).findFirst();
        return optEntry.isPresent() ? optEntry.get().getKey() : -1;


    }

    public int solutionWithoutMap(int[] a) {
        Set<Integer> uniqueElements = new HashSet();
        //assign to the last element
        int unique = a[a.length - 1];

        // stop at the first unique
        for (int i = 0; i < a.length; i++) {
            //already found
            if (uniqueElements.contains(a[i])) {
                continue;
            }
            if (isUnpaired(i, a, uniqueElements)) {
                unique = a[i];
                //unique found
                break;
            }
        }
        return unique;
    }

    public boolean isUnpaired(int curPos, int[] arr, Set<Integer> uniqueElements) {

        int unique = arr[curPos];
        for (int j = curPos + 1; j < arr.length; j++) {
            if (arr[j] == unique) {
                uniqueElements.add(unique);
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr = new int[201];
        for (int i = 0; i < 100; i++) {
            arr[i] = new Random(100).nextInt();
        }
        //duplicate the array
        for (int i = 100; i < 200; i++) {
            arr[i] = arr[i - 100];
        }
        arr[200] = 1001;

        int result = new UnpairedElements().solution(arr);
        if (result != 1001) {
            System.out.println("Wrong answer");
        } else {
            System.out.println("Correct answer");
        }
    }
}
