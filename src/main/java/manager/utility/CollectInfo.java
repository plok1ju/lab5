package manager.utility;

import model.Dragon;

import java.util.Date;
import java.util.Hashtable;

/**
 * Класс информации о коллекции для xml
 */
public class CollectInfo {


    /**
     * Поля класса
     */
    private static Hashtable<Integer, Dragon> collection;
    private final Date creationDate;


    /**
     * Конструктор класса
     *
     * @param collection   - значение поля collection
     * @param creationDate - значение поля creationDate
     * @throws Exception - исключение о пустых полях класса
     */
    public CollectInfo(Hashtable<Integer, Dragon> collection, Date creationDate) throws Exception {
        if (collection != null && creationDate != null) {
            CollectInfo.collection = collection;
            this.creationDate = creationDate;
        } else {
            throw new Exception("Параметры не могут быть null.");
        }
    }


    /**
     * Получение коллекции
     *
     * @return - коллекция
     */
    public Hashtable<Integer, Dragon> getCollection() {
        return collection;
    }

    /**
     * Получение даты создания
     *
     * @return - дата создания файла
     */
    public Date getCreationDate() {
        return creationDate;
    }
}
