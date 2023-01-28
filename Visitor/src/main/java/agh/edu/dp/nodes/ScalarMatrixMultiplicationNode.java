package agh.edu.dp.nodes;

import agh.edu.dp.Visitor;
import agh.edu.dp.MatrixNode;

public class ScalarMatrixMultiplicationNode extends MatrixOperationNode {
    protected double scalar;

    public ScalarMatrixMultiplicationNode(MatrixNode element, double scalar, String name) {
        super(element, name);
        this.scalar = scalar;
    }

    @Override
    public void accept(Visitor visitor) throws Exception {
        visitor.visit(this);
    }
}
