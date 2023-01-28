package agh.edu.dp;

import agh.edu.dp.nodes.*;

public interface Visitor {
    public void visit(MatrixNode node);
    public void visit(AddMatricesNode node);
    public void visit(InverseMatrixNode node);
    public void visit(MultiplyMatricesNode node);
    public void visit(ScalarMatrixMultiplicationNode node);
    public void visit(SubtractMatricesNode node);
}
