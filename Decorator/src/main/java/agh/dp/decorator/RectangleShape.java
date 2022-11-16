package agh.dp.decorator;

import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class RectangleShape extends BaseShape {
    Shape shape;
    public RectangleShape() {
        this.shape = new Rectangle(200, 100, 200, 200);
    }

    @Override
    public Shape getShape() {
        return this.shape;
    }
}
