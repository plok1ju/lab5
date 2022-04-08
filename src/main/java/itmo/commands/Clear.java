package itmo.commands;

import itmo.collection.HashTableCollection;

public class Clear implements Command {

    private final HashTableCollection<?, ?> collection; // ? - все равно какой тип

    public Clear(HashTableCollection<?, ?> collection) {
        this.collection = collection;
    }

    @Override
    public void execute() {
        collection.clear();
        System.out.println("Коллекция очищена");

    }


}
