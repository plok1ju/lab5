package itmo;

import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import itmo.collection.HashTableCollection;
import itmo.deserializers.HashTableCollectDeserializer;
import itmo.model.*;
import itmo.serializer.HashTableCollectSerializer;

import java.io.File;
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

        HashTableCollectSerializer serializer = new HashTableCollectSerializer(dragons);

        XmlMapper xmlMapper = new XmlMapper(); // будет сам записывать дракона
        xmlMapper.enable(SerializationFeature.INDENT_OUTPUT); // красивый вывод
        xmlMapper.registerModule(new JavaTimeModule()); // сериализация время

        xmlMapper.writeValue(new File("test.xml"), serializer);

        HashTableCollectDeserializer deserializer = xmlMapper.readValue(new File("test.xml"), HashTableCollectDeserializer.class); // десериализация в класс Dragon
        HashTableCollection<Integer, Dragon> collection = deserializer.getCollection();
        System.out.println(collection);


    }
}
