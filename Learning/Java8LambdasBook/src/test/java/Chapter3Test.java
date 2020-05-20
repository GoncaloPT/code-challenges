import chapter3.Chapter3;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Chapter3Test {

    @ParameterizedTest
    @MethodSource("generateTest6Data")
    public void testExercise6(String word, long exceptedResult) {
        long result = new Chapter3().exercice6(word);
        Assertions.assertEquals(result, exceptedResult);
    }

    static Stream<Arguments> generateTest6Data() {
        return Stream.of(
                Arguments.arguments("ponteiro", 8),
                Arguments.arguments("ponteir", 7)
        );
    }

    @Test
    public void testExercice2() {

        long expectedCount = 9;
        List<Chapter3.Artist> artists = Stream.of(
                new Chapter3.Artist("The band", "Lisboa", Stream.of(
                        new Chapter3.Artist("Goncalo", "Lisboa"),
                        new Chapter3.Artist("Goncalo2", "Lisboa"),
                        new Chapter3.Artist("Goncalo3", "Lisboa")
                )),
                new Chapter3.Artist("The band with 2 members", "Moon",
                        Stream.of(
                                new Chapter3.Artist("Goncalo", "Lisboa"),
                                new Chapter3.Artist("Goncalo2", "Lisboa")
                        )),
                new Chapter3.Artist("The band with 4 members", "Moon",
                        Stream.of(
                                new Chapter3.Artist("Goncalo", "Lisboa"),
                                new Chapter3.Artist("Goncalo2", "Lisboa"),
                                new Chapter3.Artist("Goncalo3", "Lisboa"),
                                new Chapter3.Artist("Goncalo4", "Lisboa")
                        ))
        ).collect(Collectors.toList());

        long count = new Chapter3().exercice2(artists);
        Assertions.assertEquals(expectedCount, count);
    }



    @Test
    public void advancedExercise1() {
        Stream<String> stream = Stream.of("um", "dois", "tres");
        Chapter3 c3 = new Chapter3();

        //List<StringWrapper> list = c3.map(stream, (s) -> new StringWrapper(s));
        c3.mapToStream(stream, (s) -> new StringWrapper(s)).forEach(System.out::println);

    }
    @Test
    public void advancedExercise2(){
        Stream<String> stream = Stream.of("um", "dois", "tres");
        Chapter3 c3 = new Chapter3();

        List<String> list = c3.filterAndCollectToList(stream, (s) -> s.equals("um"));
        Assertions.assertEquals(list.size(),1);

    }

    /**
     * Find the String with the largest number of lowercase letters from a List<String>.
     * You can return an Optional<String> to account for the empty list case.
     */
    @Test
    public void testExercice7() {
        List<String> testCase = Stream.of("tudoemminisculo", "TUDOMAISCULO", "minusculoEMAISCULO").collect(Collectors.toList());
        Optional<String> expectedResult = Optional.of("tudoemminisculo");

        Optional<String> output = new Chapter3().exercise7(testCase);
        Assertions.assertEquals(expectedResult, output);

    }

    /**
     * Find the String with the largest number of lowercase letters from a List<String>.
     * You can return an Optional<String> to account for the empty list case.
     */
    @Test
    public void testExercice7_version2() {
        List<String> testCase = Stream.of("tudoemminisculo", "TUDOMAISCULO", "minusculoEMAISCULO").collect(Collectors.toList());
        Optional<String> expectedResult = Optional.of("tudoemminisculo");

        Optional<String> output = new Chapter3().exercise7_version2(testCase);
        Assertions.assertEquals(expectedResult, output);
    }
    @Test
    public void testExercice7_version3() {
        List<String> testCase = Stream.of("tudoemminisculo", "TUDOMAISCULO", "minusculoEMAISCULO").collect(Collectors.toList());
        Optional<String> expectedResult = Optional.of("tudoemminisculo");

        Optional<String> output = new Chapter3().exercise7_version3(testCase);
        Assertions.assertEquals(expectedResult, output);
    }

    public static void main(String [] args){
        new Chapter3Test().advancedExercise1();
    }

    @Data
    @AllArgsConstructor
    @ToString
    public static class StringWrapper {
        private String value;
    }
}
