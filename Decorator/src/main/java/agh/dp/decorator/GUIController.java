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
    protected void Red() {
        _shape = new RedFillDecorator(_shape);
        _shape.getShape();
    }

    @FXML
    protected void Blue() {
        _shape = new BlueFillDecorator(_shape);
        _shape.getShape();
    }

    @FXML
    protected void Green() {
        _shape = new GreenFillDecorator(_shape);
        _shape.getShape();
    }

    @FXML
    protected void Dotted() {
        System.out.println("DOTTED");
    }

    @FXML
    protected void Solid() {
        System.out.println("SOLID");
    }

    @FXML
    protected void Dashed() {
        System.out.println("DASHED");
    }
}