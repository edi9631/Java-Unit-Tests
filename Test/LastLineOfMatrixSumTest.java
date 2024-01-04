import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.stream.Stream;

class LastLineOfMatrixSumTest{
    @ParameterizedTest
    @MethodSource("provideTestData")
    public void testLastLineOfMatrixSum(int[][] matrix, double expected) {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(stream));

        double result = LastLineOfMatrixSum.lastLineOfMatrixSum(matrix);

        assertEquals(expected, result, 0.01);
    }
    private static Stream<Arguments> provideTestData() {
        return Stream.of(
                Arguments.of(new int[][]{{1,2,3},{4,5,6}},15),
                Arguments.of(new int[][]{{1,2},{3,4}},7),
                Arguments.of(new int[][]{{9,5},{3,8}},11),
                Arguments.of(new int[][]{{6,8},{13,-3}},10),
                Arguments.of(new int[][]{{3,5},{-3,-3}},-6)
        );
    }}
