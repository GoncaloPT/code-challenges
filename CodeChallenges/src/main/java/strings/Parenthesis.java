package strings;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Checks if all the open parenthesis are closed
 */
public class Parenthesis {

    public boolean isValid(String parenthesis){

        int parenthesisStack = 0;
        for(char c: parenthesis.toCharArray()){
            if( c == '(') parenthesisStack ++;
            else if( c == ')'){
                parenthesisStack --;
            }
        }
        return parenthesisStack == 0;

    }
    public boolean isValidStream(String phrase){
        Map<String,Long> charCountMap = Stream.of(phrase)
                //remove other chars
                .filter(s -> s.equals("(") || s.equals(")"))
                .collect(Collectors.groupingBy(s-> s, Collectors.counting()));
        return charCountMap.get("(") == charCountMap.get(")");

    }
}
