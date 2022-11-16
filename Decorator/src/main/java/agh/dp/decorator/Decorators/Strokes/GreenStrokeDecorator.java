package agh.dp.decorator.Decorators.Strokes;

import agh.dp.decorator.Decorators.BaseDecorator;
import agh.dp.decorator.Shapes.BaseShape;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;

public class GreenStrokeDecorator extends BaseDecorator {
    public GreenStrokeDecorator(BaseShape originalShape) {
        this.baseShape = originalShape;
        decorate();
    }

    @Override
    public Shape getShape() {
        return super.baseShape.getShape();
    }

    @Override
    public void decorate() {
        this.getShape().setStroke(Color.GREEN);
    }
}