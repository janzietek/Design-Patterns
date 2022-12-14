package agh.dp.builder;

import agh.dp.builder.Nodes.IJSONNode;
import agh.dp.builder.Nodes.JSONObject;

public class Builder {
    private final JSONObject jsonObject;

    public Builder() {
        jsonObject = new JSONObject();
    }

    public void add(String key, IJSONNode node, int depth) {
        this.jsonObject.add(key, node, depth);
    }

    public JSONObject build() {
        return this.jsonObject;
    }
}
