package be.kdg.nerdle.view.ProfileScreen;

import be.kdg.nerdle.model.User;
import be.kdg.nerdle.view.IntermediaryScreen.IntermediaryScreenPresenter;
import be.kdg.nerdle.view.IntermediaryScreen.IntermediaryScreenView;

public class ProfileScreenPresenter {
    private  final ProfileScreenView view;

    private final User user;

    public ProfileScreenPresenter(ProfileScreenView view,User user) {
        this.view = view;
        this.user = user;
        setLabels();
        addEventListeners();
    }

    private void setLabels(){
        view.getLbUserName().setText(user.getName());
        view.getLbTries().setText(String.valueOf(user.getAverageTries()));
        view.getLbPlayed().setText(String.valueOf(user.hasPlayedToday()));
    }

    private void addEventListeners() {
        view.getBtnBackButton().setOnMouseClicked(event -> {
            IntermediaryScreenView intermediaryScreenView = new IntermediaryScreenView();
            new IntermediaryScreenPresenter(intermediaryScreenView, user);

            view.getScene().setRoot(intermediaryScreenView);
            intermediaryScreenView.getScene().getWindow().setWidth(1000);
            intermediaryScreenView.getScene().getWindow().setHeight(720);
        });
    }
}

