package itmo.io;

import java.io.IOException;
/**
 * Интерфейс объекта, который возвращает строку
 */
public interface Scannable {

    /**
     * Возвращает считанную строку
     */
    String scanString() throws IOException;

    boolean hasNextLine() throws IOException;

}
