package be.voedsaam.business;

public class Address {
    private String street;
    private Integer number;
    private Integer postalCode;
    private String city;
    private String country;

    public Address() {
    }

    public Address(String street, Integer number, Integer postalCode, String city) {
        this();
        this.street = street;
        this.number = number;
        this.postalCode = postalCode;
        this.city = city;
        this.country = "Belgium";
    }

    public Address(String street, Integer number, Integer postalCode, String city, String country) {
        this(street, number, postalCode, city);
        this.country = country;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(Integer postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
