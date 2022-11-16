package agh.dp.decorator;

import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;

public class BlueFillDecorator extends BaseDecorator{
    public BlueFillDecorator(BaseShape originalShape) {
        this.shape = originalShape.shape;
    }

    @Override
    public Shape draw() {
        this.shape.setFill(Color.BLUE);
        return this.shape;
    }
}
