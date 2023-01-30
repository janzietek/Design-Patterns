package agh.edu.dp.visitors;

import agh.edu.dp.nodes.MatrixNode;
import agh.edu.dp.nodes.*;

import java.util.Arrays;

import static agh.edu.dp.helpers.MatrixFunctions.determinant;
import static agh.edu.dp.helpers.MatrixFunctions.minor;

public class CalculationVisitor implements Visitor {
    @Override
    public void visit(MatrixNode node) {
    }

    @Override
    public void visit(AddMatricesNode node) {
        double[][] leftMatrix = node.getOperationElement().getMatrix();
        double[][] rightMatrix = node.getOperationElement2().getMatrix();

        int col = leftMatrix[0].length;
        int row = leftMatrix.length;
        double[][] resultMatrix = new double[col][row];

        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                resultMatrix[i][j] = leftMatrix[i][j] + rightMatrix[i][j];
            }
        }

        node.setMatrix(resultMatrix);
    }

    @Override
    public void visit(InverseMatrixNode node) {
        double[][] matrix = node.getOperationElement().getMatrix();

        int col = matrix[0].length;
        int row = matrix.length;
        double[][] resultMatrix = new double[col][row];

        for (int i = 0; i < col; i++)
            for (int j = 0; j < row; j++)
                resultMatrix[i][j] = Math.pow(-1, i + j)
                        * determinant(minor(matrix, i, j));

        double det = 1.0 / determinant(matrix);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j <= i; j++) {
                double temp = resultMatrix[i][j];
                resultMatrix[i][j] = resultMatrix[j][i] * det;
                resultMatrix[j][i] = temp * det;
            }
        }

        node.setMatrix(resultMatrix);
    }

    @Override
    public void visit(MultiplyMatricesNode node) {
        double[][] leftMatrix = node.getOperationElement().getMatrix();
        double[][] rightMatrix = node.getOperationElement2().getMatrix();

        int col = leftMatrix[0].length;
        int row = leftMatrix.length;
        double[][] resultMatrix = new double[col][row];

        for (int i = 0; i < col; i++) {
            for (int j = 0; j < col; j++) {
                resultMatrix[i][j] = 0;
                for (int k = 0; k < row; k++) {
                    resultMatrix[i][j] += leftMatrix[i][k] * rightMatrix[k][j];
                }
            }
        }

        node.setMatrix(resultMatrix);
    }

    @Override
    public void visit(ScalarMatrixMultiplicationNode node) {
        double[][] matrix = node.getOperationElement().getMatrix();
        double scalar = node.getScalar();

        int col = matrix[0].length;
        int row = matrix.length;
        double[][] resultMatrix = new double[col][row];

        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                resultMatrix[i][j] = matrix[i][j] * scalar;
            }
        }

        node.setMatrix(resultMatrix);
    }

    @Override
    public void visit(SubtractMatricesNode node) {
        double[][] leftMatrix = node.getOperationElement().getMatrix();
        double[][] rightMatrix = node.getOperationElement2().getMatrix();

        int col = leftMatrix[0].length;
        int row = leftMatrix.length;
        double[][] resultMatrix = new double[col][row];

        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                resultMatrix[i][j] = leftMatrix[i][j] - rightMatrix[i][j];
            }
        }

        node.setMatrix(resultMatrix);
    }
}
