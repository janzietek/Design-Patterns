package agh.dp.decorator;

import javafx.scene.shape.Shape;

public abstract class BaseDecorator extends BaseShape {
    protected BaseShape baseShape;
    public abstract Shape getShape();
    public abstract void decorate();
}
