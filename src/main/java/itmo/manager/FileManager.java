package itmo.manager;

import itmo.manager.file.ReaderXml;

import java.io.File;

public class FileManager {

    public File getFile() {
        // VAR - переменная окружения
        File file = new File(System.getenv("VAR"));
        return file;
    }

    public ReaderXml getFileHandler() {
        ReaderXml fh = new ReaderXml();
        return fh;
    }

}
