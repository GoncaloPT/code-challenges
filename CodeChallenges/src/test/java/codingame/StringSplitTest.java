package codingame;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StringSplitTest {

    @Test
    void shouldPrintCorrectly(){
        String test = "ABCDEF";
        String expectedResult = "ABC"+ System.lineSeparator()+"DEF";
        assertEquals(expectedResult,new StringSplit().splitRegex(test,3));
    }
    @Test
    void shouldPrintCorrectly2(){
        String test = "ABCDEF";
        String expectedResult = "ABC"+ System.lineSeparator()+"DEF";
        assertEquals(expectedResult,new StringSplit().splitOldWay(test,3));
    }

}