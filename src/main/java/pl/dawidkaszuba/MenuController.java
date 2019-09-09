package pl.dawidkaszuba;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class MenuController {

    private MainController mainController;


    @FXML
    public void removeNumbers(){
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/removeNumbers.fxml"));
        Pane pane = null;
        try {
            pane = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        RemoveNumbersController removeNumbersController = loader.getController();
        removeNumbersController.setMainController(mainController);
        mainController.setScreen(pane);


    }


    @FXML
    public void removeSignsByRegex(){
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/removeByRegex.fxml"));
        Pane pane = null;
        try {
            pane = loader.load();
        } catch(IOException e) {
            e.printStackTrace();
        }

        RemoveByRegexController removeByRegexController = loader.getController();
        removeByRegexController.setMainController(mainController);
        mainController.setScreen(pane);

    }

    @FXML
    public void addSigns(){

    }

    @FXML
    public void exit(){
        Platform.exit();
    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }
}
