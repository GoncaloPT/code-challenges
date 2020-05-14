package interviewprepkit.dictionariesandhashmaps;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/*
 * Create by: @author silvagc
 * 13/05/2020
 */
public class FrequencyQueriesTest {

    @ParameterizedTest
    @MethodSource("freqQueryTestData")
    public void freqQueryTest(List<List<Integer>> inputQueries,
                              List<Integer> expectedOutput) {

        List<Integer> output = new FrequencyQueries().freqQuery(inputQueries);

        assertEquals(expectedOutput, output);
    }

    public static Stream<Arguments> freqQueryTestData() {
        return Stream.of(
                Arguments.of(
                        Stream.of(
                                Arrays.asList(1,5),
                                Arrays.asList(1, 6),
                                Arrays.asList(3, 2),
                                Arrays.asList(1, 10),
                                Arrays.asList(1, 10),
                                Arrays.asList(1, 6),
                                Arrays.asList(2, 5),
                                Arrays.asList(3, 2)
                        ).collect(Collectors.toList())
                        ,
                        Stream.of(
                                0,1
                        ).collect(Collectors.toList())
                ),
                //test case 2
                Arguments.of(
                        Stream.of(
                                Arrays.asList(1,5),
                                Arrays.asList(1, 6),
                                Arrays.asList(1, 6),
                                Arrays.asList(3, 2),
                                Arrays.asList(2, 6),
                                Arrays.asList(3, 1),
                                Arrays.asList(3, 2),
                                Arrays.asList(1, 10),
                                Arrays.asList(1, 10),
                                Arrays.asList(1, 6),
                                Arrays.asList(2, 5),
                                Arrays.asList(3, 2)
                        ).collect(Collectors.toList())
                        ,
                        Stream.of(
                                1,1,0,1
                        ).collect(Collectors.toList())
                ),
                // test case 3
                Arguments.of(
                        Stream.of(
                                Arrays.asList(1,3),
                                Arrays.asList(2, 3),
                                Arrays.asList(3, 2),
                                Arrays.asList(1, 4),
                                Arrays.asList(1, 5),
                                Arrays.asList(1, 5),
                                Arrays.asList(1, 4),
                                Arrays.asList(3, 2),
                                Arrays.asList(2, 4),
                                Arrays.asList(3, 2)
                        ).collect(Collectors.toList())
                        ,
                        Stream.of(
                                0,1,1
                        ).collect(Collectors.toList())
                ),
                // test case 4
                Arguments.of(
                        Stream.of(
                                Arrays.asList(3,4),
                                Arrays.asList(2, 1003),
                                Arrays.asList(1, 16),
                                Arrays.asList(3, 1)

                        ).collect(Collectors.toList())
                        ,
                        Stream.of(
                                0,1
                        ).collect(Collectors.toList())
                ),
                // test case 5
                Arguments.of(
                        Stream.of(
                                Arrays.asList(1,2),
                                Arrays.asList(2, 2),
                                Arrays.asList(2, 2),
                                Arrays.asList(3, 1),
                                Arrays.asList(1,2),
                                Arrays.asList(3, 1),
                                Arrays.asList(2, 2),
                                Arrays.asList(3, 1),
                                Arrays.asList(1,3),
                                Arrays.asList(1,3),
                                Arrays.asList(1,3),
                                Arrays.asList(2, 3),
                                Arrays.asList(3, 2),
                                Arrays.asList(2, 3),
                                Arrays.asList(3, 2)

                        ).collect(Collectors.toList())
                        ,
                        Stream.of(
                                0,1,0,1,0
                        ).collect(Collectors.toList())
                )


        );
    }

}