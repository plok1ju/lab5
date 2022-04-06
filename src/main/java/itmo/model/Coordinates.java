package itmo.model;

public class Coordinates {

    /**
     * Описание полей класса
     */
    private Double x; //Поле не может быть null
    private int y; //Значение поля должно быть больше -16

    /**
     * Пустой конструктор класса Coordinates
     */
    public Coordinates(){}

    /**
     * Конструктор класса Coordinates
     * @param x - значение поля x
     * @param y - значение поля y
     */
    public Coordinates(Double x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Получение x
     * @return - значение поля x
     */
    public Double getX() {
        return x;
    }

    /**
     * Добавление координаты x
     * @param x - значение поля x
     */
    public void setX(Double x) {
        this.x = x;
    }

    /**
     * Получение y
     * @return - значение поля y
     */
    public int getY() {
        return y;
    }

    /**
     * Добавление координаты y
     * @param y - значение поля y
     */
    public void setY(int y) {
        this.y = y;
    }
}
