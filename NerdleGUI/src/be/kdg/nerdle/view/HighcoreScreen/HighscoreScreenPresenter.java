package be.kdg.nerdle.view.HighcoreScreen;

import be.kdg.nerdle.model.User;
import be.kdg.nerdle.model.UserList;
import be.kdg.nerdle.model.jsonManager.JsonManager;

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
    }
}
