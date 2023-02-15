package be.kdg.nerdle.view;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class MainMenuPresenter {
    private MainMenuView view;

    public MainMenuPresenter(MainMenuView view){
        this.view = view;
        addEventListeners();
    }

    private void addEventListeners() {
        view.getBtnStart().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                NameSelectorView view = new NameSelectorView();
            }
        });
    }
}