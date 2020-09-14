package sample.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.DatabaseHandler;
import sample.Person;

import java.io.IOException;
import java.sql.SQLException;

public class RegisterScreenController {

    public TextField textFieldFirstName;
    public TextField textFieldLastName;
    public Button buttonRegister;
    public PasswordField passwordFieldPassword;
    public TextField textFieldUsername;

    public void onRegisterClick(ActionEvent actionEvent) throws SQLException, IOException {

        String firstName = textFieldFirstName.getText();
        String lastName = textFieldLastName.getText();
        String username = textFieldUsername.getText();
        String password = passwordFieldPassword.getText();

        if (!firstName.isEmpty() && !lastName.isEmpty() && !username.isEmpty() && !password.isEmpty()) {
            //TODO: INSERT INTO Database
            DatabaseHandler.insertClient(new Person(0, firstName, lastName, password, username));
        }
        Parent root = FXMLLoader.load(getClass().getResource("../fxml/LoginScreen.fxml"));

        Stage stage = new Stage();
        stage.setTitle("");
        stage.setScene(new Scene(root, 608, 347));
        stage.show();
        ((Node) actionEvent.getSource()).getScene().getWindow().hide();
    }
}
