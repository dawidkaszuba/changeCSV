package pl.dawidkaszuba;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class RemoveByRegexController {

    private MainController mainController;

    @FXML
    private TextField inputPath;
    @FXML
    private TextField outputPath;
    @FXML
    private TextField columnNumber;
    @FXML
    private TextField regex;

    @FXML
    public void backMenu(){
        mainController.loadMainScreen();
    }

    @FXML
    private void handleBtnRemoveByRegex(){

        String inputPathFild = inputPath.getText();
        String outputPathField = outputPath.getText();
        String columnNumberFieled = columnNumber.getText();
        String regexField = regex.getText();


        CSVChanger.removeCharsByRegex(regexField,inputPathFild,outputPathField,Integer.parseInt(columnNumberFieled));
        mainController.loadMainScreen();

    }


    public void setMainController(MainController mainController) {
        this.mainController=mainController;
    }
}
