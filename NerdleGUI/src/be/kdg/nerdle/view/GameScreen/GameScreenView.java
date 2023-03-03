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

    private Region square;


    public GameScreenView(){
        initialiseNodes();
        layoutNodes();
    }

    private void layoutNodes() {

        lbTitle.setAlignment(Pos.CENTER);

        Label lbLeft = new Label();
        lbLeft.setPrefSize(100, 0);
        lbLeft.setMinSize(0,0);

        BorderPane bpTop = new BorderPane();
        bpTop.setCenter(lbTitle);
        bpTop.setRight(btnProfile);
        bpTop.setLeft(btnStats);



        GridPane gpMid = new GridPane();
        StackPane spSquare = new StackPane(square,lbTest);
        gpMid.add(spSquare,1,1);

        this.setTop(bpTop);
        this.setCenter(gpMid);

    }

    private void initialiseNodes() {
        lbTitle = new Label("Nerdle");
        lbTitle.setFont(FONT);
        btnProfile = new Button("");
        btnProfile.setFont(FONT);
        btnStats = new Button("");
        btnStats.setFont(FONT);
        lbTest = new Label("1");
        lbTest.setFont(FONT);
        lbTest.setMinHeight(20);
        lbTest.setMinWidth(20);

        square = new Region();
        square.setPrefSize(50, 50);
        square.setStyle("-fx-background-color: #818181; -fx-background-radius: 10 10 10 10");

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
