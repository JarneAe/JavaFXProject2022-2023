package be.kdg.nerdle.view.MainMenu;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
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

        //Screen setup
        GridPane mainMenu = new GridPane();

        mainMenu.setVgap(10);
        mainMenu.setHgap(10);
        mainMenu.setPrefSize(400,400);
        this.setCenter(mainMenu);

        //layout for title
        HBox hbTop = new HBox(lbTitle);
        hbTop.setSpacing(20);
        hbTop.setAlignment(Pos.CENTER);
        BorderPane.setMargin(hbTop,new Insets(10));

        //layout for button
        HBox hbBottom = new HBox(btnStart);
        hbBottom.setSpacing(20);
        hbBottom.setAlignment(Pos.TOP_CENTER);
        BorderPane.setMargin(hbBottom,new Insets(10));

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

    public Label getLbTitle() {
        return lbTitle;
    }

    public Button getBtnStart() {
        return btnStart;
    }
}
