package itmo.commands;

import itmo.collection.HashTableCollection;
import itmo.model.Dragon;

import java.io.IOException;
import java.util.List;

/**
 * Класс отвечает за удаление элементов, меньших чем заданный
 */
public class RemoveLower implements Command {

    /**
     * Поле collection
     * {@link HashTableCollection}
     */
    private final HashTableCollection<Integer, Dragon> collection;

    /**
     * Поле dragon
     * {@link Dragon}
     */
    private final Dragon dragon;

    /**
     * Конструктор класса RemoveLower
     *
     * @param collection - Поле collection
     * @param dragon     - Поле dragon
     */
    public RemoveLower(HashTableCollection<Integer, Dragon> collection, Dragon dragon) {
        this.collection = collection;
        this.dragon = dragon;
    }

    /**
     * Переопределение метода execute
     * Удаление элементов если они меньше поля dragon
     */
    @Override
    public void execute() throws IOException {
        List<Integer> keys = collection.getKeysAsList();
        keys.stream().filter(key -> dragon.compareTo(collection.get(key)) > 0).forEach(collection::remove);

    }
}
