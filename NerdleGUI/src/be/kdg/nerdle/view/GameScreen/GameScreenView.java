package be.kdg.nerdle.view.GameScreen;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.image.ImageView;

import java.util.Objects;

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
        GridPane gameScreen = new GridPane();

        gameScreen.setVgap(10);
        gameScreen.setHgap(10);
        gameScreen.setPrefSize(400,400);
        this.setCenter(gameScreen);

        HBox hbButn = new HBox(btnProfile,btnStats);
        hbButn.setSpacing(20);
        hbButn.setAlignment(Pos.TOP_RIGHT);
        BorderPane.setMargin(hbButn,new Insets(10));


        HBox hbTitle = new HBox(lbTitle);
        hbTitle.setSpacing(20);
        hbTitle.setAlignment(Pos.TOP_LEFT);
        BorderPane.setMargin(hbButn,new Insets(10));


        HBox hbTop = new HBox(hbTitle,hbButn);
        hbTop.setSpacing(20);
        hbTop.setAlignment(Pos.TOP_RIGHT);
        BorderPane.setMargin(hbTop,new Insets(10));


        this.setTop(hbTop);
        

    }

    private void initialiseNodes() {
        lbTitle = new Label("Nerdle");
        lbTitle.setFont(FONT);
        btnProfile = new Button("");
        btnProfile.setFont(FONT);
        btnStats = new Button("");
        btnStats.setFont(FONT);

        ImageView profileImage = new ImageView(new Image("F:\\Programming\\Repos\\JavaFXProject2022-2023\\NerdleGUI\\ProfileIcon.jpg"));
        ImageView statsImage = new ImageView(new Image("F:\\Programming\\Repos\\JavaFXProject2022-2023\\NerdleGUI\\leaderboard.png"));
        profileImage.resize(10,10);
        btnProfile.setGraphic(profileImage);
        btnProfile.setPadding(Insets.EMPTY);
        btnProfile.setMaxSize(10,10);
        btnStats.setMaxSize(10,10);
        btnStats.setGraphic(statsImage);
        btnStats.setPadding(Insets.EMPTY);

    }




}
