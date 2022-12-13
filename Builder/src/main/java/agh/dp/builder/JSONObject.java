package agh.dp.builder;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class JSONObject implements IJSONNode {
    private static HashMap<String, IJSONNode> objects = new LinkedHashMap<>();

    public void add(String key, IJSONNode obj) {
        objects.put(key, obj);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        objects.forEach(
                (key, value) -> {
                    builder.append(key);
                    builder.append(" : ");
                    builder.append(value.toString());
                    builder.append("\n");
                });

        for (IJSONNode obj: objects.values()) {

            builder.append(obj.toString());
        }
        return builder.toString();
    }
}
