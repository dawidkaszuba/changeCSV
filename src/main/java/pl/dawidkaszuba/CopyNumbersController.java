package pl.dawidkaszuba;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class CopyNumbers {



    private MainController mainController;

    @FXML
    private TextField inputPath;
    @FXML
    private TextField outputPath;
    @FXML
    private TextField columnNumber;


    @FXML
    public void backMenu(){
        mainController.loadMainScreen();
    }

    @FXML
    private void handleBtnCopyNumbers(){

        String inputPathFild = inputPath.getText();
        String outputPathField = outputPath.getText();
        String columnNumberFiled = columnNumber.getText();

        CSVChanger.removeNumbers(inputPathFild,outputPathField,Integer.parseInt(columnNumberFiled));
        mainController.loadMainScreen();
    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }
}
