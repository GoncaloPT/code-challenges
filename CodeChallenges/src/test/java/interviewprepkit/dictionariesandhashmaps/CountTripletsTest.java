package interviewprepkit.dictionariesandhashmaps;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/*
 * Create by: @author silvagc
 * 12/05/2020
 */
class CountTripletsTest {

    @ParameterizedTest
    @MethodSource("countTripletsTestData")
    public void countTripletsTest(int r, Long[] inputArr, long expectedResult) {
        long result = new CountTriplets().countTriplets(List.of(inputArr), r);
        assertEquals(expectedResult, result);

    }

    @ParameterizedTest
    @MethodSource("countTripletsTestData")
    public void countTripletsPerformanceTest(int r, Long[] inputArr, long expectedResult) {
        long result = new CountTriplets().countTripletsPerformance(List.of(inputArr), r);
        assertEquals(expectedResult, result);

    }

    @ParameterizedTest
    @MethodSource("countTripletsTestData")
    public void countTripletsAttempt2Test(int r, Long[] inputArr, long expectedResult) {
        long result = new CountTriplets().countTripletsAttempt2(List.of(inputArr), r);
        assertEquals(expectedResult, result);

    }




    public static Stream<Arguments> countTripletsTestData() {
        return Stream.of(
                //Test case 1
                Arguments.of(
                        2,
                        new Long[]{
                                1L, 2L, 2L, 4L
                        },
                        2
                ),
                // Test case 2 1 3 9 9 27 81
                Arguments.of(
                        3,
                        new Long[]{
                                1L, 3L, 9L, 9L, 27L, 81L
                        },
                        6
                ),
                // Test case 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
                Arguments.of(
                        1,
                        new Long[]{
                                1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L,
                        },
                        161700
                )


        );
    }

}