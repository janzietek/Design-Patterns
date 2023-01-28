package agh.edu.dp;

import java.util.LinkedList;
import java.util.List;

public class CalculationGraph extends Node {
    List<Node> nodes = new LinkedList<>();

    @Override
    public void accept(IVisitor visitor) throws Exception {
        for (Node node: nodes) {
            node.accept(visitor);
        }
    }
}
