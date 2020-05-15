package interviewprepkit.array;

import org.junit.Assert;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/*
 * Create by: @author silvagc
 * 05/05/2020
 */
public class ArrayManipulationTest {

    @ParameterizedTest
    @MethodSource("arrayManipulationTestData")
    public void arrayManipulationTest(int n, int [][]queries, long expectedResult){
        long result = new ArrayManipulation().arrayManipulation(n,queries);
        Assert.assertEquals(expectedResult,result);

    }

    public static Stream<Arguments> arrayManipulationTestData(){
        return Stream.of(
                Arguments.of(
                        5,
                        new int[][]{
                                new int[]{1,2,100},
                                new int[]{2,5,100},
                                new int[]{3,4,100},
                        },
                        200
                ),
                Arguments.of(
                        10,
                        new int[][]{
                                new int[]{2,6,8},
                                new int[]{3,5,7},
                                new int[]{1,8,1},
                                new int[]{5,9,15},
                        },
                        31
                ),
                Arguments.of(
                        4,
                        new int[][]{
                                new int[]{2,3,603},
                                new int[]{1,1,286},
                                new int[]{4,4,882},

                        },
                        882
                )


        );
    }

}