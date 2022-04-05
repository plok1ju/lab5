package itmo.serializer;

import itmo.KeyDragonPair;
import itmo.collection.HashTableCollection;
import itmo.model.Dragon;

import java.util.ArrayList;
import java.util.Collections;

public class HashTableCollectSerializer {

    private HashTableCollection<Integer, Dragon> hashTableCollection;
    private KeyDragonPair[] keyDragonPairs;

    public HashTableCollectSerializer(HashTableCollection<Integer, Dragon> hashTableCollection){
        this.hashTableCollection = hashTableCollection;
        ArrayList<Integer> keys = Collections.list(hashTableCollection.keys());
        keyDragonPairs = new KeyDragonPair[keys.size()];
        for(int i = 0; i < keys.size(); i++ ){
            keyDragonPairs[i] = new KeyDragonPair(keys.get(i), hashTableCollection.get(keys.get(i)));

        }
    }

    public KeyDragonPair[] getKeyDragonPairs() {
        return keyDragonPairs;
    }
}
