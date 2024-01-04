import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.stream.Stream;

class AsteriskTreeTest {

    @ParameterizedTest
    @MethodSource("provideTestData")
    public void testPrintOfAsteriskTree(int heightOfAsteriskTree, String expectedOutput) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        AsteriskTree.printAsteriskTree(heightOfAsteriskTree);
        System.setOut(System.out);
        String printedOutput = outputStream.toString().trim();
        Assertions.assertEquals(expectedOutput, printedOutput);
    }

    private static Stream<Arguments> provideTestData() {
        return Stream.of(
                Arguments.of(3, "*\n***\n*****"),
                Arguments.of(5, "*\n***\n*****\n*******\n*********")
        );
    }
}
