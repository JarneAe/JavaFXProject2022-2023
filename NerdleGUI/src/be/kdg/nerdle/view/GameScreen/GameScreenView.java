package be.kdg.nerdle.view.GameScreen;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.image.ImageView;

public class GameScreenView extends BorderPane {

    private static final Font FONT = Font.font("Times New Roman", 40);
    private Label lbTitle;
    private Button btnProfile;
    private Button btnStats;

    private Label lbTest;

    private Rectangle square;

    public GameScreenView(){
        initialiseNodes();
        layoutNodes();
    }

    private void layoutNodes() {

        HBox hbButn = new HBox(btnProfile,btnStats);
        hbButn.setAlignment(Pos.BASELINE_RIGHT);

        HBox hbTitle = new HBox(lbTitle);
        hbTitle.setAlignment(Pos.BASELINE_CENTER);



        HBox hbTop = new HBox(hbTitle,hbButn);
        hbTop.setSpacing(50);
        hbTop.setAlignment(Pos.TOP_CENTER);
        hbTop.setMinSize(400,400);


        this.setTop(hbTop);

    }

    private void initialiseNodes() {
        lbTitle = new Label("Nerdle");
        lbTitle.setFont(FONT);
        btnProfile = new Button("");
        btnProfile.setFont(FONT);
        btnStats = new Button("");
        btnStats.setFont(FONT);
        lbTest = new Label("test");
        lbTest.setFont(FONT);
        lbTest.setMinHeight(20);
        lbTest.setMinWidth(20);
        Rectangle square = new Rectangle(150,150, Color.BLUE);

        ImageView profileImage = new ImageView(new Image("ProfileIcon.jpg"));
        ImageView statsImage = new ImageView(new Image("leaderboard.png"));
        profileImage.resize(10,10);
        btnProfile.setGraphic(profileImage);
        btnProfile.setPadding(Insets.EMPTY);
        btnProfile.setMaxSize(10,10);
        btnStats.setMaxSize(10,10);
        btnStats.setGraphic(statsImage);
        btnStats.setPadding(Insets.EMPTY);

    }
}
