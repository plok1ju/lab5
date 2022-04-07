package itmo.deserializers;

import com.fasterxml.jackson.annotation.JsonFormat;
import itmo.KeyDragonPair;
import itmo.collection.HashTableCollection;
import itmo.model.Dragon;

import java.time.LocalDateTime;

/**
 * Этот класс
 */
public class HashTableCollectDeserializer {

    private KeyDragonPair[] keyDragonPairs;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime localDateTime;

    public HashTableCollectDeserializer(){}

    public void setKeyDragonPairs(KeyDragonPair[] keyDragonPairs) {
        this.keyDragonPairs = keyDragonPairs;
    }

    public HashTableCollection<Integer, Dragon> getCollection(){
        HashTableCollection<Integer, Dragon> collection = new HashTableCollection<>();

        for(KeyDragonPair pair : keyDragonPairs){
            collection.put(pair.getKey(), pair.getDragon());
        }
        collection.setDateTime(localDateTime);
        return collection;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }
}
