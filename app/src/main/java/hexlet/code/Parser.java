package hexlet.code;

import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

public class Parser {
    public static <K, V> Map<K, V> parse(String content, String dataType) throws Exception {
        if (dataType.equalsIgnoreCase("json")) {
            return parseJson(content);
        } else if (dataType.equalsIgnoreCase("yml") || dataType.equalsIgnoreCase("yaml")) {
            return parseYaml(content);
        } else {
            throw new IllegalArgumentException("Unsupported data format: " + dataType);
        }
    }

    private static <K, V> Map<K, V> parseJson(String content) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        TypeReference<Map<K, V>> typeRef = new TypeReference<>() { };

        return mapper.readValue(content, typeRef);
    }

    private static <K, V> Map<K, V> parseYaml(String content) throws Exception {
        ObjectMapper mapper = new YAMLMapper();
        TypeReference<Map<K, V>> typeRef = new TypeReference<>() { };

        return mapper.readValue(content, typeRef);
    }
}
