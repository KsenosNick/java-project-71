package hexlet.code;

import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Reader {
    public static String read(String path) throws Exception {
        Path filePath = Paths.get(path).toAbsolutePath().normalize();

        if (!Files.exists(filePath)) {
            throw new FileNotFoundException("File '" + filePath + "' does not exist");
        }

        return Files.readString(filePath);
    }
}
