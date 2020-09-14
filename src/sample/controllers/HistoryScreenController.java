package sample.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import sample.DatabaseHandler;
import sample.LoginedPerson;
import sample.OrderHistoryLine;
import sample.hotel.Order;

import java.io.IOException;
import java.util.List;

public class HistoryScreenController {
    @FXML
    private TableView<OrderHistoryLine> tableViewHistory;

    @FXML
    private TableColumn<OrderHistoryLine, Integer> columnId;

    @FXML
    private TableColumn<OrderHistoryLine, String> columnApartmentName;

    @FXML
    private TableColumn<OrderHistoryLine, String> columnFirstName;

    @FXML
    private TableColumn<OrderHistoryLine, String> columnLastName;

    @FXML
    private TableColumn<OrderHistoryLine, String> columnUsername;

    public void prerun() {
        List<OrderHistoryLine> orderHistoryLines = DatabaseHandler.selectAllOrdersExtended();
        columnId.setCellValueFactory(new PropertyValueFactory<OrderHistoryLine, Integer>("id"));
        columnApartmentName.setCellValueFactory(new PropertyValueFactory<OrderHistoryLine, String>("apartmentname"));
        columnFirstName.setCellValueFactory(new PropertyValueFactory<OrderHistoryLine, String>("firstname"));
        columnLastName.setCellValueFactory(new PropertyValueFactory<OrderHistoryLine, String>("lastname"));
        columnUsername.setCellValueFactory(new PropertyValueFactory<OrderHistoryLine, String>("username"));

        tableViewHistory.getItems().setAll(orderHistoryLines);
    }

    public void onBackClicked(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("../fxml/LoginScreen.fxml"));
            loader.load();

            Stage stage = new Stage();
            stage.setTitle("onClassicButtonCkick");
            stage.setScene(new Scene(loader.getRoot(), 608, 347));
            stage.show();
            ((Node) actionEvent.getSource()).getScene().getWindow().hide();
        } catch (IOException ignored) {

        }
    }
}
