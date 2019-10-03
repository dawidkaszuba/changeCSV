package pl.dawidkaszuba;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class MultiplyRowsController {

    private MainController mainController;

    @FXML
    private TextField inputPath;
    @FXML
    private TextField outputPath;
    @FXML
    private TextField columnNumber;
    @FXML
    private TextField signs;
    @FXML
    private TextField index;


    @FXML
    public void backMenu(){
        mainController.loadMainScreen();
    }

    @FXML
    private void handleBtnMultiplyRows(){

        String inputPathField = inputPath.getText();
        String outputPathField = outputPath.getText();

        CSVChanger.multiply(inputPathField,outputPathField);
        mainController.loadMainScreen();
    }



    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }
}
