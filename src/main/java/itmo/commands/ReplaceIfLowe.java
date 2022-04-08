package itmo.commands;

import itmo.collection.HashTableCollection;
import itmo.model.Dragon;

import java.io.IOException;

//заменить значение по ключу, если новое значение элемента меньше старого
public class ReplaceIfLowe implements Command {

    private final HashTableCollection<Integer, Dragon> collection;
    private final Integer key;
    private final Dragon dragon;


    public ReplaceIfLowe(HashTableCollection<Integer, Dragon> collection, Integer key, Dragon dragon) {
        this.collection = collection;
        this.key = key;
        this.dragon = dragon;
    }

    @Override
    public void execute() throws IOException {
        if (dragon.compareTo(collection.get(key)) < 0) {
            collection.remove(key);
            collection.put(key, dragon);
        }

    }
}
