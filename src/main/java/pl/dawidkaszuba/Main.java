package pl.dawidkaszuba;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {

    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/MainScreen.fxml"));
        StackPane stackPane = loader.load();
        Scene scene = new Scene(stackPane,400,400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Change CSV");
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
