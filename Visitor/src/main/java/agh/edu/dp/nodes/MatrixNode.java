package agh.edu.dp.nodes;

import agh.edu.dp.helpers.MatrixHelper;
import agh.edu.dp.visitors.Visitor;

public class MatrixNode extends Node {
    protected double[][] matrix;
    protected String name;

    public MatrixNode(String name) {
        this.name = name;
    }

    public MatrixNode(double[][] matrix, String name) {
        this.matrix = matrix;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public double[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(double[][] matrix) {
        this.matrix = matrix;
    }

    @Override
    public void accept(Visitor visitor) throws Exception {
        if (MatrixHelper.VerifyMatrixNotEmpty(this.getMatrix())) {
            if (MatrixHelper.VerifyMatrixSize(this.getMatrix())) {
                visitor.visit(this);
            } else
                throw new Exception("Wrong matrix size");
        }
        else
            throw new Exception("Matrix is empty");
    }
}
