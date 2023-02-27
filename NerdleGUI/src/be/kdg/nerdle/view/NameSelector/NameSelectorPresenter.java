package be.kdg.nerdle.view.NameSelector;

import be.kdg.nerdle.model.User;
import be.kdg.nerdle.model.jsonManager.JsonManager;
import be.kdg.nerdle.view.GameScreen.GameScreenPresenter;
import be.kdg.nerdle.view.GameScreen.GameScreenView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class NameSelectorPresenter {

    private final NameSelectorView view;


    public NameSelectorPresenter(NameSelectorView view){
        this.view = view;
        addEventListeners();
    }

    private void addEventListeners() {
        view.getBtnConfirm().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                userHandler();
                switchScreen();

            }
        });
    }

    private void userHandler(){
        String name = view.getTfUserInput().getText();
        User user = JsonManager.handleEnteredUsername(name);
        System.out.println(user);
    }

    private void switchScreen(){
        GameScreenView GameScreenView = new GameScreenView();
        new GameScreenPresenter(GameScreenView);

        view.getScene().setRoot(GameScreenView);
    }
}
