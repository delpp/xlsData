package xls.model;


import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

public class DataSetWithColumn<T> extends DataSet<T>{

    private int columnNumber;

    public DataSetWithColumn(
            String name,
            ChoiceBox<String> sheet,
            ChoiceBox<String> kolumnNumber,
            ChoiceBox<String> kolumna,
            int columnNumber,
            TextField textFieldNr,
            T textFieldDescription) {
        super(name, sheet, kolumnNumber, textFieldNr, textFieldDescription, 0, true);

        this.columnNumber = columnNumber;
        kolumna.getSelectionModel().select(columnNumber);
    }


    public int getColumnNumber() {
        return columnNumber;
    }

    public void setColumnNumber(int columnNumber) {
        this.columnNumber = columnNumber;
    }

}
