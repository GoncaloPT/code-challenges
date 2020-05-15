package beginner;

import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CapitalizeWithLambda {

    private static Pattern SPLIT_BY_SPACE = Pattern.compile("\\s+");

    public String capitalize(String phrase) {
        return SPLIT_BY_SPACE
                .splitAsStream(phrase)
                //.parallel()
                .map(word -> Character.toUpperCase(word.charAt(0)) + word.substring(1))
                .collect(Collectors.joining(" "));
    }

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        String testPhrase = "t  should be capitalized";
        int testSize = 100000;
        for (int i = 0; i < testSize; i++) {
            sb.append(testPhrase).append(i).append(" ");
        }

        String result = new CapitalizeWithLambda().capitalize(sb.toString());
        System.out.println("expected number of words: " + testSize*SPLIT_BY_SPACE.split(testPhrase).length);
        String[] splittedResult = SPLIT_BY_SPACE.split(result);
        System.out.println(" number of words: " + splittedResult.length);

        System.out.println("first word: " + splittedResult[0]);
        System.out.println("second word: " + splittedResult[1]);
        System.out.println("3rd word: " + splittedResult[2]);
        System.out.println("last word: " + splittedResult[testSize*SPLIT_BY_SPACE.split(testPhrase).length-1]);
        //System.out.println("Result " + result);
    }
}
