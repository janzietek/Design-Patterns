package agh.dp.decorator;

import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class CircleShape extends  BaseShape{
    public CircleShape() {
        this.shape = new Circle(300, 200, 100);
    }

    @Override
    public Shape draw() {
        return this.shape;
    }
}
