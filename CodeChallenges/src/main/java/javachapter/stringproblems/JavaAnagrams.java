package javachapter.stringproblems;



import java.util.PriorityQueue;
import java.util.Scanner;



public class JavaAnagrams {

    /**
     * Creating a map for each letter and the number of ocurrences...
     * Not optimized!
     * Just to practice lambdas
     *
     * @param a
     * @param b
     * @return
     */
    static boolean isAnagram(String a, String b) {
        if(a.length() != b.length()){
            return false;
        }

        java.util.Map<Integer,Long> firstCharCountMap =
                a.toLowerCase().chars().boxed().collect(java.util.stream.Collectors.groupingBy( t-> t, java.util.stream.Collectors.counting()));

        java.util.Map<Integer,Long> secongCharCountMap =
                b.toLowerCase().chars().boxed().collect(java.util.stream.Collectors.groupingBy( t-> t, java.util.stream.Collectors.counting()));

        for(Integer key : firstCharCountMap.keySet()){
            if(firstCharCountMap.get(key) != secongCharCountMap.get(key)){
                return false;
            }
        }
        return true;
    }



    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println((ret) ? "Anagrams" : "Not Anagrams");
    }
}
