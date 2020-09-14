package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/sample/fxml/LoginScreen.fxml"));
        primaryStage.setTitle("Let's choose your hotel!");
        primaryStage.setScene(new Scene(root, 608, 347));
        primaryStage.show();
    }

    @Override
    public void stop() throws Exception {
        DatabaseHandler.close();
        super.stop();
    }


    public static void main(String[] args) {
        DatabaseHandler.connect();
        launch(args);
    }
}
