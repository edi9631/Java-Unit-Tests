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

public class AverageCalculatorTest {

    @ParameterizedTest
    @MethodSource("provideTestData")
    public void testCalculateAverage(double[] matrix, double expected) {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(stream));

        double result = AverageCalculator.calculateAverage(matrix);

        assertEquals(expected, result, 0.01);
    }


    private static Stream<Arguments> provideTestData() {
        return Stream.of(
                Arguments.of(new double[]{1,2,3,4},2.5),
                Arguments.of(new double[]{4,6,9,9},7),
                Arguments.of(new double[]{5,5,5,5},5),
                Arguments.of(new double[]{-3,-5,8,4},1),
                Arguments.of(new double[]{-15,-9,-4,-10},-9.5)
        );
    }
}
