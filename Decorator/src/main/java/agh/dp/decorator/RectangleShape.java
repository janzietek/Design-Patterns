package agh.dp.decorator;

import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class RectangleShape extends BaseShape {
    public RectangleShape() {
        this.shape = new Rectangle(200, 100, 200, 200);
    }

    @Override
    public Shape draw() {
        System.out.println("RECTANGLE created");
        return this.shape;
    }
}
