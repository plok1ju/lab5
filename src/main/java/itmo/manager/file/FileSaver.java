package itmo.manager.file;


import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import itmo.collection.HashTableCollection;
import itmo.model.Dragon;
import itmo.serializer.HashTableCollectSerializer;

import java.io.File;
import java.io.IOException;

public class FileSaver {

    public void saveInfo(HashTableCollection<Integer, Dragon> dragons) throws IOException {

        HashTableCollectSerializer serializer = new HashTableCollectSerializer(dragons);

        XmlMapper xmlMapper = new XmlMapper(); // будет сам записывать дракона
        xmlMapper.enable(SerializationFeature.INDENT_OUTPUT); // красивый вывод
        xmlMapper.registerModule(new JavaTimeModule()); // сериализация время

        xmlMapper.writeValue(new File(System.getenv("VAR")), serializer);


    }
}

