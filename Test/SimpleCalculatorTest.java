import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;


public class SimpleCalculatorTest {
    @ParameterizedTest
    @MethodSource("provideTestData")
    public void testSimpleCalculator(double numberOne, double numberTwo, String operation, double expected) {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(stream));

        double result = SimpleCalculator.simpleCalculator(numberOne, numberTwo, operation);

        assertEquals(expected, result, 0.0001);
    }


    private static Stream<Arguments> provideTestData() {
        return Stream.of(
                Arguments.of(10.0, 5.0, "-", 5.0),
                Arguments.of(9.0, 6.0, "+", 15.0),
                Arguments.of(18, 9.5, "-", 8.5),
                Arguments.of(3, 4, "*", 12),
                Arguments.of(81, 9, "/", 9)
        );
    }

}