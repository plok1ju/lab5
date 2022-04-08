package itmo.commands;

import itmo.collection.HashTableCollection;
import itmo.manager.file.FileSaver;
import itmo.model.Dragon;

import java.io.IOException;

public class Save implements Command {

    private final HashTableCollection<Integer, Dragon> collection;

    public Save(HashTableCollection<Integer, Dragon> collection) {
        this.collection = collection;
    }

    @Override
    public void execute() throws IOException {
        FileSaver fileSaver = new FileSaver();
        fileSaver.saveInfo(collection);

    }
}
