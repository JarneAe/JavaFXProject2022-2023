package be.kdg.nerdle.view.GameScreen;

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
        square.setStyle("-fx-background-color: #818181; -fx-background-radius: 10 10 10 10; -fx-border-color: black; ");



        label.setText("1");
        label.setMinHeight(20);
        label.setMinWidth(20);
        label.setFont(FONT);

    }

    public void setText(String text) {
        this.label.setText(text);
    }



}
