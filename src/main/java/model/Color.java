package model;

public enum Color {
    BLUE("Blue"),
    YELLOW("Yellow"),
    ORANGE("Orange"),
    WHITE("White");

    private String color;

    Color(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor() {
        this.color = color;
    }

}
