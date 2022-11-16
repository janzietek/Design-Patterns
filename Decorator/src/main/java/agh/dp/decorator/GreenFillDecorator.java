package agh.dp.decorator;

import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;

public class GreenFillDecorator extends BaseDecorator{
    public GreenFillDecorator(BaseShape originalShape) {
        this.shape = originalShape.shape;
    }

    @Override
    public Shape draw() {
        this.shape.setFill(Color.GREEN);
        return this.shape;
    }
}
