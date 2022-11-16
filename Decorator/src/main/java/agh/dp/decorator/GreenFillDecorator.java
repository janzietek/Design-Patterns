package agh.dp.decorator;

import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;

public class GreenFillDecorator extends BaseDecorator{
    public GreenFillDecorator(BaseShape originalShape) {
        this.baseShape = originalShape;
    }

    @Override
    public Shape draw() {
        super.baseShape.draw().setFill(Color.GREEN);
        return super.baseShape.draw();
    }
}
