package commands;

import model.Dragon;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Hashtable;

public class Info {

    public void infoAboutCollection(Hashtable<Integer, Dragon> dragons){
        System.out.println("Collection type is: " + dragons.getClass());
        LocalDate date = LocalDate.now(); // Gets the current date
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        System.out.println("Date of creating collection is: " + date.format(formatter));
        System.out.println("Amount of elements: " + dragons.size());

    }
}
