package hexlet.code;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.IOException;
import static org.assertj.core.api.Assertions.catchThrowable;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.assertj.core.api.StrictAssertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DifferTest {

    public static Path getPath(String fileName) {
        return Paths.get("./src/test/resources/" + fileName).toAbsolutePath().normalize();
    }

    @ParameterizedTest
    @ValueSource(strings = {"yml", "json"})
    void testGenerate(String inputFormat) throws IOException {
        String file1Name = "file1." + inputFormat;
        String file2Name = "file2." + inputFormat;
        String expectedResult = """
                {
                  - follow: false
                    host: hexlet.io
                  - proxy: 123.234.53.22
                  - timeout: 50
                  + timeout: 20
                  + verbose: true
                }""";

        String filePath1 = getPath(file1Name).toString();
        String filePath2 = getPath(file2Name).toString();
        String format = "stylish";

        String actualResult = Differ.generate(filePath1, filePath2, format);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    void testGenerateIllegalArgumentException() {
        String file1Name = "file1.txt";
        String file2Name = "file2.txt";

        String filePath1 = getPath(file1Name).toString();
        String filePath2 = getPath(file2Name).toString();
        String format = "stylish";

        Throwable thrown = catchThrowable(
                () -> Differ.generate(filePath1, filePath2, format)
        );

        assertThat(thrown)
                .isInstanceOf(RuntimeException.class)
                .hasCauseInstanceOf(IllegalArgumentException.class);
    }
}
