package itmo;

import itmo.model.Dragon;

public class KeyDragonPair {

    private Integer key;
    private Dragon dragon;

    public KeyDragonPair(){}

    public KeyDragonPair(Integer key, Dragon dragon){
        this.dragon = dragon;
        this.key = key;
    }


    public Dragon getDragon() {
        return dragon;
    }

    public void setDragon(Dragon dragon) {
        this.dragon = dragon;
    }

    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }
}
