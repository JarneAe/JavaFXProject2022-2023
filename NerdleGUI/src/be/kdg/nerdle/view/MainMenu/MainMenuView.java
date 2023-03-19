package be.kdg.nerdle.view.MainMenu;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;


public class MainMenuView extends BorderPane {
    public static final Font FONT = Font.font("Times New Roman", 40);
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
        lbTitle.setFont(FONT);
        btnStart = new Button("START");
        btnStart.setFont(FONT);
        setStyles();
    }

    Button getBtnStart() {
        return btnStart;
    }

    private void setStyles(){
        btnStart.setStyle("-fx-text-fill: white;" +
                "    -fx-font-family: \"Arial Narrow\";" +
                "    -fx-font-weight: bold;" +
                "    -fx-background-color: linear-gradient(#61a2b1, #2A5058); -fx-font-size: 25;-fx-hgap: 5");
        this.setStyle("-fx-background-color: #cecccc");

    }
}
