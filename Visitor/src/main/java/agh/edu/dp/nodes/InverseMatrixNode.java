package agh.edu.dp.nodes;

import agh.edu.dp.Visitor;
import agh.edu.dp.MatrixNode;

public class InverseMatrixNode extends MatrixOperationNode {
    public InverseMatrixNode(MatrixNode element, String name) {
        super(element, name);
    }

    @Override
    public void accept(Visitor visitor) throws Exception {
        visitor.visit(this);
    }
}
