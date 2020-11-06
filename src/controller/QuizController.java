package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import module.QuestionCatalog;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

public class QuizController {
    private QuestionCatalog questionCatalog;
    private int questionCounter;

    public void initialize() {
        questionCatalog = new QuestionCatalog();
        questionTextArea.setText(questionCatalog.getQuestion(questionCounter).getQuestionText());
    }

    @FXML
    private TextArea questionTextArea;

    @FXML
    private Button trueButton;

    @FXML
    private Button falseButton;

    @FXML
    void handleButton(ActionEvent event) throws IOException {
        Button clickedButton = (Button) event.getSource();
        boolean userChoice = checkButton(clickedButton);

        FXMLLoader fxmlLoader = new FXMLLoader();
        
        FXMLLoader.setLocation(getClass().getResource("/view/resultDialog.fxml"));

        DialogController dialogController = loader.getController();
        Parent root = loader.load();


        if (questionCatalog.getQuestion(questionCounter).isQuestionAnswer() == userChoice) {
            System.out.println("Antwort war richtig");
            dialogController.setResult("richtig");
        }
        else {
            System.out.println("Antwort war falsch");
            dialogController.setResult("falsch");
        }

        root = loader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();

        questionCounter++;
        questionTextArea.setText(questionCatalog.getQuestion(questionCounter).getQuestionText());
    }

    private boolean checkButton(Button clickedButton) {
        boolean usersChoice;

        if (clickedButton.equals(trueButton)) {
            usersChoice = true;
        }
        else {
            usersChoice = false;
        }

        return usersChoice;
    }


    private void loadQuestionImage(int index)
    {
        File file = new File("src/resources/question" + (index +1) + ".png");
        String localUrl = null;
        try {
            localUrl = file.toURI().toURL().toString();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        Image image = new Image(localUrl);

        imageViewField.setImage(image);
    }
}
