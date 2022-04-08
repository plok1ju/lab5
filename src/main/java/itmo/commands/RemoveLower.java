package itmo.commands;

import itmo.collection.HashTableCollection;
import itmo.model.Dragon;

import java.io.IOException;
import java.util.List;

//удалить из коллекции все элементы, меньшие, чем заданный
public class RemoveLower implements Command {

    private final HashTableCollection<Integer, Dragon> collection;
    private final Dragon dragon;

    public RemoveLower(HashTableCollection<Integer, Dragon> collection, Dragon dragon) {
        this.collection = collection;
        this.dragon = dragon;
    }


    @Override
    public void execute() throws IOException {
        List<Integer> keys = collection.getKeysAsList();
        keys.stream().filter(key -> dragon.compareTo(collection.get(key)) > 0).forEach(collection::remove);

    }
}
