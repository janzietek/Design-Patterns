package agh.edu.dp;

import agh.edu.dp.nodes.*;

import java.util.LinkedList;
import java.util.List;

public class CalculationGraph extends Node {
    List<Node> nodes = new LinkedList<>();

    @Override
    public void accept(Visitor visitor) throws Exception {
        for (Node node: nodes) {
            node.accept(visitor);
        }
    }

    public MatrixNode AddMatrix(double[][] matrix, String name){
        MatrixNode node = new MatrixNode(matrix, name);
        nodes.add(node);
        return node;
    }

    public MatrixNode InverseMatrix (MatrixNode node1, String name){
        MatrixNode node = new InverseMatrixNode(node1, name);
        nodes.add(node);
        return node;
    }

    public MatrixNode MultiplyMatrices(MatrixNode node1, MatrixNode node2, String name){
        MatrixNode node = new MultiplyMatricesNode(node1, node2, name);
        nodes.add(node);
        return node;
    }

    public MatrixNode AddMatrices (MatrixNode node1, MatrixNode node2, String name){
        MatrixNode node = new AddMatricesNode(node1, node2, name);
        nodes.add(node);
        return node;
    }

    public MatrixNode SubtractMatrices (MatrixNode node1, MatrixNode node2, String name){
        MatrixNode node = new SubtractMatricesNode(node1, node2, name);
        nodes.add(node);
        return node;
    }

    public MatrixNode MultiplyMatrixByScalar (MatrixNode node1, double scalar, String name){
        MatrixNode node = new ScalarMatrixMultiplicationNode(node1, scalar, name);
        nodes.add(node);
        return node;
    }
}
