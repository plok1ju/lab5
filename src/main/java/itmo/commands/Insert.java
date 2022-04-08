package itmo.commands;

import itmo.collection.HashTableCollection;
import itmo.model.Dragon;

import java.io.IOException;

//добавить новый элемент с заданным ключом
public class Insert implements Command {

    private final HashTableCollection<Integer, Dragon> collection;
    private final Integer key;
    private final Dragon dragon;

    public Insert(HashTableCollection<Integer, Dragon> collection, Integer key, Dragon dragon) {
        this.collection = collection;
        this.key = key;
        this.dragon = dragon;
    }

    @Override
    public void execute() throws IOException {
        collection.put(key, dragon);

    }
}
