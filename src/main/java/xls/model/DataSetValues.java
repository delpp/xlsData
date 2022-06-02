package xls.model;


import javafx.scene.control.Label;
import javafx.scene.control.TextField;

//@SuppressWarnings("restriction")
public class DataSetValues{
    private String nameFor100g;
    private String nameForPortion;
    private String nameForRWS;
    private int rowNumber;
    private Label nameLabel;
    private TextField textFieldRowNumber;
    private TextField textFieldFor100g;
    private TextField textFieldForPortion;
    private TextField textFieldRWS;

    public DataSetValues (
            String nameFor100g,
            String nameForPortion,
            String nameForRWS,
            Label nameLabel,
            TextField textFieldRowNumber,
            TextField textFieldFor100g,
            TextField textFieldForPortion,
            TextField textFieldRWS) {
        this.nameFor100g = nameFor100g;
        this.nameForPortion = nameForPortion;
        this.nameForRWS = nameForRWS;
        this.nameLabel = nameLabel;
        this.textFieldRowNumber = textFieldRowNumber;
        this.textFieldFor100g = textFieldFor100g;
        this.textFieldForPortion = textFieldForPortion;
        this.textFieldRWS = textFieldRWS;
    }

    public DataSetValues (
            String nameFor100g,
            String nameForPortion,
            String nameForRWS,
            Label nameLabel,
            TextField textFieldRowNumber,
            TextField textFieldFor100g,
            TextField textFieldForPortion) {
        this.nameFor100g = nameFor100g;
        this.nameForPortion = nameForPortion;
        this.nameForRWS = nameForRWS;
        this.nameLabel = nameLabel;
        this.textFieldRowNumber = textFieldRowNumber;
        this.textFieldFor100g = textFieldFor100g;
        this.textFieldForPortion = textFieldForPortion;
        textFieldRWS = new TextField("-");
    }

    public void setDisableLabelName(boolean disable) {
        nameLabel.setDisable(disable);
    }

    public void setDisableTextFieldRowNumber(boolean disable) {
        textFieldRowNumber.setDisable(disable);
    }

    public int getRowNumber() {
        if ((!textFieldRowNumber.getText().equals("")))
            return Integer.parseInt(textFieldRowNumber.getText());
        else return 0;
        //return rowNumber;
    }

    public void setRowNumber() {
        if (!textFieldRowNumber.getText().equals(""))
            rowNumber = Integer.parseInt(textFieldRowNumber.getText());
        else rowNumber = 0;
    }


    public void setDisableTextFieldFor100g(boolean disable) {
        textFieldFor100g.setDisable(disable);
    }
    public void writeToTextFieldFieldFor100g(String description) {
        textFieldFor100g.setText(description);
    }
    public String readTextFieldFor100g() {
        return textFieldFor100g.getText();
    }


    public void setDisableTextFieldForPortion(boolean disable) {
        textFieldForPortion.setDisable(disable);
    }
    public void writeToTextFieldForPortion(String description) {
        textFieldForPortion.setText(description);
    }
    public String readTextFieldForPortion() {
        return textFieldForPortion.getText();
    }


    public void setDisableTextFieldRWS(boolean disable) {
        textFieldRWS.setDisable(disable);
    }
    public void writeToTextFieldRWS(String description) {
        textFieldRWS.setText(description);
    }
    public String readTextFieldRWS() {
        return textFieldRWS.getText();
    }


    public TextField getTextFieldDescription (String text) {
        if (text.equals("kolumnaOdzywcze100g")) return textFieldFor100g;
        if (text.equals("kolumnaOdzywczePortion")) return textFieldForPortion;
        if (text.equals("kolumnaOdzywczeRWS")) return textFieldRWS;
        return new TextField("-");
    }

    public void writeToTextField(String description, TextField textFieldDescription) {
        textFieldDescription.setText(description);
    }

    public String readTextField(String text) {
        if (text.equals("kolumnaOdzywcze100g")) return textFieldFor100g.getText();
        if (text.equals("kolumnaOdzywczePortion")) return textFieldForPortion.getText();
        if (text.equals("kolumnaOdzywczeRWS")) return textFieldRWS.getText();
        return "-";
    }

    public String nameFor100g() {
        return nameFor100g;
    }
    public String nameForPortion() {
        return nameForPortion;
    }
    public String nameForRWS() {
        return nameForRWS;
    }
}

