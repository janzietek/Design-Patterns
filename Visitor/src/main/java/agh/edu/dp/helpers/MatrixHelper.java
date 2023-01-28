package agh.edu.dp.helpers;

import java.util.Random;

public class MatrixHelper {
    static Random rand = new Random();

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
