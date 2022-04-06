package itmo.model;


import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public class Person {

    /**
     * Описание полей класса
     */
    private String name; //Поле не может быть null, Строка не может быть пустой
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime birthday; //Поле не может быть null
    private Long height; //Поле может быть null, Значение поля должно быть больше 0
    private String passportID; //Значение этого поля должно быть уникальным, Строка не может быть пустой, Поле не может быть null
    private Country nationality; //Поле не может быть null

    /**
     * Пустой конструктор класса Person
     */
    public Person(){}

    /**
     * Конструктор класса Person
     * @param name - значение поля name
     * @param birthday - значение поля birthday
     * @param height - значение поля height
     * @param passportID - значение поля passportID
     * @param nationality - значение поля nationality
     */
    public Person(String name, LocalDateTime birthday, Long height, String passportID, Country nationality) {
        this.name = name;
        this.birthday = birthday;
        this.height = height;
        this.passportID = passportID;
        this.nationality = nationality;
    }

    /**
     * Получение passportID
     * @return - значение поля passportID
     */
    public String getPassportID() {
        return passportID;
    }

    public void setPassportID(String passportID) {
        this.passportID = passportID;
    }

    /**
     * Получение height
     * @return - значение поля height
     */
    public Long getHeight() {
        return height;
    }

    /**
     * Установка height
     * @param height - значение поля height
     */
    public void setHeight(Long height) {
        this.height = height;
    }

    /**
     * Получение nationality
     * @return - значение поля nationality
     */
    public Country getNationality() {
        return nationality;
    }

    /**
     * Установка nationality
     * @param nationality - значение поля nationality
     */
    public void setNationality(Country nationality) {
        this.nationality = nationality;
    }

    /**
     * Получение birthday
     * @return - значение поля birthday
     */
    public LocalDateTime getBirthday() {
        return birthday;
    }

    /**
     * Установка birthday
     * @param birthday - значение поля birthday
     */
    public void setBirthday(LocalDateTime birthday) {
        this.birthday = birthday;
    }

    /**
     * Получение name
     * @return - значение поля name
     */
    public String getName() {
        return name;
    }

    /**
     * Установка name
     * @param name - значение поля name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Переопределение метода toString
     * @return - значения всех полей класса Person
     */
    @Override
    public String toString() {
        final String s = "Person{" +
                "name='" + name + '\'' +
                ", birthday=" + birthday +
                ", height=" + height +
                ", passportID='" + passportID + '\'' +
                ", nationality=" + nationality.getCountry() +
                '}';
        return s;
    }

}