package be.kdg.nerdle.view.ProfileScreen;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;

public class ProfileScreenView extends BorderPane {
    private Label lbTitle;
    private static final Font FONT = Font.font("Times New Roman", 40);
    public ProfileScreenView(){
        initialiseNodes();
        layoutNodes();
    }

    private void initialiseNodes() {
        lbTitle = new Label("Nerdle");
        lbTitle.setFont(FONT);
    }

    private void layoutNodes() {
    }
}
