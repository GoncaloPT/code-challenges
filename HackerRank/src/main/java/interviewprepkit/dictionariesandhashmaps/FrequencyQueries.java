package interviewprepkit.dictionariesandhashmaps;

/*
 * Create by: @author silvagc
 * 13/05/2020
 */

import java.util.*;

public class FrequencyQueries {
    // Complete the freqQuery function below.

    List<Integer> freqQuery(List<List<Integer>> queries) {
        // actual value -> number of times
        Map<Integer, Integer> database = new HashMap<>();
        // number of times -> ammount of values that are being repetead
        Map<Integer, Integer> top = new HashMap<>();
        List<Integer> output = new LinkedList<>();
        for (List<Integer> query : queries) {
            int operation = query.get(0);
            Integer value = query.get(1);
            switch (operation) {
                case 1:
                    int numberOfRepetions = database.getOrDefault(value, 0);
                    database.put(value, numberOfRepetions + 1);
                    //we must update topMap - increase value to numberOfRepetions +1
                    top.computeIfPresent(numberOfRepetions, (k, v) -> v < 1 ? 0 : --v);
                    top.put(numberOfRepetions+1, top.getOrDefault(numberOfRepetions+1,0)+1);
                    break;


                case 2:
                    //remove operation
                    //decrease number of repetions from database
                    if(database.containsKey(value) && database.get(value) > 0) {
                        numberOfRepetions = database.get(value);
                        database.put(value, numberOfRepetions - 1);
                        // remove value from top set
                        top.computeIfPresent(numberOfRepetions-1, (k, v) -> ++v);
                        top.computeIfPresent(numberOfRepetions, (k, v) -> v < 1 ? 0 : --v);
                    }
                    break;
                default:
                    output.add((top.containsKey(value) && top.get(value) > 0) ? 1 : 0);
            }
        }
        return output;


    }


}
