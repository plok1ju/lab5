package manager.file;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.swing.text.Document;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.time.LocalDateTime;
import java.util.*;

//этот класс отвечает за занесение данных из файла xml в коллекцию
public class FileHandler {


//    public Document openFile(File file) {
//        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
//        Document document = null;
//        try {
//            document = (Document) dbf.newDocumentBuilder().parse(file);
//            System.out.println("file is open");
//            return document;
//        } catch (IOException | ParserConfigurationException | org.xml.sax.SAXException e) {
//            System.out.println("Have problem with file");
//            System.exit(0); // завершение программы
//            return null;
//        }
//
//    }
//
//
//    public Hashtable<Integer, Dragon> readFile(Document document) {
//
//        Hashtable<Integer, Dragon> dragons = new Hashtable<>();
//
//        Node dragonsNode = document.getFirstChild();
//        NodeList dragonsChildren = dragonsNode.getChildNodes();
//
//        for (int i = 0; i < dragonsChildren.getLength(); i++) {
//
//            if (dragonsChildren.item(i).getNodeType() != Node.ELEMENT_NODE) {
//                continue;
//            } else if (!Objects.equals(dragonsChildren.item(i).getNodeName(), "dragon")) {
//                continue;
//            }
//
//            Long id = null;
//            String name = null;
//            Coordinates coordinates = null;
//            Date creationDate = null;
//            Integer age = null;
//            String description = null; //Поле может быть null
//            Color color = null;
//            DragonCharacter character = null;
//            Person killer = null;
//
//            Node fieldDragonNode = dragonsChildren.item(i);
//            NodeList fieldDragon = fieldDragonNode.getChildNodes();
//
//            for (int j = 0; j < fieldDragon.getLength(); j++) {
//
//                if (fieldDragon.item(j).getNodeType() != Node.ELEMENT_NODE) {
//                    continue;
//                }
//
//                switch (fieldDragon.item(j).getNodeName()) {
//
//                    case "id": {
//                        id = Long.valueOf(fieldDragon.item(j).getTextContent());
//                        break;
//                    }
//
//                    case "name": {
//                        name = fieldDragon.item(j).getTextContent();
//                        break;
//                    }
//
//                    case "coordinates": {
//                        NodeList fieldCoordinates = fieldDragon.item(j).getChildNodes();
//                        Double x = null;
//                        int y = -15;
//                        for (int k = 0; k < fieldCoordinates.getLength(); k++) {
//                            if (fieldCoordinates.item(k).getNodeType() != Node.ELEMENT_NODE) {
//                                continue;
//                            }
//                            switch (fieldCoordinates.item(k).getNodeName()) {
//                                case "x": {
//                                    x = Double.valueOf(fieldCoordinates.item(k).getTextContent());
//                                    break;
//                                }
//                                case "y": {
//                                    y = Integer.parseInt(fieldCoordinates.item(k).getTextContent());
//                                    break;
//                                }
//                            }
//                        }
//                        coordinates = new Coordinates(x, y);
//                        break;
//                    }
//
//                    case "date": {
//                        //Fri Mar 18 04:58:31 MSK 2005
//                        char[] chArray = fieldDragon.item(j).getTextContent().toCharArray();
//                        int year = Integer.parseInt(new String(chArray, 24, 4));
//                        int day = Integer.parseInt(new String(chArray, 8, 2));
//                        int hour = Integer.parseInt(new String(chArray, 11, 2));
//                        int min = Integer.parseInt(new String(chArray, 14, 2));
//                        int sec = Integer.parseInt(new String(chArray, 17, 2));
//                        int month = 0;
//                        String monthStr = new String(chArray, 4, 3);
//                        switch (monthStr) {
//                            case "Jan": {
//                                month = 1;
//                                break;
//                            }
//                            case "Feb": {
//                                month = 2;
//                                break;
//                            }
//                            case "Mar": {
//                                month = 3;
//                                break;
//                            }
//                            case "Apr": {
//                                month = 4;
//                                break;
//                            }
//                            case "May": {
//                                month = 5;
//                                break;
//                            }
//                            case "Jun": {
//                                month = 6;
//                                break;
//                            }
//                            case "Jul": {
//                                month = 7;
//                                break;
//                            }
//                            case "Aug": {
//                                month = 8;
//                                break;
//                            }
//                            case "Sep": {
//                                month = 9;
//                                break;
//                            }
//                            case "Oct": {
//                                month = 10;
//                                break;
//                            }
//                            case "Nov": {
//                                month = 11;
//                                break;
//                            }
//                            case "Dec": {
//                                month = 12;
//                                break;
//                            }
//                        }
//                        Calendar calendar = Calendar.getInstance();
//                        calendar.set(year, month, day, hour, min, sec);
//                        creationDate = calendar.getTime();
//                        break;
//                    }
//
//                    case "age": {
//                        age = Integer.valueOf(fieldDragon.item(j).getTextContent());
//                        break;
//
//                    }
//
//                    case "description": {
//                        if (Objects.equals(fieldDragon.item(j).getTextContent(), "null")) {
//                            continue;
//                        }
//                        description = fieldDragon.item(j).getTextContent();
//                        break;
//                    }
//
//                    case "color": {
//                        color = Color.valueOf(fieldDragon.item(j).getTextContent());
//                        break;
//                    }
//
//                    case "character": {
//                        character = DragonCharacter.valueOf(fieldDragon.item(j).getTextContent());
//                        break;
//
//                    }
//
//                    case "killer": {
//                        NodeList fieldKiller = fieldDragon.item(j).getChildNodes();
//                        String nameKiller = null;
//                        LocalDateTime birthday = null;
//                        Long height = null; //Поле может быть null
//                        String passportID = null;
//                        Country nationality = null;
//
//                        for (int k = 0; k < fieldKiller.getLength(); k++) {
//                            if (fieldKiller.item(k).getNodeType() != Node.ELEMENT_NODE) {
//                                continue;
//                            }
//                            switch (fieldKiller.item(k).getNodeName()) {
//                                case "name": {
//                                    nameKiller = fieldKiller.item(k).getTextContent();
//                                    break;
//                                }
//
//                                case "birthday": {
//                                    // LocalDateTime dateTime = LocalDateTime.of(2016, 1, 1, 12, 30, 45);
//                                    //2016-01-01T12:30:45
//                                    char[] chArray = fieldKiller.item(k).getTextContent().toCharArray();
//                                    int year = Integer.parseInt(new String(chArray, 0, 4));
//                                    int month = Integer.parseInt(new String(chArray, 5, 2));
//                                    int day = Integer.parseInt(new String(chArray, 8, 2));
//                                    int hour = Integer.parseInt(new String(chArray, 11, 2));
//                                    int minutes = Integer.parseInt(new String(chArray, 14, 2));
//                                    int seconds = Integer.parseInt(new String(chArray, 17, 2));
//                                    birthday = LocalDateTime.of(year, month, day, hour, minutes, seconds);
//                                    break;
//                                }
//
//                                case "height": {
//                                    height = Long.valueOf(fieldKiller.item(k).getTextContent());
//                                    break;
//                                }
//
//                                case "passport": {
//                                    passportID = fieldKiller.item(k).getTextContent();
//                                    break;
//                                }
//
//                                case "nationality": {
//                                    nationality = Country.valueOf(fieldKiller.item(k).getTextContent());
//                                    break;
//                                }
//                            }
//                        }
//                        killer = new Person(nameKiller, birthday, height, passportID, nationality);
//                        break;
//                    }
//                }
//                Dragon dragon = new Dragon(id, name, coordinates, creationDate, age, description, color, character, killer);
//                assert id != null;
//                Key key = new Key(0);
//                dragons.put(key.getKey(), dragon);
//            }
//        }
//
//        System.out.println("Collection of dragons created");
//        return dragons;
//
//
//}
}
