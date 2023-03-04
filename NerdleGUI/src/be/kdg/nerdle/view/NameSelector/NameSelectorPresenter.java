package be.kdg.nerdle.view.NameSelector;

import be.kdg.nerdle.model.User;
import be.kdg.nerdle.model.jsonManager.JsonManager;
import be.kdg.nerdle.view.GameScreen.GameScreenPresenter;
import be.kdg.nerdle.view.GameScreen.GameScreenView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class NameSelectorPresenter {

    private final NameSelectorView view;
    private User user;


    public NameSelectorPresenter(NameSelectorView view){
        this.view = view;
        addEventListeners();
    }

    private void addEventListeners() {
        view.getBtnConfirm().setOnAction(actionEvent -> userHandlerAndSwitchScreen());
    }

    private void userHandlerAndSwitchScreen(){
        String name = view.getTfUserInput().getText();

        if (name.length() < 3) { // name length is a minimum of 3
            view.setStyleInvalidUsername();

        } else {
            this.user = JsonManager.handleEnteredUsername(name);
            System.out.println(user);

            GameScreenView GameScreenView = new GameScreenView();
            new GameScreenPresenter(GameScreenView, user);

            view.getScene().setRoot(GameScreenView);
        }
    }
}
