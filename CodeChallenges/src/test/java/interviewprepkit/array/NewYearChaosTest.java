package interviewprepkit.array;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.stream.Stream;


/*
 * Test for NewYearChaos from HackerRank
 *
 * Create by: @author silvagc
 * 05/05/2020
 */

public class NewYearChaosTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;




    @ParameterizedTest
    @MethodSource("minimumBribesBubbleData")
    void minimumBribes(int [] arr, int expectedResult) {
        new NewYearChaos(new PrintStream(outContent)).minimumBribes(arr);

        int result = Integer.parseInt(outContent.toString().trim());
        Assert.assertEquals(expectedResult,result);
    }


    @ParameterizedTest
    @MethodSource("minimumBribesBubbleData")
    void minimumBribesBubble(int [] arr, int expectedResult) {
        new NewYearChaos(new PrintStream(outContent)).minimumBribesBubble(arr);

        int result = Integer.parseInt(outContent.toString().trim());
        Assert.assertEquals(expectedResult,result);

    }

    public static Stream<Arguments> minimumBribesBubbleData(){
        return Stream.of(
                Arguments.of(new int[]{1, 3, 2, 4, 5}, 1),
                Arguments.of(new int[]{1, 3, 4, 2, 5}, 2),
                Arguments.of(new int[]{1 ,2 ,5 ,3 ,7 ,8 ,6 ,4}, 7)

        );


    }

}