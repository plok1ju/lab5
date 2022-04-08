package itmo.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileScan implements Scannable{

    private BufferedReader reader;

    public FileScan(String nameFile) throws FileNotFoundException {
        reader = new BufferedReader(new FileReader(nameFile));
    }

    @Override
    public String scanString() throws IOException {
        return reader.readLine();
    }
}
