package agh.dp.builder;

public class FloatNode {
    private float value;

    public FloatNode(float value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return Float.toString(value);
    }
}
