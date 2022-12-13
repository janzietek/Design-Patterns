package agh.dp.builder;

public class Builder {
    private final JSONObject jsonObject;

    public Builder() {
        jsonObject = new JSONObject();
    }

    public void add(String key, IJSONNode node) {
        this.jsonObject.add(key, node);
    }

    public JSONObject build() {
        return this.jsonObject;
    }
}
