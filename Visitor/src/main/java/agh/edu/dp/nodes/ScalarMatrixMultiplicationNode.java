package agh.edu.dp.nodes;

import agh.edu.dp.IVisitor;
import agh.edu.dp.MatrixNode;
import agh.edu.dp.helpers.MatrixHelper;

public class ScalarMatrixMultiplicationNode extends MatrixOperationNode {
    protected double scalar;

    public ScalarMatrixMultiplicationNode(MatrixNode element, double scalar, String name) {
        super(element, name);
        this.scalar = scalar;
    }

    @Override
    public void accept(IVisitor visitor) throws Exception {
        visitor.visit(this);
    }
}
