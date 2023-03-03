package be.kdg.nerdle.view.GameScreen;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;

public class BoardPart extends StackPane {
    private Region square;
    private Label label;
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

    public void setText(String text) {
        this.label.setText(text);
    }



}
