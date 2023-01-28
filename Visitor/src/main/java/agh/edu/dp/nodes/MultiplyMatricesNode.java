package agh.edu.dp.nodes;

import agh.edu.dp.IVisitor;
import agh.edu.dp.MatrixNode;
import agh.edu.dp.helpers.MatrixHelper;

public class MultiplyMatricesNode extends MatrixOperationNode {
    protected MatrixNode operationElement2;

    public MultiplyMatricesNode(MatrixNode matrixNode, MatrixNode matrixNode2, String name) {
        super(matrixNode, name);
        this.operationElement2 = matrixNode2;
    }

    @Override
    public void accept(IVisitor visitor) throws Exception {
        if (MatrixHelper.verifyMatricesSizeForMultiplication(this.operationElement.getMatrix(), this.operationElement2.getMatrix()))
            visitor.visit(this);
        else
            throw new Exception("Wrong matrices sizes");
    }
}
