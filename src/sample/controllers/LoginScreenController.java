package sample.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import sample.DatabaseHandler;
import sample.LoginedPerson;
import sample.Person;

import java.io.IOException;


public class LoginScreenController {

    public TextField textFieldUsername;
    public TextField textFieldPassword;
    public Button buttonJoin;
    public Button buttonRegister;

    public void onRegisterClick(ActionEvent actionEvent) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("../fxml/RegisterScreen.fxml"));

            Stage stage = new Stage();
            stage.setTitle("Register Window");
            stage.setScene(new Scene(root, 608, 347));
            stage.show();
            ((Node) actionEvent.getSource()).getScene().getWindow().hide();
        } catch (IOException ignored) {

        }
    }

    public void onJoinClick(ActionEvent actionEvent) {
        performLogin();
        ((Node) actionEvent.getSource()).getScene().getWindow().hide();
    }

    private void performLogin() {
        String login = textFieldUsername.getText();
        String password = textFieldPassword.getText();
        Person person = DatabaseHandler.getPersonByLoginAndPassword(login, password);
        if (person != null) {
            LoginedPerson.activePerson = person;
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("../fxml/JoinedUserScreen.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            Scene scene = new Scene(root);
            Stage s = new Stage();
            s.setScene(scene);
            s.show();
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Not logined");
            alert.setHeaderText("Not logined");
            alert.showAndWait();
        }
    }

    public void onPasswordFieldKeyPressed(KeyEvent keyEvent) {
        if (keyEvent.getCode() == KeyCode.ENTER) {
            performLogin();

            ((Node) keyEvent.getSource()).getScene().getWindow().hide();
        }
    }

    public void onHistoryClick(ActionEvent actionEvent) {

        HistoryScreenController controller = null;
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("../fxml/HistoryScreen.fxml"));
            loader.load();
            Parent root = loader.getRoot();
            controller = loader.getController();
            controller.prerun();
            Scene scene = new Scene(root);
            Stage s = new Stage();
            s.setScene(scene);
            s.show();
            ((Node) actionEvent.getSource()).getScene().getWindow().hide();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
