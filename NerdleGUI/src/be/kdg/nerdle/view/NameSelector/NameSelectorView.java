package be.kdg.nerdle.view.NameSelector;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;

public class NameSelectorView extends BorderPane {

    public static final Font SELECTORFONT = Font.font("Times New Roman",20);
    public static final Font LABELFONT = Font.font("Times New Roman", 40);
    private Label lbTitle;
    private Label lbText;

    private TextField tfUserInput;

    private Button btnConfirm;

    public NameSelectorView(){
        initialiseNodes();
        layoutNodes();
    }

    private void layoutNodes() {
        HBox hbCenter = new HBox(lbText,tfUserInput,btnConfirm);
        hbCenter.setAlignment(Pos.CENTER);
        HBox hbTop = new HBox(lbTitle);
        hbTop.setAlignment(Pos.TOP_CENTER);
        this.setCenter(hbCenter);
        this.setTop(hbTop);


    }

    private void initialiseNodes() {
        lbTitle = new Label("Nerdle");
        lbTitle.setFont(LABELFONT);
        lbText = new Label("enter your name: ");
        lbText.setFont(SELECTORFONT);
        tfUserInput = new TextField("");
        tfUserInput.setFont(SELECTORFONT);
        btnConfirm = new Button("Confirm");
        btnConfirm.setFont(SELECTORFONT);
    }

    public TextField getTfUserInput() {
        return tfUserInput;
    }

    public void setStyleInvalidUsername() {
        tfUserInput.setStyle("-fx-border-color: red");
    }

    public Button getBtnConfirm() {
        return btnConfirm;
    }
}
