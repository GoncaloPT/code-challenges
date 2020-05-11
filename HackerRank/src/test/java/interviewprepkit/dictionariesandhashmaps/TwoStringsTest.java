package interviewprepkit.dictionariesandhashmaps;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

/*
 * Create by: @author silvagc
 * 07/05/2020
 */
public class TwoStringsTest {

    @ParameterizedTest
    @CsvSource({
            "oi,i,YES",
            "oi,z,NO",
            "Hello,az,NO",
            "Hello,l,YES",
            "Hello,o,YES"
    })
    public void twoStringsTest(String s1, String s2, String expectedResult){
        var result = new TwoStrings().twoStrings(s1,s2);
        assertEquals(expectedResult,result);
    }



}