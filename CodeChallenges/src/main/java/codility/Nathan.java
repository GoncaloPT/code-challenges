package codility;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Nathan {

    private Map<String, List<String>> testCaseMap = new HashMap<String, List<String>>();

    //score = #groups(passed) * 100 / #totalGroups, result floored
    public int solution(String[] testCases, String[] results) {


        // Group all the test cases by name
        for (int i = 0; i < testCases.length; i++) {
            String fullTestCaseName = testCases[i];
            String testCaseResult = results[i];

            String testCaseName = getTestCaseName(fullTestCaseName);

            List<String> groupResults = null;
            if (!testCaseMap.containsKey(testCaseName)) {
                testCaseMap.put(testCaseName, new LinkedList<String>());
            }
            groupResults = testCaseMap.get(testCaseName);
            groupResults.add(results[i]);
        }

        //testCaseMap.keySet().stream().forEach(System.out::println);
        int totalOfGroups = testCaseMap.size();
        int passedGroups = 0;
        // find the passed groups

        for (Map.Entry<String,List<String>> entry : testCaseMap.entrySet()) {
            if(allTestsPassed(entry.getValue())){
                passedGroups++;
            }
        }

        return passedGroups * 100 / totalOfGroups;
    }

    public boolean allTestsPassed(List<String> results) {
        for (String result : results) {
            if (!result.equals("OK"))
                return false;
        }
        return true;
    }

    public String getTestCaseName(String fullName) {
        int letterIndex = 0;
        boolean digitFound = false;
        for (int i = 0; i < fullName.length(); i++) {
            char c = fullName.charAt(i);
            // a digit was found, but digit are also part of the test case name
            if (digitFound && Character.isLetter(c)) {
                return fullName.substring(0, i);
            }
            //it's a number theb
            if (!Character.isLetter(c)) {
                digitFound = true;
            }


        }
        return fullName;
    }

}
