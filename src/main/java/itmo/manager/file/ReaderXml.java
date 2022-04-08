package itmo.manager.file;

import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import itmo.collection.HashTableCollection;
import itmo.deserializers.HashTableCollectDeserializer;
import itmo.model.Dragon;

import java.io.File;
import java.io.IOException;

/**
 * Этот класс считывает информацию из xml файла и вызывает deserializer
 */
public class ReaderXml {


    /**
     * Метод отвечает за создание коллекции по данным файла xml
     *
     * @return - коллекция
     */
    public HashTableCollection<Integer, Dragon> returnCollect() throws IOException {

        XmlMapper xmlMapper = new XmlMapper(); // будет сам записывать дракона
        xmlMapper.enable(SerializationFeature.INDENT_OUTPUT); // красивый вывод
        xmlMapper.registerModule(new JavaTimeModule()); // сериализация время

        HashTableCollectDeserializer deserializer = xmlMapper.readValue(new File(System.getenv("VAR")), HashTableCollectDeserializer.class); // десериализация в класс Dragon
        HashTableCollection<Integer, Dragon> collection = deserializer.getCollection();

        return collection;
    }


}
