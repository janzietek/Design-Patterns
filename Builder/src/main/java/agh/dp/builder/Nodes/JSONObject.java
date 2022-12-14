package agh.dp.builder.Nodes;

import agh.dp.builder.Nodes.IJSONNode;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class JSONObject implements IJSONNode {
    private HashMap<String, IJSONNode> objects = new LinkedHashMap<>();
    int depth;

    public void add(String key, IJSONNode obj, int depth) {
        objects.put(key, obj);
        this.depth = depth;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("\n");
        objects.forEach(
                (key, value) -> {builder.append("\t".repeat(depth));
                    builder.append(key);
                    builder.append(" : ");
                    builder.append(value.toString());
                    builder.append("\n");
                });

        return builder.toString();
    }
}
