package be.kdg.nerdle.view.GameScreen;

import be.kdg.nerdle.customcomponents.BoardPart;
import be.kdg.nerdle.model.Board;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.text.Font;

import java.util.ArrayList;
import java.util.List;

public class GameScreenView extends BorderPane {

    private static final Font FONT = Font.font("Times New Roman", 40);
    private Label lbTitle;
    private final BoardPart[][] boardParts = new BoardPart[Board.LENGTH_OF_ROW][Board.ROWS];
    private final List<BoardPart> keyboardParts = new ArrayList<>();
    private final BoardPart[] keyboardPartsNumeric = new BoardPart[10];
    private final BoardPart[] keyboardPartsOperatorsAndControls = new BoardPart[7];

    public GameScreenView() {
        initialiseNodes();
        layoutNodes();
    }

    BoardPart getBoardPart(int i, int j) {
        return boardParts[i][j];
    }

    BoardPart getKeyboardPart(int i) {
        return keyboardParts.get(i);
    }

    private void initialiseNodes() {
        lbTitle = new Label("Nerdle");
        lbTitle.setFont(FONT);

        for (int i = 0; i < Board.LENGTH_OF_ROW; i++) {
            for (int j = 0; j < Board.ROWS; j++) {
                boardParts[i][j] = new BoardPart(new Region(), new Label());
            }
        }

        String[] keyboardCharactersNumeric = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        String[] keyboardCharactersOperatorsAndControls = {"+", "-", "*", "/", "=", "Enter", "Delete"};

        initialiseKeyboard(keyboardCharactersNumeric, keyboardPartsNumeric);
        initialiseKeyboard(keyboardCharactersOperatorsAndControls, keyboardPartsOperatorsAndControls);

        this.setStyle("-fx-background-color: #cecccc");
    }

    private void layoutNodes() {

        lbTitle.setAlignment(Pos.CENTER);

        Label lbLeft = new Label();
        lbLeft.setPrefSize(100, 0);
        lbLeft.setMinSize(0, 0);

        BorderPane bpTop = new BorderPane();
        bpTop.setCenter(lbTitle);

        GridPane gpMid = new GridPane();

        for (int i = 0; i < Board.LENGTH_OF_ROW; i++) {
            for (int j = 0; j < Board.ROWS; j++) {
                gpMid.add(boardParts[i][j], i, j);
            }
        }

        HBox numeric = new HBox();
        HBox operatorsAndControls = new HBox();
        VBox overview = new VBox();

        for (BoardPart bp : keyboardPartsNumeric) {
            numeric.getChildren().add(bp);
        }

        for (BoardPart bp : keyboardPartsOperatorsAndControls) {
            operatorsAndControls.getChildren().add(bp);
        }

        overview.getChildren().addAll(numeric, operatorsAndControls);
        numeric.setAlignment(Pos.CENTER);
        operatorsAndControls.setAlignment(Pos.CENTER);

        this.setTop(bpTop);
        this.setCenter(gpMid);
        this.setBottom(overview);
        gpMid.setAlignment(Pos.CENTER);
        overview.setAlignment(Pos.CENTER);
    }

    // extracted method from something that was done manually before
    private void initialiseKeyboard(String[] characters, BoardPart[] parts) {
        for (int i = 0; i < characters.length; i++) {
            parts[i] = new BoardPart(new Region(), new Label());
            keyboardParts.add(parts[i]);
            parts[i].setText(characters[i]);
        }
    }
}
