package agh.edu.dp.nodes;

import agh.edu.dp.helpers.MatrixHelper;
import agh.edu.dp.visitors.Visitor;

public class InverseMatrixNode extends MatrixOperationNode {
    public InverseMatrixNode(MatrixNode element, String name) {
        super(element, name);
    }

    @Override
    public void accept(Visitor visitor) throws Exception {
        if (MatrixHelper.VerifyMatrixIsSquareForInversion(this.operationElement.getMatrix())){
            if (MatrixHelper.VerifyNonZeroDeterminantForInversion(this.operationElement.getMatrix()))
                visitor.visit(this);
            else
                throw new Exception("Determinant equals zero");
        }
        else
            throw new Exception("Matrix is not square");
    }
}
