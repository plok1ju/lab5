package itmo.comparators;

import itmo.collection.HashTableCollection;
import itmo.model.Dragon;

import java.util.Comparator;

public class CollectionComparator implements Comparator<Integer> {


    private HashTableCollection<Integer, Dragon> collection;

    public CollectionComparator(HashTableCollection<Integer, Dragon> collection) {
        this.collection = collection;
    }


    @Override
    public int compare(Integer o1, Integer o2) {
        return new DragonComparator().compare(collection.get(o1), collection.get(o2));
    }
}
