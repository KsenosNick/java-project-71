package hexlet.code.formatters;

import hexlet.code.Status;

import java.util.List;
import java.util.Map;

public class StylishFormatter {
    public static String format(List<Map<String, Object>> difference) {
        StringBuilder stringBuilder = new StringBuilder("{");

        for (Map<String, Object> data : difference) {
            stringBuilder.append("\n");
            Object status = data.get("status");
            Object key = data.get("key");
            Object value1 = data.get("value1");
            Object value2 = data.get("value2");
            switch (status) {
                case Status.UPDATE -> {
                    String formattedLineValue1 = "  - " + key + ": " + value1;
                    String formattedLineValue2 = "  + " + key + ": " + value2;
                    stringBuilder.append(formattedLineValue1).append("\n").append(formattedLineValue2);
                }
                case Status.REMOVED -> {
                    String formattedLineValue = "  - " + key + ": " + value1;
                    stringBuilder.append(formattedLineValue);
                }
                case Status.ADDED -> {
                    String formattedLineValue = "  + " + key + ": " + value2;
                    stringBuilder.append(formattedLineValue);
                }
                case Status.UNCHANGED -> {
                    String formattedLineValue = "    " + key + ": " + value1;
                    stringBuilder.append(formattedLineValue);
                }
                default -> throw new IllegalStateException("Unexpected value: " + status);
            }
        }
        stringBuilder.append("\n").append("}");

        return stringBuilder.toString();
    }
}
