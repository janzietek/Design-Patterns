package agh.dp.decorator.Decorators.LineStyle;

import agh.dp.decorator.Decorators.BaseDecorator;
import agh.dp.decorator.Shapes.BaseShape;
import javafx.scene.shape.Shape;

public class DashedLineDecorator extends BaseDecorator {
    public DashedLineDecorator(BaseShape originalShape) {
        this.baseShape = originalShape;
        decorate();
    }

    @Override
    public Shape getShape() {
        return super.baseShape.getShape();
    }

    @Override
    public void decorate() {
        this.getShape().getStrokeDashArray().clear();
        this.getShape().getStrokeDashArray().addAll(25d, 10d);
    }
}