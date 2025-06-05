package hexlet.code.utils;

public class Util {
    public static String getFormattedLine(
                                     String prefix,
                                     String separator,
                                     Object key,
                                     Object value,
                                     boolean lineBreak) {
        String formattedLine = prefix + key + separator + value;
        if (lineBreak) {
            formattedLine += "\n";
        }
        return formattedLine;
    }
}
