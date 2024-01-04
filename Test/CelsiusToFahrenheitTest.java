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

class CelsiusToFahrenheitTest {
    @ParameterizedTest
    @MethodSource("provideTestData")
    public void testCelsiusToFahrenheitAndFahrenheitToCelsius(double degree, String unit, double expected) {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(stream));

        double result = CelsiusToFahrenheit.celsiusToFahrenheit(degree, unit);

        assertEquals(expected, result, 0.01);
    }


    private static Stream<Arguments> provideTestData() {
        return Stream.of(
                Arguments.of(180.00,"f", 82.22),
                Arguments.of(100.00,"c", 212.00),
                Arguments.of(89.00, "f", 31.67),
                Arguments.of(47.00,"f", 8.33),
                Arguments.of(33.00, "c", 91.40)
        );
    }

}