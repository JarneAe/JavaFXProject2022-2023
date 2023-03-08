package be.kdg.nerdle.view.HighcoreScreen;

import be.kdg.nerdle.model.User;
import be.kdg.nerdle.model.UserList;
import be.kdg.nerdle.model.jsonManager.JsonManager;
import be.kdg.nerdle.view.IntermediaryScreen.IntermediaryScreenPresenter;
import be.kdg.nerdle.view.IntermediaryScreen.IntermediaryScreenView;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

import java.util.List;
import java.util.Map;

public class HighscoreScreenPresenter {
    private final HighscoreScreenView view;
    private final User user;
    UserList userList;
    public HighscoreScreenPresenter(HighscoreScreenView view, User user) {
        this.user = user;
        this.view = view;
        userList = JsonManager.getAllUsersFromJson();
        addEventListeners();
        enterHighscoreList();
    }

    private void addEventListeners() {
        view.getBtnBack().setOnMouseClicked(event -> {
            IntermediaryScreenView intermediaryScreenView = new IntermediaryScreenView();
            new IntermediaryScreenPresenter(intermediaryScreenView, user);

            view.getScene().setRoot(intermediaryScreenView);
            intermediaryScreenView.getScene().getWindow().setWidth(1000);
            intermediaryScreenView.getScene().getWindow().setHeight(720);
        });
    }

    private void enterHighscoreList() {
        List<User> highscoreList = userList.generateHighScoreList();
        int rankCounter = 1;

        for (User u : highscoreList) {
            if (u.getAverageTries() != 0) {
                view.addToHighscoreList(rankCounter, u.getName(), u.getAverageTries(), u.equals(this.user));
                rankCounter++;
            }
        }

        view.addBackButton(rankCounter+1);
    }
}
