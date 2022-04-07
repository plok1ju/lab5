package itmo.commands;

import itmo.collection.HashTableCollection;
import itmo.model.Ageable;

import java.util.List;

public class SumOfAge implements Command{

    private final HashTableCollection<?, ? extends Ageable> collection;
    private Integer sumAge = 0;


    public SumOfAge(HashTableCollection<?, ? extends Ageable> collection) {
        this.collection = collection;
    }


    @Override
    public void execute(){
        List<?> keys = collection.getKeysAsList();
        keys.forEach(key -> sumAge += (collection.get(key).getAge() == null ? 0 : collection.get(key).getAge()));
        System.out.println("Сумма возрастов: " + sumAge);

    }
}
