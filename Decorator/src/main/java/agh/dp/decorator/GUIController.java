package agh.dp.decorator;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class GUIController extends AnchorPane {
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
        System.out.println("CIRCLE");
    }

    @FXML
    protected void Rectangle() {
        System.out.println("RECTANGLE");
    }

    @FXML
    protected void Triangle() {
        System.out.println("TRIANGLE");
    }

    @FXML
    protected void Red() {
        System.out.println("RED");
    }

    @FXML
    protected void Blue() {
        System.out.println("BLUE");
    }

    @FXML
    protected void Green() {
        System.out.println("GREEN");
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