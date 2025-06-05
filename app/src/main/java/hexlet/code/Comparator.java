package hexlet.code;

import java.util.Objects;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

public class Comparator {

    public static List<Map<String, Object>>  compare(Map<String, Object> data1, Map<String, Object> data2) {
        Set<String> keys = new TreeSet<>(data1.keySet());
        keys.addAll(data2.keySet());
        List<Map<String, Object>> result = new ArrayList<>();

        for (String key : keys) {
            Map<String, Object> dataDifference = new HashMap<>();
            Object value1 = data1.get(key);
            Object value2 = data2.get(key);
            dataDifference.put("key", key);
            if (Objects.isNull(value1)) {
                dataDifference.put("value2", value2);
                dataDifference.put("status", Status.ADDED);
            } else if (Objects.isNull(value2)) {
                dataDifference.put("value1", value1);
                dataDifference.put("status", Status.REMOVED);
            } else if (Objects.equals(value1, value2)) {
                dataDifference.put("value1", value1);
                dataDifference.put("status", Status.UNCHANGED);
            } else {
                dataDifference.put("value1", value1);
                dataDifference.put("value2", value2);
                dataDifference.put("status", Status.UPDATE);
            }

            result.add(dataDifference);
        }



        return result;
    }
}
