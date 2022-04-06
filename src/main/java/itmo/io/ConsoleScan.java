package itmo.io;

import java.util.Scanner;

public class ConsoleScan implements Scannable{

    private Scanner scanner;

    public ConsoleScan() {
        scanner = new Scanner(System.in);
    }

    @Override
    public String scanString() {
        return scanner.nextLine();
    }

}
