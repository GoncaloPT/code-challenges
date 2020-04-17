package javachapter.stringproblems;

import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/**
 * https://www.hackerrank.com/challenges/pattern-syntax-checker/problem?utm_campaign=challenge-recommendation&utm_medium=email&utm_source=24-hour-campaign
 *
 */
public class PatternSyntaxChecker {


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());
        while(testCases>0){
            String pattern = in.nextLine();
            try {
                Pattern.compile(pattern);
                System.out.println("Valid");
            }
            catch(PatternSyntaxException pse){
                System.out.println("Invalid");
            }
            testCases--;
        }
    }
}
