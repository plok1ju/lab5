package itmo.commands;

import itmo.collection.HashTableCollection;
import itmo.model.Dragon;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class UpdateId implements Command {

    private final HashTableCollection<Integer, Dragon> collection;
    private final Long id;
    private final Dragon dragon;

    public UpdateId(HashTableCollection<Integer, Dragon> collection, Long id, Dragon dragon) {
        this.collection = collection;
        this.id = id;
        this.dragon = dragon;
    }


    @Override
    public void execute() throws Exception {
        List<Integer> keys = collection.getKeysAsList();
        dragon.setId(this.id);
        Stream<Integer> integerStream = keys.stream().filter(key -> id.equals(collection.get(key).getId()));
        Optional<Integer> optionalKey = integerStream.findAny();
        if (!optionalKey.isPresent()){
            throw new Exception("Нет такого id");
        }
        Integer key = optionalKey.get();
        integerStream.forEach(collection::remove);
        collection.put(key, dragon);

    }
}
