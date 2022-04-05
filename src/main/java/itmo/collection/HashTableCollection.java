package itmo.collection;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.List;

public class HashTableCollection<K, T> extends Hashtable<K, T>{

    private LocalDateTime dateTime = LocalDateTime.now();

    public HashTableCollection(){}

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public List<K> getKeysAsList(){
        return new ArrayList<K>(Collections.list(this.keys()));
    }
}
