package itmo;

import itmo.model.Dragon;

public class KeyDragonPair {

    /**
     * Описание полей класса
     */
    private Integer key;
    private Dragon dragon;

    /**
     * Пустой конструктор класса KeyDragonPair
     */
    public KeyDragonPair(){}

    /**
     * Конструктор класса KeyDragonPair
     * @param key - значение поля key
     * @param dragon - значение поля dragon
     */
    public KeyDragonPair(Integer key, Dragon dragon){
        this.dragon = dragon;
        this.key = key;
    }


    /**
     * Получение dragon
     * @return - значение поля dragon
     */
    public Dragon getDragon() {
        return dragon;
    }

    /**
     * Добавление dragon
     * @param dragon - значение поля dragon
     */
    public void setDragon(Dragon dragon) {
        this.dragon = dragon;
    }

    /**
     * Получение key
     * @return - значение поля key
     */
    public Integer getKey() {
        return key;
    }

    /**
     * Установка key
     * @param key - значение поля key
     */
    public void setKey(Integer key) {
        this.key = key;
    }
}
