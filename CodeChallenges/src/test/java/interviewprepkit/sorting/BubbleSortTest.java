package interviewprepkit.sorting;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/*
 * Created by: @author Gonçalo Silva
 * 18/05/2020
 */
public class BubbleSortTest {

    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    @ParameterizedTest
    @MethodSource
    public void countSwapsTest(int[] input, String expectedOutput) {
        new BubbleSort(new PrintStream(outputStream)).countSwaps(input);
        assertEquals(expectedOutput, outputStream.toString());
Integer.compare()
    }


    private static Stream<Arguments> countSwapsTest() {
        return Stream.of(
                Arguments.of(
                        new int[]{3, 2, 1},
                        "Array is sorted in 3 swaps.\nFirst Element: 1\nLast Element: 3\n"
                )
        );
    }
}