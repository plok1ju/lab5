package itmo.model.builders;

import itmo.io.Scannable;
import itmo.model.Color;
import itmo.model.Dragon;
import itmo.model.DragonCharacter;

import java.util.Date;
import java.util.Locale;

/**
 * Этот класс создает объект класса Dragon
 */
public class DragonBuilder {

    private Dragon dragon;
    private boolean isConsole;

    public DragonBuilder(boolean isConsole) {
        this.isConsole = isConsole;
        dragon = new Dragon();
    }

    public Dragon build(Scannable scannable) throws Exception {
        this.buildName(scannable);
        this.buildCoordinates(scannable);
        this.setCreationDate();
        this.buildPerson(scannable);
        this.buildAge(scannable);
        this.buildDescription(scannable);
        this.buildColor(scannable);
        this.buildCharacter(scannable);

        return this.dragon;

    }

    private void buildName(Scannable scannable) throws Exception {
        if(isConsole){
            try {
                System.out.println("Введите имя:");
                String nameDragon = scannable.scanString();
                dragon.setName(nameDragon);

            }
            catch (Exception e){
                System.out.println("Что-то пошло не так: " + e.getMessage());
                this.buildName(scannable);
            }
        }
        else {
            String nameDragon = scannable.scanString();
            dragon.setName(nameDragon);
        }
    }

    private void buildAge(Scannable scannable) {
        if(isConsole){
            try{
                System.out.println("Введите возраст:");
                String ageString = scannable.scanString();
                Integer age;
                if (ageString.equals("")){
                    age = null;
                }
                else {
                    age = Integer.parseInt(ageString);
                }
                dragon.setAge(age);
            }
            catch (Exception e){
                System.out.println("Что-то пошло не так: " + e.getMessage());
                this.buildAge(scannable);

            }
        }
        else {
            String ageString = scannable.scanString();
            Integer age;
            if (ageString.equals("")){
                age = null;
            }
            else {
                age = Integer.parseInt(ageString);
            }
            dragon.setAge(age);
        }
    }

    private void buildDescription(Scannable scannable){
        if(isConsole){
            try{
                System.out.println("Введите описание дракона:");
                String description = scannable.scanString();
                if(description.equals("")){
                    description = null;
                }
                dragon.setDescription(description);

            }
            catch (Exception e){
                System.out.println("Что-то пошло не так: " + e.getMessage());
                this.buildDescription(scannable);

            }
        }
        else{
            String description = scannable.scanString();
            if(description.equals("")){
                description = null;
            }
            dragon.setDescription(description);
        }
    }

    private void buildColor(Scannable scannable) throws Exception {
        if(isConsole){
            try{
                System.out.println("Выберете одно из предложенных значений цвета");
                System.out.println(Color.getValues());
                Color color = Color.parse(scannable.scanString());
                dragon.setColor(color);
            }
            catch (Exception e){
                System.out.println("Что-то пошло не так: " + e.getMessage());
                this.buildColor(scannable);
            }
        }
        else {
            Color color = Color.parse(scannable.scanString());
            dragon.setColor(color);
        }
    }

    private void buildCharacter(Scannable scannable){
        if(isConsole){
            try{
                System.out.println("Выберете одно из предложенных значений характера");
                System.out.println(DragonCharacter.getValues());
                DragonCharacter character = DragonCharacter.parse(scannable.scanString());
                dragon.setCharacter(character);
            }
            catch (Exception e){
                System.out.println("Что-то пошло не так: " + e.getMessage());
                this.buildCharacter(scannable);
            }
        }
        else {
            DragonCharacter character = DragonCharacter.parse(scannable.scanString());
            dragon.setCharacter(character);
        }
    }

    private void buildCoordinates(Scannable scannable) throws Exception {
        CoordinatesBuilder coordinatesBuilder = new CoordinatesBuilder(isConsole);
        dragon.setCoordinates(coordinatesBuilder.build(scannable));

    }

    private void setCreationDate(){
        Date date = new Date();
        dragon.setCreationDate(date);

    }

    private void buildPerson(Scannable scannable) throws Exception {
        if(isConsole){
            System.out.println("Задать значение убийцы дракона? Введите 'да' или 'нет'");
            String answer = scannable.scanString().toUpperCase(Locale.ROOT);
            if(answer.contains("ДА")){
                PersonBuilder personBuilder = new PersonBuilder(isConsole);
                dragon.setKiller(personBuilder.build(scannable));
                return;
            }
            if (answer.contains("НЕТ")){
                dragon.setKiller(null);
                return;
            }
            this.buildPerson(scannable);

        }
        else {
            try{
                PersonBuilder personBuilder = new PersonBuilder(isConsole);
                dragon.setKiller(personBuilder.build(scannable));
            }
            catch (Exception e){
                dragon.setKiller(null);
            }
        }
    }




}
