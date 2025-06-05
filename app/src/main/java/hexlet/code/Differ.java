package hexlet.code;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static hexlet.code.Comparator.compare;
import static hexlet.code.Formater.format;
import static hexlet.code.Parser.parse;
import static hexlet.code.Reader.read;

public class Differ {
    public static String generate(String filePath1, String filePath2, String format) throws IOException {
        String fileContent1 = read(filePath1);
        String fileContent2 = read(filePath2);

        Map<String, Object> data1 = parse(fileContent1);
        Map<String, Object> data2 = parse(fileContent2);

        List<Map<String, Object>> difference = compare(data1, data2);

        String result = format(difference, format);

        System.out.println(result);

        return result;
    }
}
