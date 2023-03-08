package be.kdg.nerdle.view.GameScreen;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import java.util.ArrayList;
import java.util.List;

public class GameScreenView extends BorderPane {

    private static final Font FONT = Font.font("Times New Roman", 40);
    private Label lbTitle;
    private final BoardPart[][] boardParts = new BoardPart[8][6];
    private final List<BoardPart> keyboardParts = new ArrayList<>();
    private final BoardPart[] keyboardPartsNumeric = new BoardPart[10];
    private final BoardPart[] keyboardPartsOperatorsAndControls = new BoardPart[7];

    public GameScreenView(){
        initialiseNodes();
        layoutNodes();
    }

    public BoardPart getBoardPart(int i, int j) {
        return boardParts[i][j];
    }

    public BoardPart getKeyboardPart(int i) {
        return keyboardParts.get(i);
    }

    private void layoutNodes() {

        lbTitle.setAlignment(Pos.CENTER);

        Label lbLeft = new Label();
        lbLeft.setPrefSize(100, 0);
        lbLeft.setMinSize(0,0);

        BorderPane bpTop = new BorderPane();
        bpTop.setCenter(lbTitle);

        GridPane gpMid = new GridPane();

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 6; j++) {
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

    private void initialiseNodes() {
        lbTitle = new Label("Nerdle");
        lbTitle.setFont(FONT);

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 6; j++) {
                boardParts[i][j] = new BoardPart(new Region(), new Label());
                boardParts[i][j].style();
            }
        }

        String[] keyboardCharactersNumeric = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        String[] keyboardCharactersOperatorsAndControls = {"+", "-", "*", "/", "=", "Enter", "Delete"};
        for (int i = 0; i < 10; i++) {
            keyboardPartsNumeric[i] = new BoardPart(new Region(), new Label());
            keyboardParts.add(keyboardPartsNumeric[i]);
            keyboardPartsNumeric[i].style();
            keyboardPartsNumeric[i].setText(keyboardCharactersNumeric[i]);
        }

        for (int i = 0; i < 7; i++) {
            keyboardPartsOperatorsAndControls[i] = new BoardPart(new Region(), new Label());
            keyboardParts.add(keyboardPartsOperatorsAndControls[i]);
            keyboardPartsOperatorsAndControls[i].style();
            keyboardPartsOperatorsAndControls[i].setText(keyboardCharactersOperatorsAndControls[i]);
        }
    }
}
