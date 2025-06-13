package hexlet.code;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DifferTest {

    @Test
    void generate() throws IOException {
        String expectedResult = "{\n"
                + "  - follow: false\n"
                + "    host: hexlet.io\n"
                + "  - proxy: 123.234.53.22\n"
                + "  - timeout: 50\n"
                + "  + timeout: 20\n"
                + "  + verbose: true\n"
                + "}";

        String filePath1 = Paths.get("./src/test/resources/file1.json").toAbsolutePath().normalize().toString();
        String filePath2 = Paths.get("./src/test/resources/file2.json").toAbsolutePath().normalize().toString();
        String format = "stylish";

        String actualResult = Differ.generate(filePath1, filePath2, format);

        assertEquals(expectedResult, actualResult);
    }
}
