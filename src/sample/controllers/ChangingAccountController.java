package sample.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.DatabaseHandler;
import sample.LoginedPerson;

import java.io.IOException;

public class ChangingAccountController {

    public TextField newNickNameField;
    public PasswordField newPasswordFieldOne;
    public PasswordField newPasswordFieldTwo;
    public Button okButton;

    public void onOkButtonClick(ActionEvent actionEvent) throws IOException {
        String newNickName = newNickNameField.getText();
        String newPasswordOne = newPasswordFieldOne.getText();
        String newPasswordTwo = newPasswordFieldTwo.getText();

        if (!newNickName.isEmpty() || (!newPasswordOne.isEmpty() && !newPasswordTwo.isEmpty()) && newPasswordOne.equals(newPasswordTwo)) {
            LoginedPerson.activePerson.setUsername(newNickName);
            LoginedPerson.activePerson.setPassword(newPasswordOne);
            DatabaseHandler.updatePerson(LoginedPerson.activePerson);
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Smth was wrong");
            alert.setHeaderText("Smth was wrong");
            alert.showAndWait();
        }
        Parent root = FXMLLoader.load(getClass().getResource("../fxml/LoginScreen.fxml"));

        Stage stage = new Stage();
        stage.setTitle("");
        stage.setScene(new Scene(root, 608, 347));
        stage.show();
        ((Node) actionEvent.getSource()).getScene().getWindow().hide();
    }
}
