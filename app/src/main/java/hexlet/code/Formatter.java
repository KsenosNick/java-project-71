package hexlet.code;

import java.util.List;
import java.util.Map;

import hexlet.code.formatters.JsonFormatter;
import hexlet.code.formatters.PlainFormatter;
import hexlet.code.formatters.StylishFormatter;

public class Formatter {
    public static String format(List<Map<String, Object>> difference, String format) throws Exception {
        return switch (format) {
            case "stylish" -> StylishFormatter.format(difference);
            case "plain" -> PlainFormatter.format((difference));
            case "json" -> JsonFormatter.format((difference));
            default -> throw new IllegalArgumentException("Unsupported output format: " + format);
        };
    }
}
