package interviewprepkit.dictionariesandhashmaps;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/*
 * Create by: @author silvagc
 * 14/05/2020
 */
public class RansomNoteTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @ParameterizedTest
    @MethodSource()
    void checkMagazineTest(String[] magazineInput, String[] noteInput, String expetedResponse) {
        new RansomNote(new PrintStream(outContent)).checkMagazine(magazineInput, noteInput);
        assertEquals(expetedResponse, outContent.toString().trim());
    }

    public static Stream<Arguments> checkMagazineTest() {
        return Stream.of(
                Arguments.of(
                        new String[]{
                                "ive", "got a lovely", "bunch of coconuts"
                        },
                        new String[]{
                                "ive", "got", "some", "coconuts"
                        },
                        "No"
                ),
                Arguments.of(
                        new String[]{
                                "two", "times", "three", "is", "not", "four"
                        },
                        new String[]{
                                "two", "times", "two", "is", "four"
                        },
                        "No"
                ),
                Arguments.of(
                        new String[]{
                                "give", "me", "one", "grand", "today", "night"
                        },
                        new String[]{
                                "give", "one", "grand", "today"
                        },
                        "Yes"
                )


        );

    }

}