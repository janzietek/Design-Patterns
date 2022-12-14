package agh.dp.builder;


import agh.dp.builder.Nodes.FloatNode;
import agh.dp.builder.Nodes.IntNode;
import agh.dp.builder.Nodes.StringNode;

public class Manager {
    private final String jsonRaw;

    public Manager(String json) {
        this.jsonRaw = json.replaceAll("\\s", "");
    }

    public Builder createObjectBuilder() {
        return createObjectBuilderDeep(this.jsonRaw, 0);
    }

    private Builder createObjectBuilderDeep(String json, int depth) {
        Builder builder = new Builder();

        int index = 1;
        while (index < json.length()) {
            int[] lineRange = getLineRange(json, index);
            index = lineRange[1];
            String line = json.substring(lineRange[0], lineRange[1]);
            String[] keyAndValue;
            keyAndValue = line.split(":", 2);

            if (line.contains("{")) {
                builder.add(keyAndValue[0], this.createObjectBuilderDeep(keyAndValue[1], depth + 1).build(), depth);
            }
            else if (line.contains("\"")) {
                builder.add(keyAndValue[0], new StringNode(keyAndValue[1]), depth);

            } else if (line.contains(".")) {
                builder.add(keyAndValue[0], new FloatNode(Float.parseFloat(keyAndValue[1])), depth);
            } else {
                builder.add(keyAndValue[0], new IntNode(Integer.parseInt(keyAndValue[1])), depth);
            }
            index++;
        }
        return builder;
    }

    private int[] getLineRange(String json, int index) {
        int startIndex = index;
        while (json.charAt(index) != ',' && index < json.length() - 1) {
            if (json.charAt(index) == '{') {
                while (json.charAt(index) != '}') {
                    index++;
                }
            }
            index++;
        }
        return new int[]{startIndex, index};
    }
}
