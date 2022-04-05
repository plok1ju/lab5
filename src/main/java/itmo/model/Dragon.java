package itmo.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.Objects;

public class Dragon implements Colorable, Ageable, Comparable<Dragon>{
    private Long id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть
    // уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date creationDate; //Поле не может быть null, Значение этого поля должно
    // генерироваться автоматически
    private Integer age; //Значение поля должно быть больше 0, Поле может быть null
    private String description; //Поле может быть null
    private Color color; //Поле не может быть null
    private DragonCharacter character; //Поле не может быть null
    private Person killer; //Поле может быть null

    public Dragon(){}

    public Dragon(Long id, String name, Coordinates coordinates, Date creationDate, Integer age,
                  String description, Color color, DragonCharacter character, Person killer) {
        this.id = id;
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = creationDate;
        this.age = age;
        this.description = description;
        this.color = color;
        this.character = character;
        this.killer = killer;

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {

        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws Exception {
        if (name == null) {
            throw new Exception("Поле name не может быть null!");
        } else if (name.equals("")) {
            throw new Exception("Поле name не может быть пустой строкой!");
        }
        this.name = name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public DragonCharacter getCharacter() {
        return character;
    }

    public void setCharacter(DragonCharacter character) {
        this.character = character;
    }

    public Person getKiller() {
        return killer;
    }

    public void setKiller(Person killer) {
        this.killer = killer;
    }

    @Override
    public String toString() {
        final String s = "Dragon{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", coordinates=" + "(" + coordinates.getX() +
                ", " + coordinates.getY() + ")" +
                ", creationDate=" + creationDate +
                ", age=" + age +
                ", description='" + description + '\'' +
                ", color=" + color.getColor() +
                ", character=" + character.getCharacter() +
                ", killer=" + killer.toString() + '}';
        return s;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dragon dragon = (Dragon) o;
        return Objects.equals(id, dragon.id) && Objects.equals(name, dragon.name) && Objects.equals(coordinates, dragon.coordinates) && Objects.equals(creationDate, dragon.creationDate) && Objects.equals(age, dragon.age) && Objects.equals(description, dragon.description) && color == dragon.color && character == dragon.character && Objects.equals(killer, dragon.killer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, coordinates, creationDate, age, description, color, character, killer);
    }

    @Override
    public int compareTo(Dragon o) {
        return this.id.compareTo(o.id);
    }
}
