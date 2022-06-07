package xls.model;


import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class DataSet<T>{
    private String name;
    private ChoiceBox<String> sheet;
    private ChoiceBox<String> columnNumber;
    private TextField rowNumber;
    private T description;
    private int shiftColumn;

    public DataSet() {

    }

    @SuppressWarnings("unchecked")
    public DataSet(
            String name,
            ChoiceBox<String> sheet,
            ChoiceBox<String> columnNumber,
            TextField rowNumber,
            T description,
            int shiftColumn,
            boolean notVisible) {
        this.name = name;
        this.sheet = sheet;
        this.columnNumber = columnNumber;
        this.rowNumber = rowNumber;
        this.description = description;
        this.shiftColumn = shiftColumn;

        columnNumber.setDisable(notVisible);
        rowNumber.setDisable(notVisible);
        if (description instanceof TextArea) ((TextArea) description).setDisable(notVisible);
        if (description instanceof ChoiceBox) ((ChoiceBox<String>) description).setDisable(notVisible);
    }


    public int getSheetNumber() {
        return sheet.getSelectionModel().getSelectedIndex();
    }

    public boolean isDisableTextFieldNr() {
        return rowNumber.isDisable();
    }
    public void setDisableTextFieldNr(boolean disable) {
        rowNumber.setDisable(disable);
    }


    public void setDisableColumnNumber(boolean disable) {
        columnNumber.setDisable(disable);
    }


    public void setDisableFieldDescription(boolean disable) {
        if (description instanceof TextArea) ((TextArea) description).setDisable(disable);
        if (description instanceof ChoiceBox) ((ChoiceBox<String>) description).setDisable(disable);
    }

    public String readDescription() {
        if (description instanceof TextArea) return ((TextArea) description).getText();
        if (description instanceof ChoiceBox) return Integer.toString(((ChoiceBox<String>) description).getSelectionModel().getSelectedIndex()+1);

        return "";
    }

    @SuppressWarnings("unchecked")
    public String readDescriptionToSaveData() {
        if (description instanceof TextArea) return ((TextArea) description).getText();
        if (description instanceof ChoiceBox) return ((ChoiceBox<String>) description).getValue();

        return "";
    }


    public int getRowNumber() {
        if ((!rowNumber.getText().equals("")))
            return Integer.parseInt(rowNumber.getText());
        else return 0;
    }

    public int getColumnNumber() {
        return columnNumber.getSelectionModel().getSelectedIndex() + shiftColumn;
    }

    public void setColumnNumber(int numberOfColumn){
        columnNumber.getSelectionModel().select(numberOfColumn);
    }

    public void setColumnNumberIncludeShiftColumn(int numberOfColumn){
        columnNumber.getSelectionModel().select(numberOfColumn - shiftColumn);
    }


    @SuppressWarnings("unchecked")
    public void writeDesctription(String descriptionText) {
        System.out.println("descriptionText dla " + name + ": " + descriptionText);
        if (description instanceof TextArea) ((TextArea) description).setText(descriptionText);
        if (description instanceof ChoiceBox) {
            try {
                ((ChoiceBox<String>) description).getSelectionModel().select(Integer.parseInt(descriptionText)-1);
            }
            catch (Exception ex) {

            }
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "DataSet [name= " + name
                + ", sheetNumber= " + sheet.getSelectionModel().getSelectedIndex()
                + ", columnNumber= " + (columnNumber.getSelectionModel().getSelectedIndex() + shiftColumn)
                + ", rowNumber= " + Integer.parseInt(rowNumber.getText())
                + ", description= " + description
                + ", shiftColumn= " + shiftColumn + "]";
    }
}
