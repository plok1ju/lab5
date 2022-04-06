package itmo.commands;

import itmo.collection.HashTableCollection;

public class Info implements Command{

    private final HashTableCollection<?, ?> collection;

    public Info(HashTableCollection<?, ?> collection) {
        this.collection = collection;
    }


    public void execute(){
        System.out.println("Тип элемента коллекции: " + collection.getClass().getSimpleName()); // getSimpleName() имя класса в простом представлении
        System.out.println("Дата создания коллекции: " + collection.getDateTime());
        System.out.println("Количество элементов: " + collection.size());

    }
}
