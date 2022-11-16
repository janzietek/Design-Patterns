package agh.dp.decorator;

import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;

public class RedFillDecorator extends BaseDecorator {
    public RedFillDecorator(BaseShape originalShape) {
        this.baseShape = originalShape;
    }

    @Override
    public Shape draw() {
        super.baseShape.draw().setFill(Color.RED);
        return super.baseShape.draw();
    }
}
