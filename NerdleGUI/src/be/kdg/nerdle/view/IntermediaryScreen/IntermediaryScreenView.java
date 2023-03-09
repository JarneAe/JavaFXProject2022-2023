package be.kdg.nerdle.view.IntermediaryScreen;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;

public class IntermediaryScreenView extends HBox {
    private static final Font FONT = Font.font("Times New Roman", 40);
    private Button btnStart;
    private Button btnProfile;
    private Button btnStats;

    public IntermediaryScreenView() {
        initialiseNodes();
        layoutNodes();
    }

    public Button getBtnStart() {
        return btnStart;
    }

    public Button getBtnProfile() {
        return btnProfile;
    }

    public Button getBtnStats() {
        return btnStats;
    }

    private void initialiseNodes() {
        btnProfile = new Button();
        btnProfile.setFont(FONT);
        btnStats = new Button();
        btnStats.setFont(FONT);
        btnStart = new Button("Start");
        btnStart.setFont(FONT);

        ImageView profileImage = new ImageView(new Image("ProfileIcon.jpg"));
        ImageView statsImage = new ImageView(new Image("leaderboard.png"));
        profileImage.resize(10,10);
        btnProfile.setGraphic(profileImage);
        btnProfile.setPadding(Insets.EMPTY);
        btnProfile.setMaxSize(10,10);
        btnStats.setMaxSize(10,10);
        btnStats.setGraphic(statsImage);
        btnStats.setPadding(Insets.EMPTY);

        // this dumb button decides on a whim to resize to the most
        // idiotic things, so this is somehow necessary
        btnStart.setMinSize(150, 75);
        btnStart.setMaxSize(150, 75);

        this.getChildren().addAll(btnProfile, btnStart, btnStats);
        this.setSpacing(100);
        setStyles();
    }

    private void layoutNodes() {
        this.setAlignment(Pos.CENTER);
    }

    private void setStyles(){
        btnStart.setStyle("-fx-text-fill: white;" +
                "    -fx-font-family: \"Arial Narrow\";" +
                "    -fx-font-weight: bold;" +
                "    -fx-background-color: linear-gradient(#61a2b1, #2A5058); -fx-font-size: 40;-fx-hgap: 5");
        this.setStyle("-fx-background-color: #cecccc");

    }
}
