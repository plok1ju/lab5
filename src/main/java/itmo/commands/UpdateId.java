package itmo.commands;

import itmo.model.*;

import java.time.LocalDateTime;
import java.util.*;

public class UpdateId {

    public Hashtable<Integer, Dragon> updateElement(Hashtable<Integer, Dragon> dragons) {

        Scanner scanner1 = new Scanner(System.in);
        System.out.print("Please, enter ID of dragon to update values: ");
        Long readID = scanner1.nextLong();
        Dragon dragon = null;
        Integer k = 0;
        Enumeration<Integer> enumeration = dragons.keys();
        while (enumeration.hasMoreElements()) {
            Integer presentKey = enumeration.nextElement();
            Dragon d = dragons.get(presentKey);
            if (readID.equals(d.getId())) {
                dragon = dragons.get(presentKey);
                k = presentKey;
                break;
            }
        }
        dragons.remove(k);

        String nameDragon;
        Coordinates coordinates;
        Double x;
        int y;
        Date creationDate;
        Integer age;
        String description;
        Color color;
        DragonCharacter character;

        String nameKiller;
        LocalDateTime birthday;
        Long height;
        String passportID;
        Country nationality;
        boolean flag = true;
        while (flag){
        System.out.println("If you don't want change some fields, just press enter.");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter new name for Dragon: ");
        nameDragon = scanner.nextLine();
        if (Objects.equals(nameDragon, "")) {
            assert dragon != null;
            nameDragon = dragon.getName();
            System.out.println("Name " + nameDragon + " don't update");
        } else {
            System.out.println("Name " + nameDragon + " is save");
        }

        System.out.print("Enter new x coordinate for Dragon: ");
        String helper;
        helper = scanner.nextLine();
        if (Objects.equals(helper, "")) {
            x = dragon.getCoordinates().getX();
            System.out.println("Coordinate x " + x + " don't update");
        } else {
            x = Double.parseDouble(helper);
            System.out.println("Coordinate x " + x + " is save");
        }

        System.out.print("Enter new y coordinate for Dragon: ");
        String helper1;
        helper1 = scanner.nextLine();
        if (Objects.equals(helper1, "")) {
            y = dragon.getCoordinates().getY();
            System.out.println("Coordinate y " + y + " don't update");
        } else {
            y = Integer.parseInt(helper1);
            System.out.println("Coordinate y " + y + " is save");
        }

        coordinates = new Coordinates(x,y);

        System.out.print("Field of date are generated. Do a new date? Answer 'yes' or 'no': ");
        String answer = scanner.nextLine();
        if(Objects.equals(answer, "yes")) {
            creationDate = new Date();
            System.out.println("New create data is: " + creationDate);

        }
        else {
            creationDate = dragon.getCreationDate();
            System.out.println("Create data is: " + creationDate);

        }

        System.out.print("Enter new age for Dragon: ");
        String helper2;
        helper2 = scanner.nextLine();
        if (Objects.equals(helper2, "")) {
            age = dragon.getAge();
            System.out.println("Age " + age + " don't update");
        } else {
            age = Integer.parseInt(helper2);
            System.out.println("Age " + age + " is save");
        }

        System.out.print("Enter new description for Dragon: ");
        description = scanner.nextLine();
        if (Objects.equals(description, "")) {
            description = dragon.getDescription();
            System.out.println("Description '" + description + "' don't update");
        } else {
            System.out.println("Description ' " + description + "' is save");
        }

        System.out.println("Choose one of them: 'WHITE', 'ORANGE', 'BLUE', 'YELLOW'. ");
        System.out.print("Enter new color for Dragon: ");
        String helper3;
        helper3 = scanner.nextLine();
        if (Objects.equals(helper3, "")) {
            color = dragon.getColor();
            System.out.println("Colour " + color + " don't update");
        } else {
            color = Color.valueOf(helper3);
            System.out.println("New colour " + color + " is save");
        }

        System.out.println("Choose one of them: 'WISE', 'GOOD', 'FICKLE'. ");
        System.out.print("Enter new character for Dragon: ");
        String helper4;
        helper4 = scanner.nextLine();
        if (Objects.equals(helper4, "")) {
            character = dragon.getCharacter();
            System.out.println("Character " + character + " don't update");
        } else {
            character = DragonCharacter.valueOf(helper4);
            System.out.println("New character" + character + " is save");
        }

        System.out.print("Enter new name for killer: ");
        nameKiller = scanner.nextLine();
        if (Objects.equals(nameKiller, "")) {
            nameKiller = dragon.getKiller().getName();
            System.out.println("Name " + nameKiller + " don't update");
        } else {
            System.out.println("Name " + nameKiller + " is save");
        }

        System.out.print("Do you want change birthday of killer? Answer 'yes' or 'no': ");
        String answer1 = scanner.nextLine();
        switch (answer1){
            case "yes" :{
                System.out.print("Enter date of birthday in format DD.MM.YYYY: ");
                String dateBirthday = scanner.nextLine();
                System.out.print("Enter time of birthday in format HH.MM.SS: ");
                String timeBirthday = scanner.nextLine();
                char[] chDate = dateBirthday.toCharArray();
                char[] chTime = timeBirthday.toCharArray();
                int year = Integer.parseInt(new String(chDate, 6, 4));
                int month = Integer.parseInt(new String(chDate, 3, 2));
                int day = Integer.parseInt(new String(chDate, 0, 2));
                int hour = Integer.parseInt(new String(chTime, 0, 2));
                int minutes = Integer.parseInt(new String(chTime, 3, 2));
                int seconds = Integer.parseInt(new String(chTime, 6, 2));
                birthday = LocalDateTime.of(year, month, day, hour, minutes, seconds);
                System.out.println("New data and time of birthday killer: " + birthday + " is save");
                break;

            }

            case "no" :{
                birthday = dragon.getKiller().getBirthday();
                System.out.println("Data and time of birthday killer: " + birthday + " don't update");
                break;
            }
            default:
                throw new IllegalStateException("Unexpected value: " + answer1);
        }

        System.out.print("Enter new height of killer: ");
        String helper5;
        helper5 = scanner.nextLine();
        if (Objects.equals(helper5, "")) {
            height = dragon.getKiller().getHeight();
            System.out.println("Height " + height + " don't update");
        } else {
            height = Long.parseLong(helper5);
            System.out.println("New height " + height + " is save");
        }

        System.out.print("Enter new killer passport ID: ");
        passportID = scanner.nextLine();
        if (Objects.equals(passportID, "")) {
            passportID = dragon.getKiller().getPassportID();
            System.out.println("Passport ID " + passportID + " don't update");
        } else {
            System.out.println("New Passport ID " + passportID + " is save");
        }

        System.out.println("Choose one of them: 'GERMANY', 'ITALY', 'CHINA'. ");
        System.out.print("Enter new killer nationality: ");
        String helper6;
        helper6 = scanner.nextLine();
        if (Objects.equals(helper6, "")) {
            nationality = dragon.getKiller().getNationality();
            System.out.println("Nationality " + nationality.getCountry() + " don't update");
        } else {
            nationality = Country.valueOf(helper6);
            System.out.println("New nationality " + nationality.getCountry() + " is save");
        }

        Person person = new Person(nameKiller, birthday,height,passportID,nationality);
        Dragon dragon1 = new Dragon(readID, nameDragon, coordinates, creationDate, age,description, color, character, person);

        System.out.println(dragon1.toString());
        System.out.print("Are new data right? Answer 'yes' or 'no': ");
        String answer2 = scanner.nextLine();
        switch (answer2){
            case "yes" :{
                 dragons.put(k, dragon1);
                 flag = false;
                 break;
            }

            case "no" :{
                System.out.print("Do new updating? Answer 'yes' or 'no': ");
                String answer3 = scanner.nextLine();
                switch (answer3){
                    case "yes" :{
                        flag = true;
                        break;
                    }

                    case "no" :{
                        dragons.put(k, dragon);
                        break;
                    }
                }
            }
        }
    }
    return dragons;
    }
}
