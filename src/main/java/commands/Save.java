package commands;

import manager.file.FileSaver;
import model.Dragon;

import java.io.File;
import java.util.Hashtable;

public class Save {

    public void saveCollect(Hashtable<Integer, Dragon> dragons, File file){
        FileSaver fs = new FileSaver();
        fs.saveInfo(dragons,file);
        System.out.println("New information save in file");

    }
}
