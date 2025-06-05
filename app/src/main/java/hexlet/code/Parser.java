package hexlet.code;

import java.io.IOException;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Parser {
    public static <K, V> Map<K, V> parse(String content) throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        TypeReference<Map<K, V>> typeRef = new TypeReference<>() { };

        return mapper.readValue(content, typeRef);
    }
}
