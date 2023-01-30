package agh.edu.dp.nodes;

import agh.edu.dp.visitors.Visitor;

public class ScalarMatrixMultiplicationNode extends MatrixOperationNode {
    protected double scalar;

    public ScalarMatrixMultiplicationNode(MatrixNode element, double scalar, String name) {
        super(element, name);
        this.scalar = scalar;
    }

    public double getScalar() {
        return scalar;
    }

    @Override
    public void accept(Visitor visitor) throws Exception {
        visitor.visit(this);
    }
}
