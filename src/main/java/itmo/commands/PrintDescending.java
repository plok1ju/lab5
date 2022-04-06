package itmo.commands;


import itmo.collection.HashTableCollection;

import java.util.Comparator;
import java.util.List;

public class PrintDescending implements Command{

    private final HashTableCollection<? extends Integer, ?> collection;

    public PrintDescending(HashTableCollection<? extends Integer, ?> collection) {
        this.collection = collection;
    }

    @Override
    public void execute() {
        List<? extends Integer> keys = collection.getKeysAsList();
        keys.sort(Comparator.reverseOrder()); // реверс ключей
        keys.forEach(key -> {
            Object o = collection.get(key);
            System.out.println("Ключ элемента " + key + ": " + o);

        });
    }
}
