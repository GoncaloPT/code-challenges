package pt.goncalo.nio2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.lang.reflect.Executable;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.StandardOpenOption;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class TryoutsTest {


    @ParameterizedTest
    @MethodSource("writeTestData")
    void writeTest(Class<? extends Exception> expectedExceptionClass, final StandardOpenOption... options) {
        ;

        if (expectedExceptionClass != null) {
            assertThrows(expectedExceptionClass, () -> new Tryouts().tryingWrite("test.txt",options));
        } else {
            assertDoesNotThrow(() -> new Tryouts().tryingWrite("test.txt",options));
        }

    }

    private static Stream<Arguments> writeTestData() {
        return Stream.of(
                Arguments.of(
                        IllegalArgumentException.class,
                        new StandardOpenOption[]{
                                StandardOpenOption.APPEND, StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.DELETE_ON_CLOSE
                        }
                ),
                Arguments.of(
                        null,
                        new StandardOpenOption[]{
                                StandardOpenOption.APPEND, StandardOpenOption.CREATE_NEW, StandardOpenOption.DELETE_ON_CLOSE
                        }
                ),
                Arguments.of(
                        null,
                        new StandardOpenOption[]{
                                StandardOpenOption.CREATE_NEW, StandardOpenOption.DELETE_ON_CLOSE
                        }
                )

        );
    }


    @Test()
    void tryToWriteWithReadOpenOption() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Tryouts().tryToWriteWithReadOpenOption();
        });
    }
}