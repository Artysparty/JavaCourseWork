package sample.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import sample.apartments.ClassicApartment;
import sample.hotel.Order;

import java.io.IOException;

public class ClassicApartmentController {
    public Label labelYourOrder;
    public Label LabelOrderInfo;

    public void onOkClassicApartmentClick(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../fxml/LoginScreen.fxml"));

        Stage stage = new Stage();
        stage.setTitle("Login Screen");
        stage.setScene(new Scene(root, 608, 347));
        stage.show();
        ((Node) actionEvent.getSource()).getScene().getWindow().hide();
    }

    public void showClassicInfo(ClassicApartment classicApartment) {
        labelYourOrder.setText(
                String.format("Variety: %s\n" +
                        "Bar size: %d\n" +
                        "Number of beds: %d\n" +
                        "Price: %d$\n", classicApartment.getBarSize(), classicApartment.getNumberOfBeds(), classicApartment.calc()));
    }

    Order classicOrder;

    public void setOrder(Order order) {
        classicOrder = order;
        ClassicApartment classic = new ClassicApartment(1000, 4, 1, 2);
        labelYourOrder.setText(String.format("Your order: " +
                "Payment: " + classic.calc() + "$\n" +
                "Bar Size: " + classic.getBarSize() + "pc.\n" +
                "Number of rooms: " + classic.getNumberOfRooms() + "pc.\n" +
                "Number of beds: " + classic.getNumberOfBeds() + "pc."));
    }
}
