package agh.edu.dp;

public abstract class Node {
    public abstract void accept(IVisitor visitor) throws Exception;
}
