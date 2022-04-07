package itmo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;
import java.util.Objects;

public class Dragon implements Colorable, Ageable, Comparable<Dragon>{

    /**
     * Описание полей класса
     */
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

    /**
     * Пустой конструктор класса Dragon
    */
    public Dragon(){}

    /**
     * Конструктор класса Dragon
     * @param id - значение поля id
     * @param name - значение поля name
     * @param coordinates - значение поля coordinates
     * @param creationDate - значение поля creationDate
     * @param age - значение поля age
     * @param description - значение поля description
     * @param color - значение поля color
     * @param character - значение поля character
     * @param killer - значение поля killer
     */
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

    /**
     * Получение id
     * @return - значение поля id
     */
    public Long getId() {
        return id;
    }

    /**
     * Установка id
     * @param id - значение поля id
     */
    public void setId(Long id) {

        this.id = id;
    }

    /**
     * Получение имени
     * @return - значение поля name
     */
    public String getName() {
        return name;
    }

    /**
     * Установка нового имени
     * @param name - значение поля name
     */
    public void setName(String name) throws Exception {
        if (name == null) {
            throw new Exception("Поле name не может быть null!");
        } else if (name.equals("")) {
            throw new Exception("Поле name не может быть пустой строкой!");
        }
        this.name = name;
    }

    /**
     * Получение координат
     * @return - значение поля coordinates
     */
    public Coordinates getCoordinates() {
        return coordinates;
    }

    /**
     * Установка новых координат
     * @param coordinates  - значение поля coordinates
     */
    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    /**
     * Получение даты
     * @return - значение поля creationDate
     */
    public Date getCreationDate() {
        return creationDate;
    }

    /**
     * Добавление новой даты создания
     * @param creationDate  - значение поля creationDate
     */
    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    /**
     * Переопределение метода getAge
     * @return - значение поля age
     */
    @Override
    public Integer getAge() {
        return age;
    }

    /**
     * Добавление нового возраста дракона
     * @param age  - значение поля age
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * Получение описания дракона
     * @return - значение поля description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Добавление нового описания дракона
     * @param description  - значение поля description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Переопределение метода getColor
     * @return - значение поля color
     */
    @Override
    public Color getColor() {
        return color;
    }

    /**
     * Добавление нового цвета дракона
     * @param color  - значение поля color
     */
    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * Получение характера
     * @return - значение поля character
     */
    public DragonCharacter getCharacter() {
        return character;
    }

    /**
     * Добавление нового характера дракона
     * @param character  - значение поля character
     */
    public void setCharacter(DragonCharacter character) {
        this.character = character;
    }

    /**
     * Получение убийцы дракона
     * @return - значение поля killer
     */
    public Person getKiller() {
        return killer;
    }

    /**
     * Добавление нового убийцы
     * @param killer  - значение поля killer
     */
    public void setKiller(Person killer) {
        this.killer = killer;
    }

    /**
     * Переопределение метода toString
     * @return - значения всех полей класса Dragon
     */
    @Override
    public String toString() {
        return "id: " + id + "\n" +
                "name: " + name + "\n" +
                "coordinates: " + coordinates.toString() + "\n" +
                "creationDate: " + creationDate + "\n" +
                "age: " + age + "\n" +
                "description: " + description + "\n" +
                "color: " + color + "\n" +
                "character: " + character + "\n" +
                "killer: \n" + killer;
    }

    /**
     * Переопределение метода equals
     * @return - одинаковые объекты или нет
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dragon dragon = (Dragon) o;
        return Objects.equals(id, dragon.id) && Objects.equals(name, dragon.name) && Objects.equals(coordinates, dragon.coordinates) && Objects.equals(creationDate, dragon.creationDate) && Objects.equals(age, dragon.age) && Objects.equals(description, dragon.description) && color == dragon.color && character == dragon.character && Objects.equals(killer, dragon.killer);
    }

    /**
     * Переопределение метода equals
     * @return - число типа int
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, name, coordinates, creationDate, age, description, color, character, killer);
    }

    /**
     * Переопределение метода equals
     * @return - одинаковые ли два дракона или нет
     */
    @Override
    public int compareTo(Dragon o) {
        return this.id.compareTo(o.id);
    }
}
