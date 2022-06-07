package xls.model;


import java.io.*;
import java.util.Scanner;

public class ReadWriteTools {
    public static void saveFile(String fileName, String text){
        try (PrintStream out = new PrintStream(new FileOutputStream(fileName))) {
            out.print(text);
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