package itmo.commands;

import itmo.collection.HashTableCollection;
import itmo.model.Ageable;

import java.util.List;

public class SumOfAge implements Command{

    private HashTableCollection<?, ? extends Ageable> collection;
    private Integer sumAge = 0;


    public SumOfAge(HashTableCollection<?, ? extends Ageable> collection) {
        this.collection = collection;
    }

//    public void sum(Hashtable<Integer, Dragon> dragons){
//
//        int sum = 0;
//        Enumeration hashKeys = dragons.keys();
//        while (hashKeys.hasMoreElements()){
//            Integer str = (Integer) hashKeys.nextElement();
//            Dragon dragon= dragons.get(str);
//            sum += dragon.getAge();
//        }
//
//        System.out.println("Sum of age is: " + sum);
//    }

    @Override
    public void execute(){
        List<?> keys = collection.getKeysAsList();
        keys.forEach(key -> sumAge += collection.get(key).getAge());
        System.out.println("Sum of age is: " + sumAge);

    }
}
