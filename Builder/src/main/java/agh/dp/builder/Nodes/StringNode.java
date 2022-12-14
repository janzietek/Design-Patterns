package agh.dp.builder.Nodes;

public class StringNode implements IJSONNode {
    private String value;

    public StringNode(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
