package be.kdg.nerdle.view.GameScreen;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

public class GameScreenView extends BorderPane {

    private static final Font FONT = Font.font("Times New Roman", 40);
    private Label lbTitle;
    private Button btnProfile;
    private Button btnStats;

    public GameScreenView(){
        initialiseNodes();
        layoutNodes();
    }

    private void layoutNodes() {
        GridPane gameSCreen = new GridPane();
        

    }

    private void initialiseNodes() {
    }




}
