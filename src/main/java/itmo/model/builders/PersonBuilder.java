package itmo.model.builders;

import itmo.io.Scannable;
import itmo.model.Country;
import itmo.model.Person;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Этот класс создает объект класса Person
 */
public class PersonBuilder {

    private final Person person;
    private final boolean isConsole;


    public PersonBuilder(boolean isConsole) {
        person = new Person();
        this.isConsole = isConsole;
    }

    public Person build(Scannable scannable) throws Exception {
        this.buildName(scannable);
        this.buildBirthday(scannable);
        this.buildHeight(scannable);
        this.buildPassportID(scannable);
        this.buildNationality(scannable);

        return this.person;
    }

    private void buildName(Scannable scannable) throws Exception {
        if (isConsole) {
            try {
                System.out.println("Введите имя человека: ");
                String nameKiller = scannable.scanString();
                person.setName(nameKiller);
            } catch (Exception e) {
                System.out.println("Что-то пошло не так: " + e.getMessage());
                this.buildName(scannable);
            }

        } else {
            String name = scannable.scanString();
            if (name.equals("")) {
                throw new Exception("Поле name не может быть null! Исправьте файлик!");
            }
            person.setName(name);

        }
    }

    private void buildBirthday(Scannable scannable) throws Exception {
        if (isConsole) {
            try {
                System.out.println("Введите дату рождения в формате yyyy-MM-dd HH:mm: ");
                LocalDateTime birthday = LocalDateTime.parse(scannable.scanString(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
                person.setBirthday(birthday);
            } catch (Exception e) {
                System.out.println("Что-то пошло не так: " + e.getMessage());
                this.buildBirthday(scannable);
            }
        } else {
            LocalDateTime birthday = LocalDateTime.parse(scannable.scanString(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
            person.setBirthday(birthday);
        }
    }

    private void buildHeight(Scannable scannable) throws Exception {
        if (isConsole) {
            try {
                System.out.println("Введите рост человека:");
                String heightString = scannable.scanString();
                Long height;
                if (!heightString.equals("")) {
                    height = Long.parseLong(heightString);
                } else {
                    height = null;
                }
                person.setHeight(height);

            } catch (Exception e) {
                System.out.println("Что-то пошло не так: " + e.getMessage());
                this.buildHeight(scannable);
            }
        } else {
            String heightString = scannable.scanString();
            Long height;
            if (!heightString.equals("")) {
                height = Long.parseLong(heightString);
            } else {
                height = null;
            }
            person.setHeight(height);
        }
    }

    private void buildPassportID(Scannable scannable) throws Exception {
        if (isConsole) {
            try {
                System.out.println("Введите ID паспорта: ");
                String passportId = scannable.scanString();

                person.setPassportID(passportId);
            } catch (Exception e) {
                System.out.println("Что-то пошло не так: " + e.getMessage());
                this.buildPassportID(scannable);
            }

        } else {
            String passportId = scannable.scanString();
            person.setPassportID(passportId);

        }
    }

    private void buildNationality(Scannable scannable) throws Exception {
        if (isConsole) {
            try {
                System.out.println("Выберете одну из предложенных национальностей");
                System.out.println(Country.getValues());
                Country nationality = Country.parse(scannable.scanString());
                person.setNationality(nationality);
            } catch (Exception e) {
                System.out.println("Что-то пошло не так: " + e.getMessage());
                this.buildNationality(scannable);
            }
        } else {
            Country nationality = Country.parse(scannable.scanString());
            person.setNationality(nationality);
        }
    }

}
