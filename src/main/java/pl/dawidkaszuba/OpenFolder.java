package pl.dawidkaszuba;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class OpenFolder {

    public static void open(String filePath){

            Desktop desktop = Desktop.getDesktop();
            File dirToOpen;
            try {
                dirToOpen = new File(filePath);
                try {
                    desktop.open(dirToOpen);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (IllegalArgumentException iae) {
                System.out.println("File Not Found");
            }
        }
}
