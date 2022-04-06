package itmo.model;

import java.util.Arrays;

public enum DragonCharacter {
    WISE("Wise"),
    GOOD("Good"),
    FICKLE("Fickle");

    /**
     * Поле класса
     */
    private final String character;

    /**
     * Конструктор характера
     * @param character - значение поля character
     */
    DragonCharacter(String character) {
        this.character = character;
    }

    /**
     * Получение характера
     * @return - характер дракона
     */
    public String getCharacter() {
        return character;
    }


    public String getValues() {
        String countries = Arrays.toString(DragonCharacter.values());
        return countries.replace("[", "").replace("]", "");
    }
}
