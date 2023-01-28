package agh.edu.dp;

import agh.edu.dp.helpers.MatrixHelper;

public class MatrixNode extends Node {
    protected static MatrixHelper matrixHelper;

    protected double[][] matrix;
    protected String name;

    public MatrixNode(String name) {
        this.name = name;
    }

    public MatrixNode(double[][] matrix, String name) {
        this.matrix = matrix;
        this.name = name;
    }

    public double[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(double[][] matrix) {
        this.matrix = matrix;
    }

    @Override
    public void accept(Visitor visitor) throws Exception {
        visitor.visit(this);
    }
}
