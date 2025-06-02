package hexlet.code;

import java.io.IOException;
import java.util.HashSet;
import java.util.Map;

import static hexlet.code.Parser.parse;
import static hexlet.code.Reader.read;

public class Differ {
    public static String generate(String filePath1, String filePath2, String format) throws IOException {
        String fileContent1 = read(filePath1);
        String fileContent2 = read(filePath2);

        Map<String, Object> data1 = parse(fileContent1);
        Map<String, Object> data2 = parse(fileContent2);

        System.out.println(data1);
        System.out.println(data2);

        return "{}";
    }
}
