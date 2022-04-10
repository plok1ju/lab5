package itmo.manager;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FilesHistory {

    private static FilesHistory instance = null;

    private List<File> filePaths = new ArrayList<>();

    private FilesHistory(){}

    public static FilesHistory getInstance(){
        if(instance == null){
            instance = new FilesHistory();
        }
        return instance;
    }

    public void addHistory(File file){
        filePaths.add(file);
    }

    public boolean containsFile(File file){
        return filePaths.stream().anyMatch(file1 -> file1.getAbsolutePath().equals(file.getAbsolutePath()));
    }

    public void removeFile(File file){
        filePaths.removeIf(file1 -> file1.getAbsolutePath().equals(file.getAbsolutePath()));
    }
}
