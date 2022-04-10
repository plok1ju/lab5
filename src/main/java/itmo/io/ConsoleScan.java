package itmo.io;

import java.util.Scanner;
/**
 * Этот класс помогает читать данные с консоли
 */
public class ConsoleScan implements Scannable {

    /**
     * Поле scanner
     */
    private final Scanner scanner;

    /**
     * Конструктор класса ConsoleScan
     */
    public ConsoleScan() {
        scanner = new Scanner(System.in);
    }

    /**
     * Переопределение метода scanString
     *
     * @return - считанная строка
     */
    @Override
    public String scanString() {
        return scanner.nextLine();
    }

}
