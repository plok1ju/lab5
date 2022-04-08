package itmo.io;

import java.util.Scanner;

public class ConsoleScan implements Scannable {

    private final Scanner scanner;

    public ConsoleScan() {
        scanner = new Scanner(System.in);
    }

    @Override
    public String scanString() {
        return scanner.nextLine();
    }

}
