package be.kdg.nerdle.view.HighcoreScreen;

import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;

public class HighscoreScreenView extends ScrollPane {

    private GridPane highscoreList;
    private Label usernameTitle;
    private Label scoreTitle;
    private Label rankTitle;

    private static int rowCounter = 1;
    private static final String TITLE_STYLE = "-fx-border-color: black; -fx-label-padding: 10; -fx-font-weight: bold; -fx-background-color: #a4a4a4;" +
            " -fx-font-family: 'Times New Roman'; -fx-font-size: 30";

    private static final String ENTRY_STYLE = "-fx-label-padding: 10; -fx-font-family: 'Times New Roman'; -fx-font-size: 25";

    private static final String LOGGED_IN_USER_STYLE = "-fx-label-padding: 10; -fx-font-family: 'Times New Roman'; -fx-font-size: 25; -fx-text-fill: red";
    public HighscoreScreenView() {
        initialiseNodes();
        layoutNodes();
    }

    private void initialiseNodes() {
        highscoreList = new GridPane();

        rankTitle = new Label("Rank");
        usernameTitle = new Label("Username");
        scoreTitle = new Label("Average score");
        rankTitle.setStyle(TITLE_STYLE);
        usernameTitle.setStyle(TITLE_STYLE);
        scoreTitle.setStyle(TITLE_STYLE);
    }

    private void layoutNodes() {
        highscoreList.add(rankTitle, 0, 0);
        highscoreList.add(usernameTitle, 1, 0);
        highscoreList.add(scoreTitle, 2, 0);

        this.setContent(highscoreList);
    }

    public void addToHighscoreList(String name, Double score, boolean isLoggedInUser) {
        Label rankLabel = new Label(Integer.toString(rowCounter));
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

        highscoreList.add(rankLabel, 0, rowCounter);
        highscoreList.add(nameLabel, 1, rowCounter);
        highscoreList.add(scoreLabel, 2, rowCounter);
        rowCounter++;
    }
}
