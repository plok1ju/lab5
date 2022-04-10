package itmo.commands;

import itmo.collection.HashTableCollection;
import itmo.model.Dragon;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * Класс отвечает за обновление полей элемента коллекции по id
 */
public class UpdateId implements Command {

    /**
     * Поле collection
     * {@link HashTableCollection}
     */
    private final HashTableCollection<Integer, Dragon> collection;

    /**
     * Поле id
     */
    private final Long id;

    /**
     * Поле dragon
     * {@link Dragon}
     */
    private final Dragon dragon;

    /**
     * Конструктор класса ReplaceIfLowe
     *
     * @param collection - Поле collection
     * @param id         - Поле id
     * @param dragon     - Поле dragon
     */
    public UpdateId(HashTableCollection<Integer, Dragon> collection, Long id, Dragon dragon) {
        this.collection = collection;
        this.id = id;
        this.dragon = dragon;
    }

    /**
     * Переопределение метода execute
     * Обновление элемента по id
     */
    @Override
    public void execute() throws Exception {
        List<Integer> keys = collection.getKeysAsList();
        dragon.setId(this.id);
        Stream<Integer> integerStream = keys.stream().filter(key -> id.equals(collection.get(key).getId()));
        Optional<Integer> optionalKey = integerStream.findAny();
        if (!optionalKey.isPresent()) {
            throw new Exception("Нет такого id");
        }
        Integer dragonKey = optionalKey.get();
        keys.stream().filter(key -> id.equals(collection.get(key).getId())).forEach(collection::remove);

        collection.put(dragonKey, dragon);

    }
}
