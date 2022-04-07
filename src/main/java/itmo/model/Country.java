package itmo.model;

import java.util.Locale;

public enum Country{
    GERMANY,
    CHINA,
    ITALY;

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
