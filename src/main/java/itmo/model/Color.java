package itmo.model;
/**
 * Enum с наполнением возможного цвета дракона
 */
public enum Color{
    BLUE("Blue"),
    YELLOW("Yellow"),
    ORANGE("Orange"),
    WHITE("White");

    /**
     * Поле класса
     */
    private String color;

    /**
     * Конструктор цвета
     * @param color - значение поля color
     */
    Color(String color) {
        this.color = color;
    }

    /**
     * Получение цвета
     * @return - цвет дракона
     */
    public String getColor() {
        return color;
    }

    /**
     * Установка цвета
     */
    public void setColor() {
        this.color = color;
    }

    /**
     * Получение элементов enum
     * @return - строка со значениями
     */
    public static String getValues() {
        Color[] colorsArray = Color.values();
        StringBuilder stringBuilder = new StringBuilder();
        for(Color color : colorsArray){
            stringBuilder.append(color).append(", ");
        }
        return stringBuilder.toString();

    }
}
