package model;

public enum DragonCharacter {
    WISE("Wise"),
    GOOD("Good"),
    FICKLE("Fickle");

    private final String character;

    DragonCharacter(String character) {
        this.character = character;
    }


    public String getCharacter() {
        return character;
    }
}
