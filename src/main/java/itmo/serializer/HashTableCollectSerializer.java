package itmo.serializer;

import com.fasterxml.jackson.annotation.JsonFormat;
import itmo.KeyDragonPair;
import itmo.collection.HashTableCollection;
import itmo.model.Dragon;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;

public class HashTableCollectSerializer {

    private final KeyDragonPair[] keyDragonPairs;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    private final LocalDateTime localDateTime;


    public HashTableCollectSerializer(HashTableCollection<Integer, Dragon> hashTableCollection){
        ArrayList<Integer> keys = Collections.list(hashTableCollection.keys());
        keyDragonPairs = new KeyDragonPair[keys.size()];
        for(int i = 0; i < keys.size(); i++ ){
            keyDragonPairs[i] = new KeyDragonPair(keys.get(i), hashTableCollection.get(keys.get(i)));

        }
        this.localDateTime = hashTableCollection.getDateTime();
    }

    public KeyDragonPair[] getKeyDragonPairs() {
        return keyDragonPairs;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }
}
