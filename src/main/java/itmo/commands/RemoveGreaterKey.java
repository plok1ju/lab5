package itmo.commands;

import itmo.collection.HashTableCollection;

import java.util.List;

public class RemoveGreaterKey implements Command{

    private final HashTableCollection<? extends Integer, ?> collection;
    private final Integer key;


    public RemoveGreaterKey(HashTableCollection<? extends Integer, ?> collection, Integer key) {
        this.collection = collection;
        this.key = key;
    }

    @Override
    public void execute() {
        List<? extends Integer> keys = collection.getKeysAsList();
        keys.stream().filter(keyInKeys -> keyInKeys.compareTo(this.key) > 0).forEach(collection::remove);

    }
}
