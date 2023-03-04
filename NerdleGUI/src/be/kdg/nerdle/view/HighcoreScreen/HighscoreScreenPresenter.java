package be.kdg.nerdle.view.HighcoreScreen;

import be.kdg.nerdle.model.User;
import be.kdg.nerdle.model.UserList;
import be.kdg.nerdle.model.jsonManager.JsonManager;

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
        Map<String, Double> highscoreList = userList.generateHighScoreList();

        for (Map.Entry<String, Double> entry : highscoreList.entrySet()) {
            if (entry.getValue() != 0) {
                view.addToHighscoreList(entry.getKey(), entry.getValue(), entry.getKey().equals(user.getName()));
            }
        }
    }
}
