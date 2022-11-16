package agh.dp.decorator;

import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;

public class BlueFillDecorator extends BaseDecorator{
    public BlueFillDecorator(BaseShape originalShape) {
        this.baseShape = originalShape;
        decorate();
    }

    @Override
    public Shape getShape() {
        return super.baseShape.getShape();
    }

    @Override
    public void decorate() {
        this.getShape().setFill(Color.BLUE);
    }
}
