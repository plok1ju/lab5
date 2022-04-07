package itmo.model;
/**
 * Класс координат дракона
 */
public class Coordinates {

    /** Поле значения координаты x */
    private Double x; //Поле не может быть null

    /** Поле значения координаты y */
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
    public void setX(Double x) throws Exception {
        if(x == null){
            throw new Exception("Координата х не может быть null");
        }
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
