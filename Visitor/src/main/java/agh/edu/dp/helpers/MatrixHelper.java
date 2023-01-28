package agh.edu.dp.helpers;

public class MatrixHelper {
    public static boolean verifyMatricesSizeForAdding(double[][] matrix1, double[][] matrix2) {
        int x1 = matrix1.length;
        int y1 = matrix1[0].length;

        int x2 = matrix2.length;
        int y2 = matrix2[0].length;

        return x1 == x2 && y1 == y2;
    }

    public static boolean verifyMatricesSizeForMultiplication(double[][] matrix1, double[][] matrix2) {
        int y1 = matrix1[0].length;

        int x2 = matrix2.length;

        return y1 == x2;
    }
}
