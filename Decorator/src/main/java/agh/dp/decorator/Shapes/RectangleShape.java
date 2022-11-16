package agh.dp.decorator.Shapes;

import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class RectangleShape implements BaseShape {
    Shape shape;
    public RectangleShape() {
        this.shape = new Rectangle(200, 100, 200, 200);
        this.shape.setStrokeWidth(20);
    }

    @Override
    public Shape getShape() {
        return this.shape;
    }
}
