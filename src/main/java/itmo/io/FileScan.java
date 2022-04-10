package itmo.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
/**
 * Этот класс помогает читать данные из файла для команды ExecuteScript
 */
public class FileScan implements Scannable{

    /**
     * Поле reader
     */
    private BufferedReader reader;

    /**
     * Конструктор класса FileScan
     *
     * @param nameFile - значение поля nameFile
     */
    public FileScan(String nameFile) throws FileNotFoundException {
        reader = new BufferedReader(new FileReader(nameFile));
    }

    /**
     * Переопределение метода scanString
     *
     * @return - считанная строка из файла
     */
    @Override
    public String scanString() throws IOException {
        return reader.readLine();
    }
}
