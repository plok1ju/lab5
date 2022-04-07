package itmo;

import itmo.collection.HashTableCollection;
import itmo.manager.file.FileSaver;
import itmo.manager.file.ReaderXml;
import itmo.model.*;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Date;

public class TestMain {
    public static void main(String[] args) throws IOException {

        Date date = new Date();
        Person person = new Person("Tom", LocalDateTime.now(), 10L, "12h3", Country.ITALY);
        Dragon dragon = new Dragon(1L, "rr", new Coordinates(10.0, 1), date, 10, "ttt", Color.ORANGE, DragonCharacter.FICKLE, person);

        Dragon dragon1 = new Dragon(1L, "rr", new Coordinates(10.0, 1), date, 10, "ttt", Color.ORANGE, DragonCharacter.FICKLE, person);

        HashTableCollection<Integer, Dragon> dragons = new HashTableCollection<>();
        dragons.put(5, dragon);
        dragons.put(6, dragon1);

        FileSaver fileSaver = new FileSaver();
        fileSaver.saveInfo(dragons);

        ReaderXml readerXml = new ReaderXml();
        HashTableCollection<Integer, Dragon> collection = readerXml.returnCollect();
        System.out.println(collection);
        System.out.println("555");

       Color.ORANGE.getValues();

    }
}
