package be.kdg.nerdle.view.MainMenu;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;


public class MainMenuView extends BorderPane {
    private  static final Font BUTTONFONT = Font.font("Times New Roman", 40);
    private static final Font LABELFONT = Font.font("Times New Roman", 40);
    private Label lbTitle;
    private Button btnStart;



    public MainMenuView(){
        initialiseNodes();
        layoutNodes();
    }

    private void layoutNodes() {

        //layout for title
        HBox hbTop = new HBox(lbTitle);
        hbTop.setAlignment(Pos.CENTER);

        //layout for button
        HBox hbBottom = new HBox(btnStart);
        hbBottom.setAlignment(Pos.TOP_CENTER);

        //putting items on screen
        this.setCenter(hbTop);
        this.setBottom(hbBottom);

    }

    private void initialiseNodes() {
        lbTitle = new Label("Nerdle");
        lbTitle.setFont(LABELFONT);
        btnStart = new Button("START");
        btnStart.setFont(BUTTONFONT);
    }

    public Button getBtnStart() {
        return btnStart;
    }
}
