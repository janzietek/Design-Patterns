package agh.edu.dp.nodes;

import agh.edu.dp.MatrixNode;
import agh.edu.dp.Node;

public class MatrixOperationNode extends MatrixNode {
    protected MatrixNode operationElement;

    public MatrixOperationNode(MatrixNode element, String name) {
        super(name);
        this.operationElement = element;
    }
}
