package agh.dp.decorator.GUI;

import agh.dp.decorator.Decorators.Colors.BlueFillDecorator;
import agh.dp.decorator.Decorators.Colors.GreenFillDecorator;
import agh.dp.decorator.Decorators.Colors.RedFillDecorator;
import agh.dp.decorator.Decorators.Strokes.BlueStrokeDecorator;
import agh.dp.decorator.Decorators.Strokes.GreenStrokeDecorator;
import agh.dp.decorator.Decorators.Strokes.RedStrokeDecorator;
import agh.dp.decorator.Shapes.BaseShape;
import agh.dp.decorator.Shapes.CircleShape;
import agh.dp.decorator.Shapes.RectangleShape;
import agh.dp.decorator.Shapes.TriangleShape;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class GUIController extends AnchorPane {
    private BaseShape _shape;

    public GUIController() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(
                "/agh/dp/decorator/decorator_view.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    @FXML
    protected void Circle() {
        if (_shape != null)
            this.getChildren().remove(_shape.getShape());

        _shape = new CircleShape();
        this.getChildren().add(_shape.getShape());
    }

    @FXML
    protected void Rectangle() {
        if (_shape != null)
            this.getChildren().remove(_shape.getShape());
        _shape = new RectangleShape();
        this.getChildren().add(_shape.getShape());
    }

    @FXML
    protected void Triangle() {
        if (_shape != null)
            this.getChildren().remove(_shape.getShape());
        _shape = new TriangleShape();
        this.getChildren().add(_shape.getShape());
    }

    @FXML
    protected void FillRed() {
        if (_shape != null)
            _shape = new RedFillDecorator(_shape);
    }

    @FXML
    protected void FillBlue() {
        if (_shape != null)
            _shape = new BlueFillDecorator(_shape);
    }

    @FXML
    protected void FillGreen() {
        if (_shape != null)
            _shape = new GreenFillDecorator(_shape);
    }

    @FXML
    protected void StrokeRed() {
        if (_shape != null)
            _shape = new RedStrokeDecorator(_shape);
    }

    @FXML
    protected void StrokeBlue() {
        if (_shape != null)
            _shape = new BlueStrokeDecorator(_shape);
    }

    @FXML
    protected void StrokeGreen() {
        if (_shape != null)
            _shape = new GreenStrokeDecorator(_shape);
    }
}