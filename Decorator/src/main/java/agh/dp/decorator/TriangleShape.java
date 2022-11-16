package agh.dp.decorator;

import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class TriangleShape extends BaseShape {
    Shape shape;
    public TriangleShape() {
        this.shape = new Polygon(
                300, 100,
                200, 300,
                400, 300
        );
    }

    @Override
    public Shape draw() {
        return this.shape;
    }
}
