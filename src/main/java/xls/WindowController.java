package xls;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import xls.model.*;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SuppressWarnings("restriction")
public class WindowController<T> {
    @FXML private TextField nazwaPliku;

    @FXML private Label zakladkaTekstyLabel;
    @FXML private ChoiceBox<String> zakladkaTeksty;

    @FXML private Label zakladkaOdzywczeLabel;
    @FXML private Label kolumna100gOdzywczeLabel;
    @FXML private Label kolumnaPortionOdzywczeLabel;
    @FXML private Label kolumnaRWSOdzywczeLabel;

    @FXML private Label naglowekWartosciOdzywczeLabel;
    @FXML private Label naglowekWierszOdzywczeLabel;
    @FXML private Label naglowek100gOdzywczeLabel;
    @FXML private Label naglowekPortionOdzywczeLabel;
    @FXML private Label naglowekRWSOdzywczeLabel;

    @FXML private ChoiceBox<String> zakladkaWartosciOdzywcze;
    @FXML private ChoiceBox<String> kolumnaOdzywcze100g;
    @FXML private ChoiceBox<String> kolumnaOdzywczePortion;
    @FXML private ChoiceBox<String> kolumnaOdzywczeRWS;

    @FXML private ChoiceBox<String> kolumnaNazwaGlowna;
    @FXML private TextField nazwaGlownaNr;
    @FXML private T nazwaGlownaDescription;


    @FXML private ChoiceBox<String> kolumnaWyrozniki;
    @FXML private TextField wyroznikNr;
    @FXML private T wyroznikDescription1;
    @FXML private T wyroznikDescription2;
    @FXML private T wyroznikDescription3;
    @FXML private T wyroznikDescription4;


    @FXML private ChoiceBox<String> kolumnaPiktogramyFejs;
    @FXML private TextField piktogramyFejsNr;
    @FXML private T piktogramFejsDescription1;
    @FXML private T piktogramFejsDescription2;
    @FXML private T piktogramFejsDescription3;


    @FXML private ChoiceBox<String> kolumnaNazwaOpisowa;
    @FXML private TextField nazwaOpisowaNr;
    @FXML private T nazwaOpisowaDescription;


    @FXML private ChoiceBox<String> kolumnaSkladniki;
    @FXML private TextField skladnikiNr;
    @FXML private T skladnikiDescription;

    @FXML private ChoiceBox<String> kolumnaDataINrPartii;
    @FXML private TextField dataINrPartiiRowNr;
    @FXML private T dataINrPartiiDescription1;
    @FXML private T dataINrPartiiDescription2;


    @FXML private ChoiceBox<String> kolumnaSposobPrzechowywania;
    @FXML private TextField sposobPrzechowywaniaRowNr;
    @FXML private T sposobPrzechowywaniaDescription;

    @FXML private ChoiceBox<String> kolumnaSposobPrzygotowania;
    @FXML private TextField sposobPrzygotowaniaRowNr;
    @FXML private T sposobPrzygotowaniaDescription;

    @FXML private ChoiceBox<String> kolumnaProducent;
    @FXML private TextField producentNr;
    @FXML private T producentDescription;


    @FXML private ChoiceBox<String> kolumnaGramatura;
    @FXML private TextField gramaturaNr;
    @FXML private T gramaturaDescription1;
    @FXML private T gramaturaDescription2;
    @FXML private T gramaturaDescription3;


    @FXML private ChoiceBox<String> kolumnaTypOpakowania;
    @FXML private TextField typOpakowaniaNr;
    @FXML private T typOpakowaniaDescription1;
    @FXML private T typOpakowaniaDescription2;
    @FXML private T typOpakowaniaDescription3;
    @FXML private T typOpakowaniaDescription4;


    @FXML private ChoiceBox<String> kolumnaEAN;
    @FXML private TextField EANNr;
    @FXML private T EANDescription;


    @FXML private ChoiceBox<String> kolumnaLiczbyPorcji;
    @FXML private Label kolumnaLiczbyPorcjiLabel;
    @FXML private Label liczbaPorcjiWierszLabel;
    @FXML private TextField liczbaPorcjiNr;
    @FXML private Label liczbaPorcjiLabel;
    @FXML private T liczbaPorcjiDescription;

    @FXML private Label wielkoscPorcjiWierszLabel;
    @FXML private TextField wielkoscPorcjiNr;
    @FXML private Label wielkoscPorcjiLabel;
    @FXML private T wielkoscPorcjiDescription;

    @FXML private ChoiceBox<String> kolumnaWartosc;
    @FXML private TextField wartoscNr;
    @FXML private T wartoscDescription;


    @FXML private Label energiakJNameLabel;
    @FXML private TextField energiakJNr;
    @FXML private TextField energiakJ100g;
    @FXML private TextField energiakJPortion;
    @FXML private TextField energiakJRWS;

    @FXML private Label energiakcalNameLabel;
    @FXML private TextField energiakcalNr;
    @FXML private TextField energiakcal100g;
    @FXML private TextField energiakcalPortion;
    @FXML private TextField energiakcalRWS;

    @FXML private Label tluszczeNameLabel;
    @FXML private TextField tluszczeNr;
    @FXML private TextField tluszcze100g;
    @FXML private TextField tluszczePortion;
    @FXML private TextField tluszczeRWS;

    @FXML private Label kwasyNameLabel;
    @FXML private TextField kwasyNr;
    @FXML private TextField kwasy100g;
    @FXML private TextField kwasyPortion;
    @FXML private TextField kwasyRWS;

    @FXML private Label weglowodanyNameLabel;
    @FXML private TextField weglowodanyNr;
    @FXML private TextField weglowodany100g;
    @FXML private TextField weglowodanyPortion;
    @FXML private TextField weglowodanyRWS;

    @FXML private Label cukryNameLabel;
    @FXML private TextField cukryNr;
    @FXML private TextField cukry100g;
    @FXML private TextField cukryPortion;
    @FXML private TextField cukryRWS;

    @FXML private Label blonnikNameLabel;
    @FXML private TextField blonnikNr;
    @FXML private TextField blonnik100g;
    @FXML private TextField blonnikPortion;
    @FXML private TextField blonnikRWS;

    @FXML private Label bialkoNameLabel;
    @FXML private TextField bialkoNr;
    @FXML private TextField bialko100g;
    @FXML private TextField bialkoPortion;
    @FXML private TextField bialkoRWS;

    @FXML private Label solNameLabel;
    @FXML private TextField solNr;
    @FXML private TextField sol100g;
    @FXML private TextField solPortion;
    @FXML private TextField solRWS;

    @FXML private Button saveDataFromTab1Btn;
    @FXML private Button loadData;
    @FXML private Button saveDataFromTab2Btn;
    @FXML private Button savePresets;
    @FXML private Button loadPresets;

    @FXML private Tooltip pokazCalaSciezke;

    @FXML private Stage stage;

    private String path;
    private List<DataSet<T>> listDataSet;
    private List<DataSetValues> listDataSetOdzywcze;
    private List<DataSetWithColumn<T>> listDataPortion;

    private List<ChoiceBox<String>> listColumns;

    private boolean fileSet;
    private boolean dataOdzywczeLoaded;

    @SuppressWarnings("unchecked")
    @FXML private void initialize(){
        int beginColumnNumber = 1;
        path = "";
        fileSet = false;
        dataOdzywczeLoaded = false;

        ObservableList<String> columnsName =
                FXCollections.observableArrayList(
                        "A",
                        "B",
                        "C",
                        "D",
                        "E",
                        "F",
                        "G",
                        "H",
                        "I",
                        "J",
                        "K",
                        "L",
                        "M",
                        "N",
                        "O"
                );

        ObservableList<String> columnsGramatura =
                FXCollections.observableArrayList(
                        "Masa - nie dotyczy",
                        "Masa netto:",
                        "Objętość netto:",
                        "Masa netto: (i) Masa netto po odcieku:"
                );

        listColumns = new ArrayList<ChoiceBox<String>>();
        listColumns.add(kolumnaNazwaGlowna);
        listColumns.add(kolumnaWyrozniki);
        listColumns.add(kolumnaPiktogramyFejs);
        listColumns.add(kolumnaNazwaOpisowa);
        listColumns.add(kolumnaSkladniki);
        listColumns.add(kolumnaDataINrPartii);
        listColumns.add(kolumnaSposobPrzechowywania);
        listColumns.add(kolumnaSposobPrzygotowania);
        listColumns.add(kolumnaProducent);
        listColumns.add(kolumnaGramatura);
        listColumns.add(kolumnaTypOpakowania);
        listColumns.add(kolumnaEAN);


        listColumns.stream().forEach(x -> {
            x.getItems().addAll(columnsName);
            x.getSelectionModel().select(beginColumnNumber);
        });


        ((ChoiceBox<String>) gramaturaDescription1).getItems().addAll(columnsGramatura);
        ((ChoiceBox<String>) gramaturaDescription1).getSelectionModel().select(-1);

        kolumnaSposobPrzygotowania.getSelectionModel().select(3);
        kolumnaGramatura.getSelectionModel().select(0);

        kolumnaLiczbyPorcji.getItems().addAll(columnsName);
        kolumnaLiczbyPorcji.getSelectionModel().select(1);

        kolumnaWartosc.getItems().addAll(columnsName);
        kolumnaWartosc.getSelectionModel().select(0);


        kolumnaOdzywcze100g.getItems().addAll(columnsName);
        kolumnaOdzywcze100g.getSelectionModel().select(1);
        kolumnaOdzywczePortion.getItems().addAll(columnsName);
        kolumnaOdzywczePortion.getSelectionModel().select(2);
        kolumnaOdzywczeRWS.getItems().addAll(columnsName);
        kolumnaOdzywczeRWS.getSelectionModel().select(3);

        listDataSet = new ArrayList<DataSet<T>>();
        listDataSet.add(new DataSet<T>("NAZWA PRODUKTU FEJS", zakladkaTeksty, kolumnaNazwaGlowna, nazwaGlownaNr, nazwaGlownaDescription, 0, false));
        listDataSet.add(new DataSet<T>("WYROZNIK1", zakladkaTeksty, kolumnaWyrozniki, wyroznikNr, wyroznikDescription1, 0, false));
        listDataSet.add(new DataSet<T>("WYROZNIK2", zakladkaTeksty, kolumnaWyrozniki, wyroznikNr, wyroznikDescription2, 1, false));
        listDataSet.add(new DataSet<T>("WYROZNIK3", zakladkaTeksty, kolumnaWyrozniki, wyroznikNr, wyroznikDescription3, 2, false));
        listDataSet.add(new DataSet<T>("WYROZNIK4", zakladkaTeksty, kolumnaWyrozniki, wyroznikNr, wyroznikDescription4, 3, false));
        listDataSet.add(new DataSet<T>("PIKTOGRAM1", zakladkaTeksty, kolumnaPiktogramyFejs, piktogramyFejsNr, piktogramFejsDescription1, 0, false));
        listDataSet.add(new DataSet<T>("PIKTOGRAM2", zakladkaTeksty, kolumnaPiktogramyFejs, piktogramyFejsNr, piktogramFejsDescription2, 1, false));
        listDataSet.add(new DataSet<T>("PIKTOGRAM3", zakladkaTeksty, kolumnaPiktogramyFejs, piktogramyFejsNr, piktogramFejsDescription3, 2, false));
        listDataSet.add(new DataSet<T>("NAZWA OPISOWA", zakladkaTeksty, kolumnaNazwaOpisowa, nazwaOpisowaNr, nazwaOpisowaDescription, 0, false));
        listDataSet.add(new DataSet<T>("SKLADNIKI", zakladkaTeksty, kolumnaSkladniki, skladnikiNr, skladnikiDescription, 0, false));
        listDataSet.add(new DataSet<T>("DATA1", zakladkaTeksty, kolumnaDataINrPartii, dataINrPartiiRowNr, dataINrPartiiDescription1, 0, false));
        listDataSet.add(new DataSet<T>("DATA2", zakladkaTeksty, kolumnaDataINrPartii, dataINrPartiiRowNr, dataINrPartiiDescription2, 2, false));
        listDataSet.add(new DataSet<T>("SPOSOBPRZECHOWYWANIA", zakladkaTeksty, kolumnaSposobPrzechowywania, sposobPrzechowywaniaRowNr, sposobPrzechowywaniaDescription, 0, false));
        listDataSet.add(new DataSet<T>("SPOSOBPRZYGOTOWANIA", zakladkaTeksty, kolumnaSposobPrzygotowania, sposobPrzygotowaniaRowNr, sposobPrzygotowaniaDescription, 0, false));
        listDataSet.add(new DataSet<T>("PRODUCENT", zakladkaTeksty, kolumnaProducent, producentNr, producentDescription, 0, false));
        listDataSet.add(new DataSet<T>("GRAMATURA1", zakladkaTeksty, kolumnaGramatura, gramaturaNr, gramaturaDescription1, 0, false));
        listDataSet.add(new DataSet<T>("GRAMATURA2", zakladkaTeksty, kolumnaGramatura, gramaturaNr, gramaturaDescription2, 1, false));
        listDataSet.add(new DataSet<T>("GRAMATURA3", zakladkaTeksty, kolumnaGramatura, gramaturaNr, gramaturaDescription3, 4, false));
        listDataSet.add(new DataSet<T>("PIKTOGRAMTYPOPAKOWANIA1", zakladkaTeksty, kolumnaTypOpakowania, typOpakowaniaNr, typOpakowaniaDescription1, 0, false));
        listDataSet.add(new DataSet<T>("PIKTOGRAMTYPOPAKOWANIA2", zakladkaTeksty, kolumnaTypOpakowania, typOpakowaniaNr, typOpakowaniaDescription2, 1, false));
        listDataSet.add(new DataSet<T>("PIKTOGRAMTYPOPAKOWANIA3", zakladkaTeksty, kolumnaTypOpakowania, typOpakowaniaNr, typOpakowaniaDescription3, 2, false));
        listDataSet.add(new DataSet<T>("PIKTOGRAMTYPOPAKOWANIA4", zakladkaTeksty, kolumnaTypOpakowania, typOpakowaniaNr, typOpakowaniaDescription4, 3, false));
        listDataSet.add(new DataSet<T>("EAN", zakladkaTeksty, kolumnaEAN, EANNr, EANDescription, 0, false));

        listDataSet.add(new DataSet<T>("LICZBA_PORCJI", zakladkaWartosciOdzywcze, kolumnaLiczbyPorcji, liczbaPorcjiNr, liczbaPorcjiDescription, 0, false));
        listDataSet.add(new DataSet<T>("WIELKOSC_PORCJI", zakladkaWartosciOdzywcze, kolumnaLiczbyPorcji, wielkoscPorcjiNr, wielkoscPorcjiDescription, 0, false));
        listDataSet.add(new DataSet<T>("WARTOSC_ODZYWCZA", zakladkaWartosciOdzywcze, kolumnaWartosc, wartoscNr, wartoscDescription, 0, false));


        listDataPortion = new ArrayList<DataSetWithColumn<T>>();

        listDataSetOdzywcze = new ArrayList<DataSetValues>();
        listDataSetOdzywcze.add(new DataSetValues("E1", "PE1", "R1", energiakJNameLabel, energiakJNr, energiakJ100g, energiakJPortion, energiakJRWS));
        listDataSetOdzywcze.add(new DataSetValues("E2", "PE2", "R2", energiakcalNameLabel, energiakcalNr, energiakcal100g, energiakcalPortion));
        listDataSetOdzywcze.add(new DataSetValues("T1", "PT1", "R3", tluszczeNameLabel, tluszczeNr, tluszcze100g, tluszczePortion, tluszczeRWS));
        listDataSetOdzywcze.add(new DataSetValues("T2", "PT2", "R4", kwasyNameLabel, kwasyNr, kwasy100g, kwasyPortion, kwasyRWS));
        listDataSetOdzywcze.add(new DataSetValues("W", "PW", "R5", weglowodanyNameLabel, weglowodanyNr, weglowodany100g, weglowodanyPortion, weglowodanyRWS));
        listDataSetOdzywcze.add(new DataSetValues("C", "PC", "R6", cukryNameLabel, cukryNr, cukry100g, cukryPortion, cukryRWS));
        listDataSetOdzywcze.add(new DataSetValues("BL", "PBL", "R7", blonnikNameLabel, blonnikNr, blonnik100g, blonnikPortion, blonnikRWS));
        listDataSetOdzywcze.add(new DataSetValues("BI", "PBI", "R8", bialkoNameLabel, bialkoNr, bialko100g, bialkoPortion, bialkoRWS));
        listDataSetOdzywcze.add(new DataSetValues("S", "PS", "R9", solNameLabel, solNr, sol100g, solPortion, solRWS));


        for (DataSetValues dataSet : listDataSetOdzywcze) {

            dataSet.setDisableLabelName(false);
            dataSet.setDisableTextFieldRowNumber(false);
            dataSet.setDisableTextFieldFor100g(false);
            dataSet.setDisableTextFieldForPortion(false);
            dataSet.setDisableTextFieldRWS(false);
        }
    }

    private ObservableList<String> loadDataColumnFromExcel(String textToSearch, int numberRowsToLoad, int shiftColumnToSearch) throws Exception {
        int sheetNumber = 0;
        int maxColumnNumberToSearch = 15;	// 15 - P
        int maxRowNumberToSearch = 50;

        int startColumnNumber = -1;
        int startRowNumber = -1;

        boolean found = false;

        for (int columnNumber = 0; columnNumber <= maxColumnNumberToSearch; columnNumber++) {
            for (int rowNumber = 0; rowNumber <= maxRowNumberToSearch; rowNumber++) {
                if (XLSFileTools.readCell(path, sheetNumber, rowNumber, columnNumber, false).equals(textToSearch)) {
                    startColumnNumber = columnNumber;
                    startRowNumber = rowNumber;
                    found = true;
                }
                if (found) break;
            }
            if (found) break;
        }

        List<String> list = new ArrayList<String>();
        if ((startColumnNumber > -1) && (startRowNumber > -1))
            for (int rowNumber = startRowNumber + 1; rowNumber <= startRowNumber + numberRowsToLoad; rowNumber++) {
                list.add(XLSFileTools.readCell(path, sheetNumber, rowNumber, startColumnNumber + shiftColumnToSearch, false));
            }


        System.out.println("lista: " + list);
        return FXCollections.observableArrayList(list);
    }

    @SuppressWarnings("unchecked")
    @FXML private void setFile() throws Exception{

        final FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialDirectory(new File(System.getProperty("user.home"), "/Desktop"));
        fileChooser.getExtensionFilters().add(new ExtensionFilter("XLS Files", "*.xls", "*.XLS"));

        final File file = fileChooser.showOpenDialog(stage);

        if (file != null)
            try{
                path = file.getAbsolutePath();

                zakladkaTeksty.getItems().clear();
                zakladkaWartosciOdzywcze.getItems().clear();
                loadSheetsNames(path);

                pokazCalaSciezke.setText(path);

                nazwaPliku.setText(path);

                if (piktogramFejsDescription1 instanceof ChoiceBox) {
                    ((ChoiceBox<String>) piktogramFejsDescription1).getItems().addAll(loadDataColumnFromExcel("NUTRISCORE", 6, 0));
                    ((ChoiceBox<String>) piktogramFejsDescription1).getSelectionModel().select(-1);
                }


                ObservableList<String> listaPiktogramyFejs = loadDataColumnFromExcel("PIKTOGRAMY", 7, 0);
                if (piktogramFejsDescription2 instanceof ChoiceBox) {
                    ((ChoiceBox<String>) piktogramFejsDescription2).getItems().addAll(listaPiktogramyFejs);
                    ((ChoiceBox<String>) piktogramFejsDescription2).getSelectionModel().select(-1);
                }
                if (piktogramFejsDescription3 instanceof ChoiceBox) {
                    ((ChoiceBox<String>) piktogramFejsDescription3).getItems().addAll(listaPiktogramyFejs);
                    ((ChoiceBox<String>) piktogramFejsDescription3).getSelectionModel().select(-1);
                }


                if (dataINrPartiiDescription1 instanceof ChoiceBox) {
                    ((ChoiceBox<String>) dataINrPartiiDescription1).getItems().addAll(loadDataColumnFromExcel("Termin przydatności", 4, 0));
                    ((ChoiceBox<String>) dataINrPartiiDescription1).getSelectionModel().select(-1);
                }


                ObservableList<String> listaTypOpakowaniaFejs = loadDataColumnFromExcel("MATERIAŁ", 33, 1);
                if (typOpakowaniaDescription1 instanceof ChoiceBox) {
                    ((ChoiceBox<String>) typOpakowaniaDescription1).getItems().addAll(listaTypOpakowaniaFejs);
                    ((ChoiceBox<String>) typOpakowaniaDescription1).getSelectionModel().select(-1);
                }
                if (typOpakowaniaDescription2 instanceof ChoiceBox) {
                    ((ChoiceBox<String>) typOpakowaniaDescription2).getItems().addAll(listaTypOpakowaniaFejs);
                    ((ChoiceBox<String>) typOpakowaniaDescription2).getSelectionModel().select(-1);
                }
                if (typOpakowaniaDescription3 instanceof ChoiceBox) {
                    ((ChoiceBox<String>) typOpakowaniaDescription3).getItems().addAll(listaTypOpakowaniaFejs);
                    ((ChoiceBox<String>) typOpakowaniaDescription3).getSelectionModel().select(-1);
                }
                if (typOpakowaniaDescription4 instanceof ChoiceBox) {
                    ((ChoiceBox<String>) typOpakowaniaDescription4).getItems().addAll(listaTypOpakowaniaFejs);
                    ((ChoiceBox<String>) typOpakowaniaDescription4).getSelectionModel().select(-1);
                }

                fileSet = true;
                dataOdzywczeLoaded = true;
                loadAllData();

            }
            catch (Exception ex){
                ex.printStackTrace();
            }
    }

    @FXML private void loadAllData() throws Exception {
        if (dataOdzywczeLoaded) {
            loadTextsData();
            loadNutritionalData();
        }
    }

    private void loadTextsData() throws Exception {

        int sheetNumber;
        int columnNumber;
        int rowNumber;
        String daneProduktu;

        for (DataSet<T> dataSet : listDataSet) {

            rowNumber = dataSet.getRowNumber();
            sheetNumber = dataSet.getSheetNumber();

            if (rowNumber < 1) daneProduktu = "-";
            else {
                rowNumber = rowNumber - 1;
                columnNumber = dataSet.getColumnNumber();

                daneProduktu = XLSFileTools.readCell(path, sheetNumber, rowNumber, columnNumber, true);

                if (dataSet.getName().contains("PIKTOGRAMTYPOPAKOWANIA")) {
                    if (daneProduktu.startsWith("<b>")) {
                        daneProduktu = daneProduktu.substring(3, daneProduktu.length()-4);
                    }
                }

                if (dataSet.getName().equals("WIELKOSC_PORCJI")) {
                    daneProduktu = daneProduktu + " " + XLSFileTools.readCell(path, sheetNumber, rowNumber, columnNumber + 2, false);

                    String temp = XLSFileTools.readCell(path, sheetNumber, rowNumber + 1, columnNumber, true);
                    if (!temp.isEmpty()) daneProduktu = daneProduktu + " (" + temp + ")";
                }
            }


            System.out.println("daneProduktu: " + daneProduktu);
            dataSet.writeDesctription(daneProduktu);
        }

        System.out.println("--------------------");
        for (DataSet<T> dataSet : listDataSet) System.out.println("dataSet: " + dataSet.toString());
        System.out.println("--------------------");

        saveDataFromTab1Btn.setDisable(false);
    }


    private void loadNutritionalData() throws Exception {

        int sheetNumber = zakladkaWartosciOdzywcze.getSelectionModel().getSelectedIndex();
        final int columnNumber = kolumnaLiczbyPorcji.getSelectionModel().getSelectedIndex();
        int rowNumber;

        listDataPortion.stream().forEach(x -> {
            x.setColumnNumber(columnNumber);
        });

        String daneProduktu;
        for (DataSetWithColumn<T> dataSet : listDataPortion) {


            daneProduktu = dataSet.readDescription();

            dataSet.writeDesctription(daneProduktu);
        }

        listDataSetOdzywcze.stream().forEach(x -> x.setRowNumber());


        System.out.println("Sheet number: " + sheetNumber);

        ArrayList<ChoiceBox<String>> columns = new ArrayList<ChoiceBox<String>>();

        columns.add(kolumnaOdzywcze100g);
        columns.add(kolumnaOdzywczePortion);
        columns.add(kolumnaOdzywczeRWS);


        for (ChoiceBox<String> choosedColumn : columns) {
            int columnNumberOdzywcze = choosedColumn.getSelectionModel().getSelectedIndex();
            System.out.println("kolumna number: " + columnNumberOdzywcze);

            for (DataSetValues dataSetValues : listDataSetOdzywcze) {
                if (dataSetValues.getRowNumber() < 1) daneProduktu = "-";
                else {
                    rowNumber = dataSetValues.getRowNumber()-1;
                    daneProduktu = XLSFileTools.readCell(path, sheetNumber, rowNumber, columnNumberOdzywcze, true);
                    daneProduktu = daneProduktu.replace(".", ",");

                }
                dataSetValues.writeToTextField(daneProduktu, dataSetValues.getTextFieldDescription(choosedColumn.getId()));
            }
        }

        saveDataFromTab2Btn.setDisable(false);

        dataOdzywczeLoaded = true;
    }

    @FXML private void writeData() throws Exception{
        if (fileSet) {
            ArrayList<String> textNameRows = new ArrayList<String>();
            ArrayList<String> dataProduct = new ArrayList<String>();
            ArrayList<ChoiceBox<String>> columns = new ArrayList<ChoiceBox<String>>();
            columns.add(kolumnaOdzywcze100g);
            columns.add(kolumnaOdzywczePortion);
            columns.add(kolumnaOdzywczeRWS);

            for (DataSet dataSet : listDataSet) {
                textNameRows.add(dataSet.getName());
            }

            for (DataSetWithColumn dataSet : listDataPortion) {
                textNameRows.add(dataSet.getName());
            }


            for (DataSetValues dataSet : listDataSetOdzywcze) {
                textNameRows.add(dataSet.nameFor100g());
            }

            for (DataSetValues dataSet : listDataSetOdzywcze) {
                textNameRows.add(dataSet.nameForPortion());
            }

            for (DataSetValues dataSet : listDataSetOdzywcze) {
                textNameRows.add(dataSet.nameForRWS());
            }


            for (DataSet dataSet : listDataSet) {
                dataProduct.add(dataSet.readDescriptionToSaveData());
            }

            for (DataSetWithColumn dataSet : listDataPortion) {
                if (dataSet.readDescription().equals("")) dataProduct.add("-");
                else dataProduct.add(dataSet.readDescription());
            }


            for (ChoiceBox<String> choosedColumn : columns) {
                for (DataSetValues dataSet : listDataSetOdzywcze) {

                    if (dataSet.readTextField(choosedColumn.getId()).equals(""))
                        dataProduct.add("-");

                    else dataProduct.add(dataSet.readTextField(choosedColumn.getId()));
                }
            }

            String textNamesRow = arrayToString(textNameRows);
            String textDataRow = arrayToString(dataProduct);
            String dataToWrite = textNamesRow + "\nnnnnn" + textDataRow;

            ReadWriteTools.saveFile(path.replaceAll(".xls",  ".txt"), dataToWrite);
        }
    }

    public static String arrayToString(ArrayList<String> data) {
        StringBuilder outputText = new StringBuilder();
        for (int i = 0; i < data.size(); i++){
            outputText.append(data.get(i)).append("\t");
        }
        return outputText.toString();
    }

    public static String[] stringToArray(String data){
        return data.split("\t");
    }

    @FXML private void writePresets() throws Exception{
        final FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialDirectory(new File(System.getProperty("user.home"), "/Desktop"));
        fileChooser.getExtensionFilters().add(new ExtensionFilter("text file", "*.txt"));

        final File file = fileChooser.showSaveDialog(stage);

        if (file != null) {
            String path = file.getAbsolutePath();

            ArrayList<String> columnRows = new ArrayList<>();

            for (DataSet dataSet : listDataSet) {
                columnRows.add("" + dataSet.getColumnNumber() + "-" + dataSet.getRowNumber());
            }

            int[] tablica = new int[3];
            tablica[0] = kolumnaOdzywcze100g.getSelectionModel().getSelectedIndex();
            tablica[1] = kolumnaOdzywczePortion.getSelectionModel().getSelectedIndex();
            tablica[2] = kolumnaOdzywczeRWS.getSelectionModel().getSelectedIndex();

            for (int i = 0; i < 3; i++) {
                for (DataSetValues dataSet : listDataSetOdzywcze) {
                    columnRows.add("" + tablica[i] + "-" + dataSet.getRowNumber());
                }
            }
            ReadWriteTools.saveFile(path, arrayToString(columnRows));
        }
    }

    @FXML private void readPresets() throws Exception{
        final FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialDirectory(new File(System.getProperty("user.home"), "/Desktop"));
        fileChooser.getExtensionFilters().add(new ExtensionFilter("text file", "*.txt"));

        final File file = fileChooser.showOpenDialog(stage);

        if (file != null) {
            String txt = ReadWriteTools.readFile(file);
            String[] table = stringToArray(txt);

            System.out.println("Tablica z txt: " + Arrays.toString(table));

            for (int i = 0; i < listDataSet.size(); i++){
                listDataSet.get(i).setColumnNumberIncludeShiftColumn(Integer.parseInt(table[i].substring(0, table[i].indexOf("-"))));
                listDataSet.get(i).setRowNumber(table[i].substring(table[i].indexOf("-")+1));
            }

            kolumnaOdzywcze100g.getSelectionModel().select(Integer.parseInt(table[listDataSet.size()].substring(0, table[listDataSet.size()].indexOf("-"))));
            kolumnaOdzywczePortion.getSelectionModel().select(Integer.parseInt(table[listDataSet.size() + 1*9].substring(0, table[listDataSet.size() + 1*9].indexOf("-"))));
            kolumnaOdzywczeRWS.getSelectionModel().select(Integer.parseInt(table[listDataSet.size() + 2*9].substring(0, table[listDataSet.size() + 2*9].indexOf("-"))));

            for (int i = 0; i < listDataSetOdzywcze.size(); i++){
                listDataSetOdzywcze.get(i).setRowNumber(table[i + listDataSet.size()].substring(table[i + listDataSet.size()].indexOf("-") + 1));
            }

        }

    }


    @FXML private void applyColumns() {

    }

    private void loadSheetsNames(String path) {
        ObservableList<String> sheetsNames = XLSFileTools.loadSheetsNames(path);
        zakladkaTeksty.getItems().addAll(sheetsNames);
        zakladkaTeksty.getSelectionModel().select(0);
        zakladkaWartosciOdzywcze.getItems().addAll(sheetsNames);

        if (sheetsNames.size() > 1)
            zakladkaWartosciOdzywcze.getSelectionModel().select(1);
        else
            zakladkaWartosciOdzywcze.getSelectionModel().select(0);
    }
}


