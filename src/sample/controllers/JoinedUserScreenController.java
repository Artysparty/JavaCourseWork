package sample.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import sample.DatabaseHandler;
import sample.LoginedPerson;
import sample.hotel.Order;

import java.io.IOException;

public class JoinedUserScreenController {

    public ImageView ImageButtonHotel;
    public ImageView ImageButtonHostel;

    public void onLuxeButtonCkick(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("../fxml/LuxeApartment.fxml"));
            loader.load();
            LuxeApartmentController controller = loader.getController();
            Parent root = loader.getRoot();

            Order order = new Order(0, LoginedPerson.activePerson.getId(), "Luxury hotel");
            DatabaseHandler.insertOrder(order);
            controller.setOrder(order);

            Stage stage = new Stage();
            stage.setTitle("onLuxeButtonClick");
            stage.setScene(new Scene(root, 608, 347));
            stage.show();
            ((Node) actionEvent.getSource()).getScene().getWindow().hide();
        } catch (IOException ignored) {

        }
    }

    public void onClassicButtonCkick(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("../fxml/ClassicApartment.fxml"));
            loader.load();
            ClassicApartmentController controller = loader.getController();
            Parent root = loader.getRoot();

            Order order = new Order(0, LoginedPerson.activePerson.getId(), "Classic");
            DatabaseHandler.insertOrder(order);
            controller.setOrder(order);

            Stage stage = new Stage();
            stage.setTitle("onClassicButtonCkick");
            stage.setScene(new Scene(root, 608, 347));
            stage.show();
            ((Node) actionEvent.getSource()).getScene().getWindow().hide();
        } catch (IOException ignored) {

        }
    }

    public void onDeleteAccountButtonClick(ActionEvent actionEvent) {
        DatabaseHandler.deleteClient(LoginedPerson.activePerson);

        Parent root = null;
        try {

            root = FXMLLoader.load(getClass().getResource("../fxml/LoginScreen.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Account deleted");
        alert.setHeaderText("Account deleted");
        alert.showAndWait();
        Scene scene = new Scene(root);
        Stage s = new Stage();
        s.setScene(scene);
        s.show();
        ((Node) actionEvent.getSource()).getScene().getWindow().hide();
    }

    public void onChangeAccountButtonClick(ActionEvent actionEvent) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("../fxml/ChangingAccount.fxml"));

            Stage stage = new Stage();
            stage.setTitle("Changing Window");
            stage.setScene(new Scene(root, 608, 347));
            stage.show();
            ((Node) actionEvent.getSource()).getScene().getWindow().hide();
        } catch (IOException ignored) {

        }
    }
}
