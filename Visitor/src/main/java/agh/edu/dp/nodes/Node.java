package agh.edu.dp.nodes;

import agh.edu.dp.visitors.Visitor;

public abstract class Node {
    public abstract void accept(Visitor visitor) throws Exception;
}
