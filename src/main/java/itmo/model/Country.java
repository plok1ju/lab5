package itmo.model;

import java.util.Locale;

/**
 * Enum с наполнением возможной национальности
 */
public enum Country{
    GERMANY,
    CHINA,
    ITALY;

    /**
     * Получение элементов enum
     * @return - строка со значениями
     */
    public static String getValues() {
        Country[] countriesArray = Country.values();
        StringBuilder stringBuilder = new StringBuilder();
        for(Country country : countriesArray){
            stringBuilder.append(country).append(", ");
        }
        return stringBuilder.toString();

    }

    public static Country parse(String countryString){
        return valueOf(countryString.toUpperCase(Locale.ROOT).trim());
    }
}
