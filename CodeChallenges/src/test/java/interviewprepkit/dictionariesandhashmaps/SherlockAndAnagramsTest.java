package interviewprepkit.dictionariesandhashmaps;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

/*
 * Create by: @author silvagc
 * 07/05/2020
 */
class SherlockAndAnagramsTest {

    @ParameterizedTest
    @CsvSource(
            {
                    "abba,4",
                    "ifailuhkqq,3",
                    "kkkk,10"
            })
    void sherlockAndAnagramsTest(String word, int expectedResult) {
        int result = new SherlockAndAnagrams().sherlockAndAnagrams(word);
        assertEquals(expectedResult, result);
    }

    @ParameterizedTest
    @CsvSource(
            {
                    "abba,4",
                    "ifailuhkqq,3",
                    "kkkk,10"
            })
    void sherlockAndAnagramsWithRegexTest(String word, int expectedResult) {
        int result = new SherlockAndAnagrams().sherlockAndAnagramsWithRegex(word);
        assertEquals(expectedResult, result);
    }

    @ParameterizedTest
    @CsvSource(
            {
                    "abba,4",
                    "ifailuhkqq,3",
                    "kkkk,10"
            })
    void sherlockAndAnagramsBruteForceTest(String word, int expectedResult) {
        int result = new SherlockAndAnagrams().sherlockAndAnagramsBruteForce(word);
        assertEquals(expectedResult, result);
    }





}