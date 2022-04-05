package itmo.deserializers;

import itmo.KeyDragonPair;
import itmo.collection.HashTableCollection;
import itmo.model.Dragon;

public class HashTableCollectDeserializer {

    private KeyDragonPair[] keyDragonPairs;

    public HashTableCollectDeserializer(){}

    public void setKeyDragonPairs(KeyDragonPair[] keyDragonPairs) {
        this.keyDragonPairs = keyDragonPairs;
    }

    public HashTableCollection<Integer, Dragon> getCollection(){
        HashTableCollection<Integer, Dragon> collection = new HashTableCollection<>();

        for(KeyDragonPair pair : keyDragonPairs){
            collection.put(pair.getKey(), pair.getDragon());
        }
        return collection;
    }
}
