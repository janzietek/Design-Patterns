package agh.dp.decorator.Shapes;

import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;

public class CircleShape implements BaseShape {
    public Shape shape;
    public CircleShape() {
        this.shape = new Circle(300, 200, 100);
        this.shape.setStrokeWidth(20);
    }

    @Override
    public Shape getShape() {
        return this.shape;
    }
}
