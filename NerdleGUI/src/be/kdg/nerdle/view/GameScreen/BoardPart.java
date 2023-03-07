package be.kdg.nerdle.view.GameScreen;

import be.kdg.nerdle.model.Color;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;

public class BoardPart extends StackPane {
    private final Region square;
    private final Label label;
    private static final Font FONT = Font.font("Times New Roman", 40);



    public BoardPart(Region square, Label label) {
        super(square, label);
        this.label = label;
        this.square = square;
    }

    public void style() {
        square.setPrefSize(50, 50);
        square.setStyle("-fx-background-color: #8e8c8c; -fx-background-radius: 10 10 10 10; " +
                "-fx-border-color: black; -fx-border-radius: 10;");

        label.setText("");
        label.setMinHeight(20);
        label.setMinWidth(20);
        label.setFont(FONT);

        this.setPadding(new Insets(2,2,2,2));

    }

    public void setActiveStyle() {
        square.setStyle("-fx-background-color: #696868; -fx-background-radius: 10 10 10 10; " +
                "-fx-border-color: red; -fx-border-radius: 10;");
    }

    public void setInactiveStyle(Color color) {
        String hexCode = color.translateColorToHex();
        square.setStyle(String.format("-fx-background-color: %s; -fx-background-radius: 10 10 10 10; " +
                "-fx-border-color: black; -fx-border-radius: 10;", hexCode));
    }

    public void setHoverStyle(Color color) {
        String hexCode = color.translateColorToLighterHex();
        square.setStyle(String.format("-fx-background-color: %s; -fx-background-radius: 10 10 10 10; " +
                "-fx-border-color: black; -fx-border-radius: 10;", hexCode));

        if (color == Color.BLACK) {
            label.setStyle("-fx-text-fill: white");
        }
    }

    public void setCustomColor(Color color) {
        String hexCode = color.translateColorToHex();
        square.setStyle(String.format("-fx-background-color: %s; -fx-background-radius: 10 10 10 10; " +
                "-fx-border-color: black; -fx-border-radius: 10;", hexCode));

        if (hexCode.equals("#000000") || hexCode.equals("#1e1e1e")) {
            label.setStyle("-fx-text-fill: white");
        }
    }

    public void setText(String text) {
        this.label.setText(text);
    }

    public String getText() {
        return label.getText();
    }
}