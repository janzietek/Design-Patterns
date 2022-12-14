package agh.dp.builder.Nodes;

public class FloatNode implements IJSONNode {
    private float value;

    public FloatNode(float value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return Float.toString(value);
    }
}
