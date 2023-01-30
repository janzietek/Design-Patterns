package agh.edu.dp.nodes;

public class MatrixOperationNode extends MatrixNode {
    protected MatrixNode operationElement;
    protected MatrixNode operationElement2;

    public MatrixOperationNode(MatrixNode element, String name) {
        super(name);
        this.operationElement = element;
    }

    public MatrixOperationNode(MatrixNode element, MatrixNode element2, String name) {
        super(name);
        this.operationElement = element;
        this.operationElement2 = element2;
    }

    public MatrixNode getOperationElement() {
        return operationElement;
    }

    public MatrixNode getOperationElement2() {
        return operationElement2;
    }
}
