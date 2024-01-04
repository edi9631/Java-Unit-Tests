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
class FactorialTest {
    @ParameterizedTest
    @MethodSource("provideTestData")
    public void testCalculateFactorialOfNumber(int givenNumber, double expected) {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(stream));

        double result = Factorial.factorial(givenNumber);

        assertEquals(expected, result, 0.0001);
    }


    private static Stream<Arguments> provideTestData() {
        return Stream.of(
                Arguments.of(5, 120.00),
                Arguments.of(9, 362880.00),
                Arguments.of(6, 720.00),
                Arguments.of(4, 24.00),
                Arguments.of(1, 1.00)
        );
    }
    }
