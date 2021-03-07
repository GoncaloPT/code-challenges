package codingame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


public class StringSplit {



    /**
     * Regex version
     *
     * @param sentence
     * @param numberOfCharacters
     */
    public String splitRegex(String sentence, int numberOfCharacters) {
        var pattern = Pattern.compile("[\\s\\S]{"+numberOfCharacters+"}");
        return pattern.matcher(sentence)
                .results()
                .map(MatchResult::group)
                .reduce((x, y) -> x + System.lineSeparator() + y)
                .orElse("");
    }

    public String splitOldWay(String sentence, int numberOfCharacters){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i + (numberOfCharacters-1) < sentence.length(); i = i+numberOfCharacters){
            sb.append(sentence.subSequence(i,i+numberOfCharacters)).append(System.lineSeparator());
        }
        return sb.toString().stripTrailing();



    }

    
}
