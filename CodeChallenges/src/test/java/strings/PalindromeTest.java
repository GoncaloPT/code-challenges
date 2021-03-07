package strings;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class PalindromeTest {


    @ParameterizedTest
    @MethodSource("isPalindromeData")
    public void isPalindrome(String value, boolean expetectedResult) {
        assertEquals(new Palindrome().isPalindrome(value), expetectedResult);
    }

    private static Stream<Arguments> isPalindromeData() {
        return Stream.of(
                Arguments.of("aba", true),
                Arguments.of("asddas", false)
        );
    }
}