package itmo.commands;

import itmo.collection.HashTableCollection;
import itmo.model.Color;
import itmo.model.Colorable;

import java.util.List;

public class RemoveAllByColor implements Command {

    private final HashTableCollection<?, ? extends Colorable> collection;
    private final Color color;

    public RemoveAllByColor(HashTableCollection<?, ? extends Colorable> collection, Color color) {
        this.collection = collection;
        this.color = color;
    }

    @Override
    public void execute() {
        List<?> keys = collection.getKeysAsList();
        keys.stream().filter(key -> collection.get(key).getColor().equals(color)).forEach(collection::remove); // берет поток всех ключей, оставляет только нужные, и пробегается и удаляет
    }
}
