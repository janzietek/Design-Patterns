package agh.dp.decorator;

import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;

public class BlueFillDecorator extends BaseDecorator{
    public BlueFillDecorator(BaseShape originalShape) {
        this.baseShape = originalShape;
    }

    @Override
    public Shape draw() {
        super.baseShape.draw().setFill(Color.BLUE);
        return super.baseShape.draw();
    }
}
