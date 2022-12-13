package agh.dp.builder;

public class IntNode implements IJSONNode{
    private int value;

    public IntNode(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return Integer.toString(value);
    }
}
