package itmo.commands;

import itmo.collection.HashTableCollection;

import java.util.List;

public class Show implements Command{

    private final HashTableCollection<?, ?> collection;

    public Show(HashTableCollection<?, ?> collection){
        this.collection = collection;
    }


    @Override
    public void execute() {
        List<?> keys = collection.getKeysAsList();
        keys.forEach(key -> {
            System.out.println("=====");
            System.out.println("Ключ элемента: " + key + " " + collection.get(key).toString());
            System.out.println("=====");
        });


    }
}
