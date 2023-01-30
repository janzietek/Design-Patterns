package agh.edu.dp.helpers;

import java.util.Random;

import static agh.edu.dp.helpers.MatrixFunctions.determinant;

public class MatrixHelper {
    static Random rand = new Random();

    public static boolean VerifyMatrixNotEmpty(double[][] matrix){
        if(matrix == null){
            return false;
        }
        for (double[] row: matrix) {
            if (row == null)
                return false;
        }
        return true;
    }

    public static boolean VerifyMatrixSize(double[][] matrix){
        if (matrix.length == 0 || matrix[0].length == 0){
            return false;
        }
        int rowLength = matrix[0].length;
        for (double[] row: matrix) {
            if (row.length != rowLength)
                return false;
        }
        return true;
    }

    public static boolean VerifyMatricesSizeForAdding(double[][] matrix1, double[][] matrix2) {
        int x1 = matrix1.length;
        int y1 = matrix1[0].length;

        int x2 = matrix2.length;
        int y2 = matrix2[0].length;

        return x1 == x2 && y1 == y2;
    }

    public static boolean VerifyMatricesSizeForMultiplication(double[][] matrix1, double[][] matrix2) {
        int y1 = matrix1[0].length;

        int x2 = matrix2.length;

        return y1 == x2;
    }

    public static boolean VerifyMatrixIsSquareForInversion(double[][] matrix){
        return matrix[0].length == matrix.length;
    }

    public static boolean VerifyNonZeroDeterminantForInversion(double[][] matrix){
        return determinant(matrix) != 0;
    }

    public static double[][] GenerateRandomMatrix(int size) {
        double[][] matrix = new double[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = rand.nextDouble() * 10;
            }
        }
        return matrix;
    }
}
