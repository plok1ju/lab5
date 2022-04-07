package itmo.model;

import java.util.Locale;

/**
 * Enum с наполнением возможных характеров драконов
 */
public enum DragonCharacter {
    WISE,
    GOOD,
    FICKLE;

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

    public static DragonCharacter parse(String characterString){
        return valueOf(characterString.toUpperCase(Locale.ROOT).trim());
    }
}
