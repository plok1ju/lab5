package itmo.io;

import java.io.IOException;
/**
 * Интерфейс объекта, который возвращает строку
 */
public interface Scannable {

    /**
     * Возвращает строку считанную из файла
     */
    String scanString() throws IOException;

}
