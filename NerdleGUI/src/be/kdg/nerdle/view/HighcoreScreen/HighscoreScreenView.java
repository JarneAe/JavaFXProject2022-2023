package be.kdg.nerdle.view.HighcoreScreen;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;

public class HighscoreScreenView extends ScrollPane {

    private GridPane highscoreList;
    private Label usernameTitle;
    private Label scoreTitle;
    private Label rankTitle;
    private Button btnBack;

    private static final String TITLE_STYLE = "-fx-border-color: black; -fx-padding: 10; -fx-font-weight: bold; -fx-background-color: #a4a4a4;" +
            " -fx-font-family: 'Times New Roman'; -fx-font-size: 30";

    private static final String BUTTON_BACK_STYLE = "-fx-font-size: 25; -fx-border-color: grey";

    private static final String ENTRY_STYLE = "-fx-label-padding: 10; -fx-font-family: 'Times New Roman'; -fx-font-size: 20";

    private static final String LOGGED_IN_USER_STYLE = "-fx-label-padding: 10; -fx-font-family: 'Times New Roman'; -fx-font-size: 20; -fx-text-fill: red";

    public Button getBtnBack() {
        return btnBack;
    }

    public HighscoreScreenView() {
        initialiseNodes();
        layoutNodes();
    }

    private void initialiseNodes() {
        highscoreList = new GridPane();
        btnBack = new Button("Back");

        rankTitle = new Label("Rank");
        usernameTitle = new Label("Username");
        scoreTitle = new Label("Average score");
        rankTitle.setStyle(TITLE_STYLE);
        usernameTitle.setStyle(TITLE_STYLE);
        scoreTitle.setStyle(TITLE_STYLE);
        btnBack.setStyle(BUTTON_BACK_STYLE);
    }

    private void layoutNodes() {
        highscoreList.add(rankTitle, 0, 0);
        highscoreList.add(usernameTitle, 1, 0);
        highscoreList.add(scoreTitle, 2, 0);
//        highscoreList.add(btnBack, 3, 0);

        this.setContent(highscoreList);
    }

    public void addToHighscoreList(int rank, String name, Double score, boolean isLoggedInUser) {
        Label rankLabel = new Label(Integer.toString(rank));
        Label nameLabel = new Label(name);
        Label scoreLabel = new Label(score.toString());

        if (isLoggedInUser) {
            rankLabel.setStyle(LOGGED_IN_USER_STYLE);
            nameLabel.setStyle(LOGGED_IN_USER_STYLE);
            scoreLabel.setStyle(LOGGED_IN_USER_STYLE);
        } else {
            rankLabel.setStyle(ENTRY_STYLE);
            nameLabel.setStyle(ENTRY_STYLE);
            scoreLabel.setStyle(ENTRY_STYLE);
        }

        nameLabel.setMaxSize(150, Double.MAX_VALUE);

        highscoreList.add(rankLabel, 0, rank);
        highscoreList.add(nameLabel, 1, rank);
        highscoreList.add(scoreLabel, 2, rank);
    }

    public void addBackButton(int row) {
        highscoreList.add(btnBack, 0, row);
    }
}
