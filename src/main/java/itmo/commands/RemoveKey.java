package itmo.commands;

import itmo.collection.HashTableCollection;

public class RemoveKey implements Command {

    private final HashTableCollection<? extends Integer, ?> collection;
    private final Integer key;

    public RemoveKey(HashTableCollection<? extends Integer, ?> collection, Integer key) {
        this.collection = collection;
        this.key = key;
    }


    @Override
    public void execute() {
        collection.remove(key);
    }
}
