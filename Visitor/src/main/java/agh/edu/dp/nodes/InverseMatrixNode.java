package agh.edu.dp.nodes;

import agh.edu.dp.IVisitor;
import agh.edu.dp.MatrixNode;

public class InverseMatrixNode extends MatrixOperationNode {
    public InverseMatrixNode(MatrixNode element, String name) {
        super(element, name);
    }

    @Override
    public void accept(IVisitor visitor) throws Exception {
        visitor.visit(this);
    }
}
