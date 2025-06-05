package hexlet.code;

import hexlet.code.config.Config;

import java.util.List;
import java.util.Map;

import static hexlet.code.utils.Util.getFormattedLine;

public class Formater {
    public static String format(List<Map<String, Object>> difference, String format) {

        StringBuilder stringBuilder = new StringBuilder(Config.START_BRACKET);

        for (Map<String, Object> data : difference) {
            stringBuilder.append("\n");
            Object status = data.get("status");
            Object key = data.get("key");
            Object value1 = data.get("value1");
            Object value2 = data.get("value2");
            switch (status) {
                case Status.UPDATE -> {

                    String formattedLineValue1 = getFormattedLine(
                            Config.NEGATIVE_PREFIX, Config.SEPARATOR, key, value1, true
                    );
                    String formattedLineValue2 = getFormattedLine(
                            Config.POSITIVE_PREFIX, Config.SEPARATOR, key, value2, false
                    );
                    stringBuilder.append(formattedLineValue1).append(formattedLineValue2);
                }
                case Status.REMOVED -> {
                    String formattedLineValue = getFormattedLine(
                            Config.NEGATIVE_PREFIX, Config.SEPARATOR, key, value1, false
                    );
                    stringBuilder.append(formattedLineValue);
                }
                case Status.ADDED -> {
                    String formattedLineValue = getFormattedLine(
                            Config.POSITIVE_PREFIX, Config.SEPARATOR, key, value2, false
                    );
                    stringBuilder.append(formattedLineValue);
                }
                case Status.UNCHANGED -> {
                    String formattedLineValue = getFormattedLine(
                            Config.NEUTRAL_PREFIX, Config.SEPARATOR, key, value1, false
                    );
                    stringBuilder.append(formattedLineValue);
                }
                default -> throw new IllegalStateException("Unexpected value: " + status);
            }
        }
        stringBuilder.append("\n").append(Config.END_BRACKET);

        return stringBuilder.toString();
    }
}
