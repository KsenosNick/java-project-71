package hexlet.code;

import java.util.List;
import java.util.Map;

import static hexlet.code.Comparator.compare;
import static hexlet.code.Formatter.format;
import static hexlet.code.Parser.parse;
import static hexlet.code.Reader.read;

public class Differ {
    public static String generate(String dataPath1, String dataPath2, String format) throws Exception {
        String data1Format = getDataFormat(dataPath1);
        String data2Format = getDataFormat(dataPath2);

        String dataContent1 = read(dataPath1);
        String dataContent2 = read(dataPath2);

        Map<String, Object> data1 = parse(dataContent1, data1Format);
        Map<String, Object> data2 = parse(dataContent2, data2Format);

        List<Map<String, Object>> difference = compare(data1, data2);

        return format(difference, format);
    }

    public static String generate(String filePath1, String filePath2) throws Exception {
        return generate(filePath1, filePath2, "stylish");
    }

    private static String getDataFormat(String filePath) {
        int index = filePath.lastIndexOf('.');
        return index > 0
                ? filePath.substring(index + 1)
                : "";
    }

}
