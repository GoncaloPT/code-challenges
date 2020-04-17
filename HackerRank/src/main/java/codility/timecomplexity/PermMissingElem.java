package codility.timecomplexity;

import java.util.Arrays;
import java.util.stream.IntStream;

public class PermMissingElem {
    public int solution(int[] a) {
        Arrays.sort(a);
        if(a.length == 0 || a[0] != 1){
            return 1;
        }

        for (int i = 0; i < a.length - 1; i++) {
            if(a[i] != a[i+1] -1){
                return a[i]+1;
            }
        }
        return a[a.length-1]+1;
        // write your code in Java SE 8
    }
}
