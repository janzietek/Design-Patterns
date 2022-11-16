package agh.dp.decorator.Shapes;

import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;

public class TriangleShape implements BaseShape {
    Shape shape;
    public TriangleShape() {
        this.shape = new Polygon(
                300, 100,
                200, 300,
                400, 300
        );
        this.shape.setStrokeWidth(20);
    }

    @Override
    public Shape getShape() {
        return this.shape;
    }
}
