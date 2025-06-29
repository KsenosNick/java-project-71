package hexlet.code;

import java.util.List;
import java.util.Map;

import static hexlet.code.Comparator.compare;
import static hexlet.code.Formatter.format;
import static hexlet.code.Parser.parse;
import static hexlet.code.Reader.read;

public class Differ {
    public static String generate(String filePath1, String filePath2, String format) throws Exception {
        String file1Format = getDataFormat(filePath1);
        String file2Format = getDataFormat(filePath2);

        String fileContent1 = read(filePath1);
        String fileContent2 = read(filePath2);

        Map<String, Object> data1 = parse(fileContent1, file1Format);
        Map<String, Object> data2 = parse(fileContent2, file2Format);

        List<Map<String, Object>> difference = compare(data1, data2);

        return format(difference, format);
    }

    private static String getDataFormat(String filePath) {
        int index = filePath.lastIndexOf('.');
        return index > 0
                ? filePath.substring(index + 1)
                : "";
    }

}
