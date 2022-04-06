package itmo.model;

public enum Country {
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


}
