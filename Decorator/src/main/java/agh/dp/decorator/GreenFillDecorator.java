package agh.dp.decorator;

import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;

public class GreenFillDecorator extends BaseDecorator{
    public GreenFillDecorator(BaseShape originalShape) {
        this.baseShape = originalShape;
        decorate();
    }

    @Override
    public Shape getShape() {
        return super.baseShape.getShape();
    }

    @Override
    public void decorate() {
        this.getShape().setFill(Color.GREEN);
    }
}
