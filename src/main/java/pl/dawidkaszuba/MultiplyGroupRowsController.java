package pl.dawidkaszuba;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class MultiplyGroupRowsController {

    private MainController mainController;

    @FXML
    private TextField inputPath;
    @FXML
    private TextField outputPath;
    @FXML
    private TextField repetitionsNumber;
    @FXML
    private TextField numberOfAbandonedRows;


    @FXML
    public void backMenu(){
        mainController.loadMainScreen();
    }

    @FXML
    private void handleBtnMultiplyRows(){

        String inputPathField = inputPath.getText();
        String outputPathField = outputPath.getText();
        int numberOfAbandonedRowsField = Integer.parseInt(numberOfAbandonedRows.getText());
        int repetitionsNumberField = Integer.parseInt(repetitionsNumber.getText());

        CSVChanger.multiplyGoupRows(outputPathField, inputPathField,repetitionsNumberField,numberOfAbandonedRowsField);
        mainController.loadMainScreen();
    }



    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }
}
