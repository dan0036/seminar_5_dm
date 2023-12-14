package notebook.util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileOperation {
    public static String fileName = null;

    public FileOperation(String fileName) {
        try (FileWriter writer = new FileWriter(fileName, true)) {
            writer.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }


}
