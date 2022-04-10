package itmo.manager;

import java.io.File;
/**
 * Этот класс отвечает за работу с файлом xml
 */
public class FileManager {

    /**
     * Отдает файл xml для записи/чтения
     * @return - переменная окружения
     */
    public File getFile() {
        // VAR - переменная окружения
        File file = new File(System.getenv("VAR"));
        return file;
    }


}
