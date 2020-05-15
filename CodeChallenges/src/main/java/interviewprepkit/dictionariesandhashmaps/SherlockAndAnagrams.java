package interviewprepkit.dictionariesandhashmaps;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * Create by: @author silvagc
 * 07/05/2020
 */
public class SherlockAndAnagrams {

    private static Pattern ONE_OR_MORE_REPEATED_CHARS_PATTERN = Pattern.compile("/\\(.\\)\1\\{1,}");

    int sherlockAndAnagramsWithRegex(String input) {
        int matches = 0;
        Matcher matcher = ONE_OR_MORE_REPEATED_CHARS_PATTERN.matcher(input);
        while (matcher.find()) {
            matches++;
            int startIndex = matcher.start();
            System.out.println(matcher.group());
        }
        return matches;
    }

    int sherlockAndAnagramsBruteForce(String s) {

        Set<String> possibilities = new HashSet<>();
        Map<String, Integer> matches = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                char[] fromBeg = s.substring(i, j).toCharArray();
                Arrays.sort(fromBeg);
                String sortedValue = String.valueOf(fromBeg);
                if (!possibilities.add(sortedValue)) {
                    matches.put(sortedValue, matches.getOrDefault(sortedValue, 0) + 1);
                }
            }
        }
        int match = 0;
        /**
         * Usei o factorial visto que :
         * 1 match ( existe 2 vezes ) conta 1 anagrama
         * 2 match ( existe 3 vezes ) conta 3 anagramas
         * 3 match ( existe 4 vezes ) conta 6 anagramas
         */
        for (Map.Entry<String, Integer> entry : matches.entrySet()) {
            int fact = 0;
            for (int i = entry.getValue(); i > 0; i--) {
                fact += i;
            }
            match += fact;

        }

        return match;

    }

    // we must find all the repeated chars, but also the repeated combinations
    int sherlockAndAnagrams(String s) {
        Map<Character, List<Integer>> charMap = new HashMap<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (!charMap.containsKey(c)) {
                charMap.put(c, new LinkedList<>());
            }
            charMap.get(c).add(i);
        }
        int matches = 0;
        for (Map.Entry<Character, List<Integer>> entry : charMap.entrySet()) {
            List<Integer> foundIndex = entry.getValue();

            if (foundIndex.size() < 2) {
                //remove chars that are not duplicated for performance ?
                continue;
            }
            matches++;
            int firstIndex = foundIndex.get(0);
            int lastndex = foundIndex.get(foundIndex.size() - 1);
            if (lastndex - firstIndex > 1) {
                matches++;
            }


        }
        return matches;
    }


}
