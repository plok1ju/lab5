package manager.file;


import manager.CollectionManager;
import model.Dragon;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Hashtable;

public class FileSaver {

    public void saveInfo(Hashtable<Integer, Dragon> dragons, File file) {
        CollectionManager cm = new CollectionManager();
        int[] keys = new int[]{1, 2, 3};
        try {
            XMLOutputFactory output = XMLOutputFactory.newInstance();
            XMLStreamWriter writer = output.createXMLStreamWriter(new FileWriter(file));

            // Открываем XML-документ и Пишем корневой элемент dradons
            writer.writeStartDocument("1.0");
            writer.writeCharacters("\n");
            writer.writeStartElement("dragons");
            writer.writeCharacters("\n");

            for (int i = 0; i < keys.length; i++) {
                // Записываем dragons
                writer.writeStartElement("dragon");
                writer.writeCharacters("\n");

                // Заполняем все тэги для dragon
                // id
                writer.writeStartElement("id");
                writer.writeCharacters(String.valueOf(dragons.get(keys[i]).getId()));
                writer.writeEndElement();
                writer.writeCharacters("\n");
                // name
                writer.writeStartElement("name");
                writer.writeCharacters(dragons.get(keys[i]).getName());
                writer.writeEndElement();
                writer.writeCharacters("\n");
                // coordinates
                writer.writeStartElement("coordinates");

                writer.writeStartElement("x");
                writer.writeCharacters(String.valueOf(dragons.get(keys[i]).getCoordinates().getX()));
                writer.writeEndElement();
                writer.writeCharacters("\n");

                writer.writeStartElement("y");
                writer.writeCharacters(String.valueOf(dragons.get(keys[i]).getCoordinates().getY()));
                writer.writeEndElement();
                writer.writeCharacters("\n");

                writer.writeEndElement();
                writer.writeCharacters("\n");

                //date
                writer.writeStartElement("date");
                writer.writeCharacters(String.valueOf(dragons.get(keys[i]).getCreationDate()));
                writer.writeEndElement();
                writer.writeCharacters("\n");
                //age
                writer.writeStartElement("age");
                writer.writeCharacters(String.valueOf(dragons.get(keys[i]).getAge()));
                writer.writeEndElement();
                writer.writeCharacters("\n");
                //description
                writer.writeStartElement("description");
                writer.writeCharacters(dragons.get(keys[i]).getDescription());
                writer.writeEndElement();
                writer.writeCharacters("\n");
                //color
                writer.writeStartElement("color");
                writer.writeCharacters(String.valueOf(dragons.get(keys[i]).getColor()));
                writer.writeEndElement();
                writer.writeCharacters("\n");
                //character
                writer.writeStartElement("character");
                writer.writeCharacters(String.valueOf(dragons.get(keys[i]).getCharacter()));
                writer.writeEndElement();
                writer.writeCharacters("\n");
                //killer
                writer.writeStartElement("killer");

                writer.writeStartElement("name");
                writer.writeCharacters(dragons.get(keys[i]).getKiller().getName());
                writer.writeEndElement();
                writer.writeCharacters("\n");

                writer.writeStartElement("birthday");
                writer.writeCharacters(String.valueOf(dragons.get(keys[i]).getKiller().getBirthday()));
                writer.writeEndElement();
                writer.writeCharacters("\n");

                writer.writeStartElement("height");
                writer.writeCharacters(String.valueOf(dragons.get(keys[i]).getKiller().getHeight()));
                writer.writeEndElement();
                writer.writeCharacters("\n");


                writer.writeStartElement("passport");
                writer.writeCharacters(dragons.get(keys[i]).getKiller().getPassportID());
                writer.writeEndElement();
                writer.writeCharacters("\n");

                writer.writeStartElement("nationality");
                writer.writeCharacters(String.valueOf(dragons.get(keys[i]).getKiller().getNationality()));
                writer.writeEndElement();
                writer.writeCharacters("\n");

                writer.writeEndElement();
                writer.writeCharacters("\n");

                writer.writeEndElement();
                writer.writeCharacters("\n");
            }
            // Закрываем корневой элемент
            writer.writeEndElement();
            // Закрываем XML-документ
            writer.writeEndDocument();
            writer.flush();
        } catch (XMLStreamException | IOException ex) {
            ex.printStackTrace();
        }
    }
}

