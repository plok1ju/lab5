package itmo.commands;

import itmo.collection.HashTableCollection;
import itmo.model.Dragon;

import java.io.IOException;
/**
 * Класс отвечает за добавление нового элемента в коллекцию
 */
public class Insert implements Command {

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
     * Конструктор класса Clear
     *
     * @param collection - Поле collection
     * @param key - Поле key
     * @param dragon - Поле dragon
     */
    public Insert(HashTableCollection<Integer, Dragon> collection, Integer key, Dragon dragon) {
        this.collection = collection;
        this.key = key;
        this.dragon = dragon;
    }

    /**
     * Переопределение метода execute
     * Добавление элемента в коллекцию
     */
    @Override
    public void execute() throws IOException {
        collection.put(key, dragon);

    }
}
