package model;

public enum Country {
    GERMANY("Germany"),
    CHINA("China"),
    ITALY("Italy");

    private String country;

    Country(String country){
        this.country = country;
    }

    public String getCountry(){
        return country;
    }


}
