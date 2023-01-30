package agh.edu.dp.nodes;

import agh.edu.dp.visitors.Visitor;
import agh.edu.dp.helpers.MatrixHelper;

public class AddMatricesNode extends MatrixOperationNode {
    public AddMatricesNode(MatrixNode matrixNode, MatrixNode matrixNode2, String name) {
        super(matrixNode, matrixNode2, name);
    }

    @Override
    public void accept(Visitor visitor) throws Exception {
        if (MatrixHelper.VerifyMatricesSizeForAdding(this.operationElement.getMatrix(), this.operationElement2.getMatrix()))
            visitor.visit(this);
        else
            throw new Exception("Wrong matrices sizes");
    }
}
