package itmo.commands;

import itmo.collection.HashTableCollection;
import itmo.model.Dragon;

import java.io.IOException;

/**
 * Класс отвечает за замену элемента по ключу
 * Если значение нового элемента меньше старого
 */
public class ReplaceIfLowe implements Command {

    /**
     * Поле collection
     * {@link HashTableCollection}
     */
    private final HashTableCollection<Integer, Dragon> collection;

    /**
     * Поле key
     */
    private final Integer key;

    /**
     * Поле dragon
     * {@link Dragon}
     */
    private final Dragon dragon;

    /**
     * Конструктор класса ReplaceIfLowe
     *
     * @param collection - Поле collection
     * @param key        - Поле key
     * @param dragon     - Поле dragon
     */
    public ReplaceIfLowe(HashTableCollection<Integer, Dragon> collection, Integer key, Dragon dragon) {
        this.collection = collection;
        this.key = key;
        this.dragon = dragon;
    }


    /**
     * Переопределение метода execute
     * Замена элемента, если значение нового элемента меньше старого
     */
    @Override
    public void execute() throws IOException {
        if (dragon.compareTo(collection.get(key)) < 0) {
            collection.remove(key);
            collection.put(key, dragon);
        }

    }
}
