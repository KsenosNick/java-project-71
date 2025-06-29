package hexlet.code.formatters;

import hexlet.code.Status;

import java.util.List;
import java.util.Map;

public class PlainFormatter {
    public static String format(List<Map<String, Object>> difference) {
        StringBuilder stringBuilder = new StringBuilder();

        for (Map<String, Object> data : difference) {
            Object status = data.get("status");
            Object key = data.get("key");
            Object value1 = data.get("value1");
            Object value2 = data.get("value2");

            String formattedValue1 = formatValue(value1);
            String formattedValue2 = formatValue(value2);
            switch (status) {
                case Status.UPDATE:
                    stringBuilder.append("Property '")
                            .append(key)
                            .append("' was updated. From ")
                            .append(formattedValue1)
                            .append(" to ")
                            .append(formattedValue2)
                            .append("\n");
                    break;
                case Status.REMOVED:
                    stringBuilder.append("Property '")
                            .append(key)
                            .append("' was removed\n");
                    break;
                case Status.ADDED:
                    stringBuilder.append("Property '")
                            .append(key)
                            .append("' was added with value: ")
                            .append(formattedValue2)
                            .append("\n");
                    break;
                case Status.UNCHANGED:
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + status);
            }
        }

        return stringBuilder.toString().trim();
    }

    private static String formatValue(Object obj) {
        if (obj == null) {
            return "null";
        } else if (isString(obj)) {
            return "'" + obj + "'";
        } else if (isComplexType(obj)) {
            return "[complex value]";
        } else {
            return obj.toString();
        }
    }

    private static boolean isString(Object obj) {
        return obj instanceof String;
    }

    private static boolean isComplexType(Object obj) {
        String str = obj.toString();
        return str.startsWith("{") && str.endsWith("}")
                || str.startsWith("[") && str.endsWith("]");
    }
}
