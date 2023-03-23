package be.kdg.nerdle.view.NameSelector;

import be.kdg.nerdle.model.User;
import be.kdg.nerdle.model.jsonmanager.JsonManager;
import be.kdg.nerdle.view.IntermediaryScreen.IntermediaryScreenPresenter;
import be.kdg.nerdle.view.IntermediaryScreen.IntermediaryScreenView;

public class NameSelectorPresenter {

    private final NameSelectorView view;


    public NameSelectorPresenter(NameSelectorView view){
        this.view = view;
        addEventListeners();
    }

    private void addEventListeners() {
        view.getBtnConfirm().setOnAction(actionEvent -> userHandlerAndSwitchScreen());
    }

    private void userHandlerAndSwitchScreen(){
        String name = view.getTfUserInput().getText();

        if (name.length() <= 3 || name.length() >= 20) { // name length is a minimum of 3, max of 20
            view.setStyleInvalidUsername();

        } else {
            User user = JsonManager.handleEnteredUsername(name);

            IntermediaryScreenView intermediaryScreenView = new IntermediaryScreenView();
            new IntermediaryScreenPresenter(intermediaryScreenView, user);
            view.getScene().setRoot(intermediaryScreenView);
        }
    }
}
