package sample.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import sample.apartments.LuxeApartment;
import sample.hotel.Order;

import java.io.IOException;

public class LuxeApartmentController {
    public Label labelYourOrder;

    public void okluxeButtonClick(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../fxml/LoginScreen.fxml"));

        Stage stage = new Stage();
        stage.setTitle("LoginScreen");
        stage.setScene(new Scene(root, 608, 347));
        stage.show();
        ((Node) actionEvent.getSource()).getScene().getWindow().hide();
    }

    private Order luxeOrder;

    public void setOrder(Order order) {
        luxeOrder = order;
        LuxeApartment luxe = new LuxeApartment(1000, 17, 3, 6);
        labelYourOrder.setText(String.format("Your order: " +
                "Payment: " + luxe.calc() + "$\n" +
                "Bar Size: " + luxe.getBarSize() + "pc.\n" +
                "Number of rooms: " + luxe.getNumberOfRooms() + "pc.\n" +
                "Number of beds: " + luxe.getNumberOfBeds() + "pc."));
    }
}
