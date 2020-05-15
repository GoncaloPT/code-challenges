package javachapter.stringproblems;

import java.util.Scanner;

public class JavaStringReverse {

    /**
     * Easy pizzi
     * @param word
     * @return
     */
    public static boolean isPalindromeStringBuilder(String word){
        StringBuilder s = new StringBuilder(word);
        return word.equals(s.reverse());
    }

    /**
     * If the first half of the word is equal to the last, then is a palindrome
     * @param word
     * @return
     */
    public static boolean isPalindromeString(String word){
        char [] chars = word.toCharArray();
        for(int i = 0, j = chars.length-1; i <= j ; i++, j--){
            //System.out.println("current i " + i + " current j " + j);
            if(chars[i] != chars[j])
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String result = isPalindromeString(a)?"Yes":"No";
        System.out.println(result);

    }
}
