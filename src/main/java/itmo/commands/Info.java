package itmo.commands;

import itmo.collection.HashTableCollection;

public class Info implements Command{

    private final HashTableCollection<?, ?> collection;

    public Info(HashTableCollection<?, ?> collection) {
        this.collection = collection;
    }


    public void execute(){
        System.out.println("Collection type is: " + collection.getClass().getSimpleName()); // getSimpleName() имя класса в простом представлении
        System.out.println("Date of creating collection is: " + collection.getDateTime());
        System.out.println("Amount of elements: " + collection.size());

    }
}
