module agh.dp.decorator {
    requires javafx.controls;
    requires javafx.fxml;


    opens agh.dp.decorator to javafx.fxml;
    exports agh.dp.decorator;
    exports agh.dp.decorator.GUI;
    opens agh.dp.decorator.GUI to javafx.fxml;
    exports agh.dp.decorator.Shapes;
    opens agh.dp.decorator.Shapes to javafx.fxml;
    exports agh.dp.decorator.Decorators;
    opens agh.dp.decorator.Decorators to javafx.fxml;
    exports agh.dp.decorator.Decorators.Colors;
    opens agh.dp.decorator.Decorators.Colors to javafx.fxml;
    exports agh.dp.decorator.Decorators.Strokes;
    opens agh.dp.decorator.Decorators.Strokes to javafx.fxml;
}