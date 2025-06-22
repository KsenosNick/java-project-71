package hexlet.code;

import java.util.List;
import java.util.Map;

import hexlet.code.formatters.PlainFormatter;
import hexlet.code.formatters.StylishFormatter;

public class Formatter {
    public static String format(List<Map<String, Object>> difference, String format) {
        if (format.equals("stylish")) {
            return StylishFormatter.format(difference);
        } else if (format.equals("plain")) {
            return PlainFormatter.format((difference));
        } else {
            throw new IllegalArgumentException("Unsupported output format: " + format);
        }
    }
}
