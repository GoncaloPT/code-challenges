package javachapter.stringproblems;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * To solve https://www.hackerrank.com/challenges/java-string-tokens/problem
 *  Given a string, , matching the regular expression [A-Za-z !,?._'@]+, split the string into tokens.
 *  We define a token to be one or more consecutive English alphabetic letters. Then, print the number of tokens, followed by each token on a new line.
 */
public class JavaStringTokens {


    public static String[] countAndSplit(String sentence, String splitRegex){
        sentence = sentence.trim();
        if(sentence.length() < 1){
            return new String[]{};
        }
        return Pattern.compile(splitRegex).split(sentence);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //String s = scan.nextLine();
        String s = " ";
        String [] result = countAndSplit(s,"[ !,?._'@]+");
        System.out.println(result.length);
        Arrays.stream(result).forEachOrdered(System.out::println);

        scan.close();
    }

}
