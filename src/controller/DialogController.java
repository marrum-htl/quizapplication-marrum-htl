package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class DialogController {

    @FXML
    private Label resultPopup;

    public void setResult(String result)
    {
        resultPopup.setText(result);
    }


}
