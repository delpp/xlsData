package xls.model;


import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class ReadWriteTools {
    public static void saveFile(String fileName, String text){
        try (PrintStream out = new PrintStream(new FileOutputStream(fileName))) {
            out.print(text);
        }
        catch (IOException ex){
            ex.printStackTrace();
        };
    }
}