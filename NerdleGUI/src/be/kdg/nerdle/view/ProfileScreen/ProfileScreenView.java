package be.kdg.nerdle.view.ProfileScreen;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class ProfileScreenView extends BorderPane {
    private Label lbTitle;
    private Label lbUserTitle;
    private Label lbUserName;
    private Label lbTriesTitle;
    private Label lbTries;
    private Label lbPlayedTitle;
    private Label lbPlayed;
    private Button btnBackButton;

    private static final Font FONT = Font.font("Times New Roman", 40);

    private static final Font STATFONT = Font.font("Times New Roman", 30);

    public ProfileScreenView() {
        initialiseNodes();
        layoutNodes();
    }

    private void initialiseNodes() {
        lbTitle = new Label("Nerdle");
        lbTitle.setFont(FONT);
        lbUserTitle = new Label("User:  ");
        lbUserTitle.setFont(STATFONT);
        lbUserName = new Label("NAME");
        lbUserName.setFont(STATFONT);

        lbTriesTitle = new Label("Avg. Tries:  ");
        lbTriesTitle.setFont(STATFONT);
        lbTries = new Label("TRIES");
        lbTries.setFont(STATFONT);

        lbPlayedTitle = new Label("Played? ");
        lbPlayedTitle.setFont(STATFONT);

        lbPlayed = new Label("STATUS");
        lbPlayed.setFont(STATFONT);

        btnBackButton = new Button("BACK");
        setStyles();
    }

    private void layoutNodes() {
        HBox hbUser = new HBox(lbUserTitle, lbUserName);
        HBox hbTries = new HBox(lbTriesTitle, lbTries);
        HBox hbPlayed = new HBox(lbPlayedTitle, lbPlayed);
        VBox vbox = new VBox(lbTitle, hbUser, hbTries, hbPlayed, btnBackButton);


        hbUser.setPadding(new Insets(50, 0, 5, 0));
        hbPlayed.setPadding(new Insets(15, 0, 15, 0));
        hbTries.setPadding(new Insets(15, 0, 5, 0));

        vbox.setAlignment(Pos.CENTER);
        hbTries.setAlignment(Pos.CENTER);
        hbUser.setAlignment(Pos.CENTER);
        hbPlayed.setAlignment(Pos.CENTER);

        this.setTop(vbox);
    }

    Label getLbUserName() {
        return lbUserName;
    }

    Label getLbTries() {
        return lbTries;
    }

    Label getLbPlayed() {
        return lbPlayed;
    }

    Button getBtnBackButton() {
        return btnBackButton;
    }

    private void setStyles() {
        btnBackButton.setStyle("-fx-text-fill: white;" +
                "    -fx-font-family: \"Arial Narrow\";" +
                "    -fx-font-weight: bold;" +
                "    -fx-background-color: linear-gradient(#61a2b1, #2A5058); -fx-font-size: 25");
        this.setStyle("-fx-background-color: #cecccc");
    }
}
