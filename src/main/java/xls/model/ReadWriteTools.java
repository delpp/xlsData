package xls.model;


import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;
import xls.Main;

import java.io.*;
import java.util.Optional;
import java.util.Scanner;

public class ReadWriteTools {
    public static void saveFile(String fileName, String text){
        try (PrintStream out = new PrintStream(new FileOutputStream(fileName))) {
            out.print(text);

            Optional<ButtonType> buttonType = AlertBox.showAndWait(
                    Alert.AlertType.INFORMATION,
                    "Zapisano plik txt",
                    "Dane zapisano w: " + fileName);

        }
        catch (IOException ex){
            ex.printStackTrace();
        };
    }

    public static String readFile(File file) throws FileNotFoundException {
        String content = new Scanner(file).useDelimiter("\\Z").next();

        return content;
    }
}

class AlertBox  {
    private AlertBox() {}
    public static Optional<ButtonType> showAndWait(
            Alert.AlertType alertType,
            String title,
            String content) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);

        DialogPane dialogPane = alert.getDialogPane();


        dialogPane.getStylesheets().add(Main.class.getClassLoader().getResource("xls_styles.css").toExternalForm());

        dialogPane.getStyleClass().add("button");

        dialogPane.setPrefWidth(800);

        //alert.getDialogPane().lookupButton(ButtonType.OK).setStyle("-fx-font-family: Arial; -fx-font-weight: regular;");

        return alert.showAndWait();
    } }