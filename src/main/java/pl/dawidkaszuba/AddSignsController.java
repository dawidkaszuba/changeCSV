package pl.dawidkaszuba;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class AddSignsController {

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
    private void handleBtnAddSigns(){

        String inputPathField = inputPath.getText();
        String outputPathField = outputPath.getText();
        String columnNumberFiled = columnNumber.getText();
        String signsField = signs.getText();
        String indexField = index.getText();

        CSVChanger.addSignsByStartedIndex(Integer.parseInt(indexField),
                inputPathField,outputPathField,
                Integer.parseInt(columnNumberFiled),signsField);
        mainController.loadMainScreen();
    }



    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }
}
