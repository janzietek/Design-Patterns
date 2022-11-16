package agh.dp.decorator;

import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;

public class RedFillDecorator extends BaseDecorator {
    public RedFillDecorator(BaseShape originalShape) {
        this.shape = originalShape.shape;
    }

    @Override
    public Shape draw() {
        this.shape.setFill(Color.RED);
        return this.shape;
    }
}
