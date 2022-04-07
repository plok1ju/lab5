package itmo.model;

import java.util.Locale;

public enum DragonCharacter {
    WISE,
    GOOD,
    FICKLE;

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
