package itmo.model;
/**
 * Enum с наполнением возможных характеров драконов
 */
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

    /**
     * Получение элементов enum
     * @return - строка со значениями
     */
    public static String getValues() {
        DragonCharacter[] charactersArray = DragonCharacter.values();
        StringBuilder stringBuilder = new StringBuilder();
        for(DragonCharacter character : charactersArray){
            stringBuilder.append(character).append(", ");
        }
        return stringBuilder.toString();

    }
}
