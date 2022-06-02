package xls.model;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.BuiltinFormats;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class XLSFileTools {

    public static String readCell(
            String imputFileName,
            int sheetNumber,
            int rowNumber,
            int columnNumber,
            boolean checkingTextFormat) throws Exception{

        System.setProperty("sun.java2d.cmm", "sun.java2d.cmm.kcms.KcmsServiceProvider");

        String data = "";

        try {
            FileInputStream file = new FileInputStream(imputFileName);
            Workbook workbook;

            Cell cell;

            workbook = new HSSFWorkbook(file);
            Sheet sheet = workbook.getSheetAt(sheetNumber);

            Row row = sheet.getRow(rowNumber);

            try {
                cell = row.getCell(columnNumber);

                CellStyle cellStyle = cell.getCellStyle();

                data = formatStringXLS(workbook, cell, cellStyle, checkingTextFormat);
            }
            catch (NullPointerException npex) {
                data = "";
            }

            workbook.close();
            file.close();

        }
        catch (IOException ex){
            ex.printStackTrace();
        }
        return data;
    }

    public static ObservableList<String> loadSheetsNames(String imputFileName) {
        System.setProperty("sun.java2d.cmm", "sun.java2d.cmm.kcms.KcmsServiceProvider");
        ObservableList<String> sheets = FXCollections.observableArrayList();

        try {
            FileInputStream file = new FileInputStream(imputFileName);
            Workbook workbook = new HSSFWorkbook(file);

            int countOfSheets = workbook.getNumberOfSheets();
            System.out.println("Liczba sheetów: " + countOfSheets);

            for (int i = 0 ; i < countOfSheets; i++) {
                sheets.add(workbook.getSheetAt(i).getSheetName());
            }
            workbook.close();
        }
        catch (IOException ex){
            ex.printStackTrace();
        }

        return sheets;
    }

    public static String formatStringXLS(Workbook workbook, Cell cell, CellStyle cellStyle, boolean checkingTextFormat){
        StringBuilder outString = new StringBuilder();
        String text = "";

        //System.out.println("cell.getCellType() = " + cell.getCellType());

        if (cell.getCellType() == 0) { // typ: NUMERIC
            cell.setCellType(1);
        }

        if (cell.getCellType() == 1) {	// typ: STRING

            text = cell.getStringCellValue();

            if (checkingTextFormat) {
                HSSFRichTextString rts = (HSSFRichTextString) cell.getRichStringCellValue();
                HSSFFont font;

                HSSFCellStyle style = (HSSFCellStyle) cell.getCellStyle();
                font = style.getFont(workbook);

                boolean bold = false;
                boolean underline = false;
                boolean italic = false;
                boolean generalCellBold = false;

                List<String> list = new ArrayList<String>(); // lista z włączonymi nastawami (bold - b, underline - u, italic - i)

                if (font.getBoldweight() == 700) {
                    outString.append("<b>");
                    generalCellBold = true;
                    list.add("b");
                }

                int size;

                for (int i = 0; i < cell.getStringCellValue().length(); i++) {
                    font = (HSSFFont) workbook.getFontAt(rts.getFontAtIndex(i));

                    //if (font.getCharSet() < 238){ // jeśli jest różne od 238 - bierze formatowanie z każdego znaku
                    if ((bold == false) && (font.getBoldweight() == 700)) {
                        outString.append("<b>");
                        bold = true;
                        list.add("b");
                    }
                    if ((bold) && (font.getBoldweight() == 400))
                        bold = false;

                    if ((underline == false) && (font.getUnderline() == 1)) {
                        outString.append("<u>");
                        underline = true;
                        list.add("u");
                    }
                    if ((underline) && (font.getUnderline() == 0))
                        underline = false;

                    if ((italic == false) && (font.getItalic() == true)) {
                        outString.append("<i>");
                        italic = true;
                        list.add("i");
                    }
                    if ((italic) && (font.getItalic() == false))
                        italic = false;

                    // wyłączenie nastaw, jeśli była zmiana fontu
                    size = list.size();
                    for (int j = size - 1; j >= 0; j--){
                        String znak = (String) list.get(j);
                        if ((znak.equals("b")) && (!bold)) {
                            if (!generalCellBold) {
                                list.remove("b");
                                outString.append("</b>");
                            }
                        }
                        if ((znak.equals("u")) && (!underline)) {
                            list.remove("u");
                            outString.append("</u>");
                        }
                        if ((znak.equals("i")) && (!italic)) {
                            list.remove("i");
                            outString.append("</i>");
                        }
                    }
                    outString.append(text.charAt(i));
                }

                size = list.size();
                for (int i = size - 1; i >= 0; i--){
                    String znak = (String) list.get(i);
                    if (znak.equals("b")) outString.append("</b>");
                    if (znak.equals("u")) outString.append("</u>");
                    if (znak.equals("i")) outString.append("</i>");
                }
            }
            else outString.append(text);
        }

        if (cell.getCellType() == 2) { //typ: FORMULA

            if (cell.getCellStyle().getDataFormatString().contains("%")) {
                text = getNumberFromFormula(workbook, cell, cellStyle);
            }
            else text = cell.getStringCellValue();


            System.out.println("FORMUŁA, wartość: " + text);

            outString.append(text);

        }

        return outString.toString();
    }

    public static String getNumberFromFormula(Workbook workbook, Cell cell, CellStyle cellStyle) {
        String text = "";
        DataFormatter objDefaultFormat = new DataFormatter(true);

        if (cellStyle != null) {

            int formatIndex = cellStyle.getDataFormat();

            String formatString = cellStyle.getDataFormatString();

            if (formatString == null) {
                // formatString could not be found, so it must be a builtin format.
                formatString = BuiltinFormats.getBuiltinFormat(formatIndex);
            }

            try {
                // format the floating-point value
                text = objDefaultFormat.formatRawCellContents(
                        cell.getNumericCellValue(), formatIndex, formatString);
            }
            catch (IllegalStateException ex) {
                text = "";
            }

        }

        else {
            FormulaEvaluator objFormulaEvaluator = workbook.getCreationHelper().createFormulaEvaluator();
            objFormulaEvaluator.evaluateFormulaCell(cell);

            text = objDefaultFormat.formatCellValue(cell, objFormulaEvaluator);
        }

        return text;
    }


}
