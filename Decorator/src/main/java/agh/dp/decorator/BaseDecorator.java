package agh.dp.decorator;

import javafx.scene.shape.Shape;

public abstract class BaseDecorator implements BaseShape {
    protected BaseShape baseShape;
    public abstract Shape getShape();
    public abstract void decorate();
}
