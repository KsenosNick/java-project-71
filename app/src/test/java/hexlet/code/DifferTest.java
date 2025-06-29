package hexlet.code;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static hexlet.code.Reader.read;
import static org.assertj.core.api.Assertions.catchThrowable;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.assertj.core.api.StrictAssertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DifferTest {
    private static String expectedResultStylish;
    private static String expectedResultPlain;
    private static String expectedResultJson;

    public static Path getPath(String fileName) {
        return Paths.get("./src/test/resources/input/" + fileName).toAbsolutePath().normalize();
    }

    @BeforeAll
    public static void setup() throws Exception {
        expectedResultStylish = read("./src/test/resources/expected/stylish.txt");
        expectedResultPlain = read("./src/test/resources/expected/plain.txt");
        expectedResultJson = read("./src/test/resources/expected/json.txt");
    }

    @ParameterizedTest
    @ValueSource(strings = {"yml", "json"})
    void testGenerateDefault(String inputFormat) throws Exception {
        String file1Name = "file1." + inputFormat;
        String file2Name = "file2." + inputFormat;

        String filePath1 = getPath(file1Name).toString();
        String filePath2 = getPath(file2Name).toString();
        String format = "stylish";

        String actualResult = Differ.generate(filePath1, filePath2, format);

        assertEquals(expectedResultStylish, actualResult);
    }

    @ParameterizedTest
    @ValueSource(strings = {"yml", "json"})
    void testGenerateStylish(String inputFormat) throws Exception {
        String file1Name = "file1." + inputFormat;
        String file2Name = "file2." + inputFormat;

        String filePath1 = getPath(file1Name).toString();
        String filePath2 = getPath(file2Name).toString();
        String format = "stylish";

        String actualResult = Differ.generate(filePath1, filePath2, format);

        assertEquals(expectedResultStylish, actualResult);
    }

    @ParameterizedTest
    @ValueSource(strings = {"yml", "json"})
    void testGeneratePlain(String inputFormat) throws Exception {
        String file1Name = "file1." + inputFormat;
        String file2Name = "file2." + inputFormat;

        String filePath1 = getPath(file1Name).toString();
        String filePath2 = getPath(file2Name).toString();
        String format = "plain";

        String actualResult = Differ.generate(filePath1, filePath2, format);

        assertEquals(expectedResultPlain, actualResult);
    }

    @ParameterizedTest
    @ValueSource(strings = {"yml", "json"})
    void testGenerateJson(String inputFormat) throws Exception {
        String file1Name = "file1." + inputFormat;
        String file2Name = "file2." + inputFormat;

        String filePath1 = getPath(file1Name).toString();
        String filePath2 = getPath(file2Name).toString();
        String format = "json";

        String actualResult = Differ.generate(filePath1, filePath2, format);

        assertEquals(expectedResultJson, actualResult);
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
