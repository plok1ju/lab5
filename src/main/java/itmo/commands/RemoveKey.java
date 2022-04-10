package itmo.commands;

import itmo.collection.HashTableCollection;

/**
 * Класс отвечает за удаление элементов по значению ключа
 */
public class RemoveKey implements Command {

    /**
     * Поле collection
     * {@link HashTableCollection}
     */
    private final HashTableCollection<? extends Integer, ?> collection;

    /**
     * Поле key
     */
    private final Integer key;

    /**
     * Конструктор класса RemoveKey
     *
     * @param collection - Поле collection
     * @param key        - Поле key
     */
    public RemoveKey(HashTableCollection<? extends Integer, ?> collection, Integer key) {
        this.collection = collection;
        this.key = key;
    }

    /**
     * Переопределение метода execute
     * Удаление элемента из коллекции по ключу
     */
    @Override
    public void execute() {
        collection.remove(key);
    }
}
