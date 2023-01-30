package agh.edu.dp;

import agh.edu.dp.helpers.MatrixHelper;
import agh.edu.dp.nodes.MatrixNode;
import agh.edu.dp.visitors.CalculationVisitor;
import agh.edu.dp.visitors.Visitor;

public class Main {
    public static void main(String[] args) throws Exception {
        CalculationGraph calculationGraph = new CalculationGraph();
        Visitor calculationVisitor = new CalculationVisitor();

        double[][] matrix1 = MatrixHelper.GenerateRandomMatrix(3);
        double[][] matrix2 = MatrixHelper.GenerateRandomMatrix(3);
        double[][] matrix3 = MatrixHelper.GenerateRandomMatrix(3);

        MatrixNode matrixA = calculationGraph.AddMatrix(matrix1, "A");
        MatrixNode matrixB = calculationGraph.AddMatrix(matrix2, "B");
        MatrixNode matrixC = calculationGraph.AddMatrix(matrix3, "C");
        MatrixNode inverseA = calculationGraph.InverseMatrix(matrixA, "Inverse A");
        MatrixNode matrixD = calculationGraph.AddMatrices(inverseA, matrixB, "D = InverseA + B");
        MatrixNode matrixE = calculationGraph.MultiplyMatrixByScalar(matrixC, 2.5, "E = C * 2.5");
        MatrixNode matrixF = calculationGraph.MultiplyMatrices(matrixD, matrixE, "F = D X E");

        calculationGraph.accept(calculationVisitor);
    }
}
