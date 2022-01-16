package zad4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class EquationReader {
    public static String readFromFile(String path){
        try(BufferedReader reader = new BufferedReader(new FileReader(path))){
            return reader.readLine();
        } catch(IOException exception){
            System.out.println("Failed to read from file: " + path);
        }

        return null;
    }
}
