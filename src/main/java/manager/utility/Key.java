package manager.utility;

public class Key {

    private Integer key;

    public Key(Integer key){
        this.key = key;
    }

    public Integer getKey() {
        return key+1;
    }

    public void setKey(Integer ID) {
        this.key = ID;
    }
}
