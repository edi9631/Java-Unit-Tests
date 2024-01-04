import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.stream.Stream;
class PalindromeTest {
    @ParameterizedTest
    @MethodSource("provideTestData")
    public void testCelsiusToFahrenheitAndFahrenheitToCelsius(String word, boolean expected) {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(stream));

        boolean actual = Palindrome.palindrome(word);

        assertEquals(expected, actual);
    }


    private static Stream<Arguments> provideTestData() {
        return Stream.of(
                Arguments.of("civic",true),
                Arguments.of("mimic", false),
                Arguments.of("wow", true),
                Arguments.of("racecar", true),
                Arguments.of("bumblebee", false)
        );
    }



}