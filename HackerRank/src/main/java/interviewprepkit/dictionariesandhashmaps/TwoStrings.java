package interviewprepkit.dictionariesandhashmaps;

import java.util.*;
import java.util.stream.Collectors;

/*
 * Create by: @author silvagc
 * 07/05/2020
 */
public class TwoStrings {

    private static final String YES = "YES";
    private static final String NO = "NO";

    String twoStrings(String s1, String s2) {

        Set<Character> set1 = s1.chars().mapToObj(c -> (char)c).collect(Collectors.toSet());
        for(Character c: s2.toCharArray()){
            if(set1.contains(c)){
                return YES;
            }
        }
        return NO;


    }

        // Complete the twoStrings function below.
    String twoStringsLambda(String s1, String s2) {

        return s1.chars().filter(
                c -> s2.chars().anyMatch(c2 -> c2 == c)
        ).count() > 0 ? "YES" : NO;


    }



}
