package itmo.model.builders;

import itmo.io.Scannable;
import itmo.manager.IdGenerator;
import itmo.model.Color;
import itmo.model.Dragon;
import itmo.model.DragonCharacter;

import java.io.IOException;
import java.util.Date;
import java.util.Locale;

/**
 * Этот класс создает объект класса Dragon
 */
public class DragonBuilder {

    private final Dragon dragon;
    private final boolean isConsole;

    public DragonBuilder(boolean isConsole) {
        this.isConsole = isConsole;
        dragon = new Dragon();
    }

    public Dragon build(Scannable scannable) throws Exception {
        this.buildId();
        this.buildName(scannable);
        this.buildAge(scannable);
        this.buildCoordinates(scannable);
        this.setCreationDate();
        this.buildDescription(scannable);
        this.buildColor(scannable);
        this.buildCharacter(scannable);
        this.buildPerson(scannable);

        return this.dragon;

    }

    private void buildId() throws Exception {
        dragon.setId(IdGenerator.getId());
    }

    private void buildName(Scannable scannable) throws Exception {
        if (isConsole) {
            try {
                System.out.println("Введите имя дракона:");
                String nameDragon = scannable.scanString();
                dragon.setName(nameDragon);

            } catch (Exception e) {
                System.out.println("Что-то пошло не так: " + e.getMessage());
                this.buildName(scannable);
            }
        } else {
            String nameDragon = scannable.scanString();
            dragon.setName(nameDragon);
        }
    }

    private void buildAge(Scannable scannable) throws Exception {
        if (isConsole) {
            try {
                System.out.println("Введите возраст дракона:");
                String ageString = scannable.scanString();
                Integer age;
                if (ageString.equals("")) {
                    age = null;
                } else {
                    age = Integer.parseInt(ageString);
                }
                dragon.setAge(age);
            } catch (Exception e) {
                System.out.println("Что-то пошло не так: " + e.getMessage());
                this.buildAge(scannable);

            }
        } else {
            String ageString = scannable.scanString();
            Integer age;
            if (ageString.equals("")) {
                age = null;
            } else {
                age = Integer.parseInt(ageString);
            }
            dragon.setAge(age);
        }
    }

    private void buildDescription(Scannable scannable) throws IOException {
        if (isConsole) {
            try {
                System.out.println("Введите описание дракона:");
                String description = scannable.scanString();
                if (description.equals("")) {
                    description = null;
                }
                dragon.setDescription(description);

            } catch (Exception e) {
                System.out.println("Что-то пошло не так: " + e.getMessage());
                this.buildDescription(scannable);

            }
        } else {
            String description = scannable.scanString();
            if (description.equals("")) {
                description = null;
            }
            dragon.setDescription(description);
        }
    }

    private void buildColor(Scannable scannable) throws Exception {
        if (isConsole) {
            try {
                System.out.println("Выберете одно из предложенных значений цвета для дракона");
                System.out.println(Color.getValues());
                Color color = Color.parse(scannable.scanString());
                dragon.setColor(color);
            } catch (Exception e) {
                System.out.println("Что-то пошло не так: " + e.getMessage());
                this.buildColor(scannable);
            }
        } else {
            Color color = Color.parse(scannable.scanString());
            dragon.setColor(color);
        }
    }

    private void buildCharacter(Scannable scannable) throws Exception {
        if (isConsole) {
            try {
                System.out.println("Выберете одно из предложенных значений характера дракона");
                System.out.println(DragonCharacter.getValues());
                DragonCharacter character = DragonCharacter.parse(scannable.scanString());
                dragon.setCharacter(character);
            } catch (Exception e) {
                System.out.println("Что-то пошло не так: " + e.getMessage());
                this.buildCharacter(scannable);
            }
        } else {
            DragonCharacter character = DragonCharacter.parse(scannable.scanString());
            dragon.setCharacter(character);
        }
    }

    private void buildCoordinates(Scannable scannable) throws Exception {
        CoordinatesBuilder coordinatesBuilder = new CoordinatesBuilder(isConsole);
        dragon.setCoordinates(coordinatesBuilder.build(scannable));

    }

    private void setCreationDate() throws Exception {
        Date date = new Date();
        dragon.setCreationDate(date);

    }

    private void buildPerson(Scannable scannable) throws Exception {
        if (isConsole) {
            System.out.println("Задать значение убийцы дракона? Введите 'yes' или 'no'");
            String answer = scannable.scanString().toUpperCase(Locale.ROOT);
            if (answer.contains("YES")) {
                PersonBuilder personBuilder = new PersonBuilder(isConsole);
                dragon.setKiller(personBuilder.build(scannable));
                return;
            }
            if (answer.contains("NO")) {
                dragon.setKiller(null);
                return;
            }
            this.buildPerson(scannable);

        } else {
            try {
                PersonBuilder personBuilder = new PersonBuilder(isConsole);
                dragon.setKiller(personBuilder.build(scannable));
            } catch (Exception e) {
                dragon.setKiller(null);
            }
        }
    }


}
