package model;

public class Coordinates {
    private Double x; //Поле не может быть null
    private int y; //Значение поля должно быть больше -16

    public Coordinates(Double x, int y) {
        this.x = x;
        this.y = y;
    }


    public Double getX() {
        return x;
    }

    public void setX(Double x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
