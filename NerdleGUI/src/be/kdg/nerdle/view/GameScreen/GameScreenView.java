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
import javafx.scene.text.Text;

public class GameScreenView extends BorderPane {

    private static final Font FONT = Font.font("Times New Roman", 40);
    private Label lbTitle;
    private BoardPart[][] boardParts = new BoardPart[8][8];
    private Button btnProfile;
    private Button btnStats;

    private Label lbTest;

    private Region square;
    private StackPane spSquare;


    public GameScreenView(){
        initialiseNodes();
        layoutNodes();
    }

    public BoardPart getBoardPart(int i, int j) {
        return boardParts[i][j];
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

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                gpMid.add(boardParts[i][j], i, j);
            }
        }

        this.setTop(bpTop);
        this.setCenter(gpMid);
        gpMid.setAlignment(Pos.CENTER);

        boardParts[3][2].setText("2");

    }

    private void initialiseNodes() {
        lbTitle = new Label("Nerdle");
        lbTitle.setFont(FONT);
        btnProfile = new Button();
        btnProfile.setFont(FONT);
        btnStats = new Button();
        btnStats.setFont(FONT);
        lbTest = new Label("1");
        lbTest.setFont(FONT);
        lbTest.setMinHeight(20);
        lbTest.setMinWidth(20);

        square = new Region();
        square.setPrefSize(50, 50);
        square.setStyle("-fx-background-color: #818181; -fx-background-radius: 10 10 10 10");

        spSquare = new StackPane(square,lbTest);

        ImageView profileImage = new ImageView(new Image("ProfileIcon.jpg"));
        ImageView statsImage = new ImageView(new Image("leaderboard.png"));
        profileImage.resize(10,10);
        btnProfile.setGraphic(profileImage);
        btnProfile.setPadding(Insets.EMPTY);
        btnProfile.setMaxSize(10,10);
        btnStats.setMaxSize(10,10);
        btnStats.setGraphic(statsImage);
        btnStats.setPadding(Insets.EMPTY);

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                boardParts[i][j] = new BoardPart(new Region(), new Label());
                boardParts[i][j].style();
            }
        }

    }
}
