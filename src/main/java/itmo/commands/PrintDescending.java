package itmo.commands;


import itmo.collection.HashTableCollection;

import java.util.Comparator;
import java.util.List;

/**
 * Класс отвечает за вывод коллекции в порядке убывания
 */
public class PrintDescending implements Command {

    /**
     * Поле collection
     * {@link HashTableCollection}
     */
    private final HashTableCollection<? extends Integer, ?> collection;

    /**
     * Конструктор класса PrintDescending
     *
     * @param collection - Поле collection
     */
    public PrintDescending(HashTableCollection<? extends Integer, ?> collection) {
        this.collection = collection;
    }

    /**
     * Переопределение метода execute
     * Вывод элементов коллекции
     */
    @Override
    public void execute() {
        List<? extends Integer> keys = collection.getKeysAsList();
        keys.sort(Comparator.reverseOrder()); // реверс ключей
        keys.forEach(key -> {
            Object o = collection.get(key);
            System.out.println("Ключ элемента " + key + ": " + o);

        });
    }
}
