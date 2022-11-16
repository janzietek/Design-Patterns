package agh.dp.decorator;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class GUIController extends AnchorPane {
    private BaseShape _shape;

    public GUIController() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(
                "decorator_view.fxml"));
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
        _shape = new RedFillDecorator(_shape);
    }

    @FXML
    protected void FillBlue() {
        _shape = new BlueFillDecorator(_shape);
    }

    @FXML
    protected void FillGreen() {
        _shape = new GreenFillDecorator(_shape);
    }

    @FXML
    protected void StrokeRed() {
        _shape = new RedStrokeDecorator(_shape);
    }

    @FXML
    protected void StrokeBlue() {
        _shape = new BlueStrokeDecorator(_shape);
    }

    @FXML
    protected void StrokeGreen() {
        _shape = new GreenStrokeDecorator(_shape);
    }
}