package itmo.deserializers;

import com.fasterxml.jackson.annotation.JsonFormat;
import itmo.KeyDragonPair;
import itmo.collection.HashTableCollection;
import itmo.model.Dragon;

import java.time.LocalDateTime;

/**
 * Этот класс парсит файл - записывает данные из файла в коллекцию
 */
public class HashTableCollectDeserializer {

    /** Поле элемент дракон и ключ присвоенный дракону */
    private KeyDragonPair[] keyDragonPairs;

    /** Дата создания коллекции */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime localDateTime;

    /**
     * Пустой конструктор класса HashTableCollectDeserializer
     */
    public HashTableCollectDeserializer(){}

    /**
     * Добавление драконов и присвоенных им ключей
     * @param keyDragonPairs - значение поля passportID
     */
    public void setKeyDragonPairs(KeyDragonPair[] keyDragonPairs) {
        this.keyDragonPairs = keyDragonPairs;
    }

    /**
     * Получение коллекции
     * @return - коллекция HashTableCollection
     */
    public HashTableCollection<Integer, Dragon> getCollection(){
        HashTableCollection<Integer, Dragon> collection = new HashTableCollection<>();

        for(KeyDragonPair pair : keyDragonPairs){
            collection.put(pair.getKey(), pair.getDragon());
        }
        collection.setDateTime(localDateTime);
        return collection;
    }

    /**
     * Добавление даты создания коллекции
     * @param localDateTime - значение поля localDateTime
     */
    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }
}
