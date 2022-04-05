package manager;

import manager.file.FileHandler;
import manager.file.FileSaver;

import java.io.File;
import java.util.Hashtable;

public class FileManager {

    public File getFile(){
        // VAR - переменная окружения
        File file = new File(System.getenv("VAR"));
        return file;
    }

    public FileHandler getFileHandler(){
        FileHandler fh = new FileHandler();
        return fh;
    }

}
