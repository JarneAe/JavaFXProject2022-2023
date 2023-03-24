package be.kdg.nerdle.customcomponents;

import be.kdg.nerdle.model.Color;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;

/**
 * custom component to simplify interaction with the board and keyboard on the screen
 * view equivalent of the model class Part
 *
 * @author robhe
 */
public class BoardPart extends StackPane {
    private final Region square;
    private final Label label;
    private static final Font FONT = Font.font("Times New Roman", 40);


    public BoardPart(Region square, Label label) {
        super(square, label);
        this.label = label;
        this.square = square;
        this.style();
    }

    /**
     * the base styling a BoardPart has
     */
    private void style() {
        square.setPrefSize(50, 50);
        square.setStyle("-fx-background-color: #8e8c8c; -fx-background-radius: 10 10 10 10; " +
                "-fx-border-color: black; -fx-border-radius: 10;");

        label.setText("");
        label.setMinHeight(20);
        label.setMinWidth(20);
        label.setFont(FONT);

        this.setPadding(new Insets(2, 2, 2, 2));

    }

    /**
     * the style a BoardPart gets when it is active on the board
     */
    public void setActiveStyle() {
        square.setStyle("-fx-background-color: #696868; -fx-background-radius: 10 10 10 10; " +
                "-fx-border-color: red; -fx-border-radius: 10;");
    }

    /**
     * the style a BoardPart gets when it is inactive on the board (this method is also used on the keyboard, when not hovering)
     *
     * @param color color of the BoardPart (enum Color, not a javaFX color)
     */
    public void setInactiveStyle(Color color) {
        String hexCode = color.translateColorToHex();
        square.setStyle(String.format("-fx-background-color: %s; -fx-background-radius: 10 10 10 10; " +
                "-fx-border-color: black; -fx-border-radius: 10;", hexCode));
    }

    /**
     * the style a BoardPart gets when it is hovered over (only on the keyboard, as they function as buttons, not on the board)
     *
     * @param color color of the BoardPart (enum Color, not a javaFX color)
     */
    public void setHoverStyle(Color color) {
        String hexCode = color.translateColorToLighterHex();
        square.setStyle(String.format("-fx-background-color: %s; -fx-background-radius: 10 10 10 10; " +
                "-fx-border-color: black; -fx-border-radius: 10;", hexCode));

        if (color == Color.BLACK) {
            label.setStyle("-fx-text-fill: white");
        }
    }

    /**
     * changing the color of a BoardPart
     *
     * @param color color of the BoardPart (enum Color, not a javaFX color)
     */
    public void setCustomColor(Color color) {
        String hexCode = color.translateColorToHex();
        square.setStyle(String.format("-fx-background-color: %s; -fx-background-radius: 10 10 10 10; " +
                "-fx-border-color: black; -fx-border-radius: 10;", hexCode));

        if (color.equals(Color.BLACK)) {
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