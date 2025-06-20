package hexlet.code;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static hexlet.code.Comparator.compare;
import static hexlet.code.Formater.format;
import static hexlet.code.Parser.parse;
import static hexlet.code.Reader.read;
import org.apache.commons.io.FilenameUtils;

public class Differ {
    public static String generate(String filePath1, String filePath2, String format) throws IOException {
        try {
            String file1Format = FilenameUtils.getExtension(filePath1).toLowerCase();
            String file2Format = FilenameUtils.getExtension(filePath2).toLowerCase();

            String fileContent1 = read(filePath1);
            String fileContent2 = read(filePath2);

            Map<String, Object> data1 = parse(fileContent1, file1Format);
            Map<String, Object> data2 = parse(fileContent2, file2Format);

            List<Map<String, Object>> difference = compare(data1, data2);

            String result = format(difference, format);

            System.out.println(result);

            return result;
        } catch (IllegalArgumentException exception) {
            throw new RuntimeException(exception);
        }

    }
}
