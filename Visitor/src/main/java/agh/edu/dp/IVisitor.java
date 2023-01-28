package agh.edu.dp;

import agh.edu.dp.nodes.AddMatricesNode;

public interface IVisitor {
    public void visit(AddMatricesNode node);
    public void visit(MatrixNode node);
}
