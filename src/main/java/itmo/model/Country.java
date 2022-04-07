package itmo.model;

public enum Country{
    GERMANY("Germany"),
    CHINA("China"),
    ITALY("Italy");

    /**
     * Поле класса
     */
    private final String country;

    /**
     * Конструктор страны
     * @param country - значение поля country
     */
    Country(String country){
        this.country = country;
    }

    /**
     * Получение значения страны
     * @return - страна
     */
    public String getCountry(){
        return country;
    }

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


}
