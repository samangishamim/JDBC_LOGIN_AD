package model;

public class Address {
    private int address_id;
    private String country;
    private String city;
    private  String street;
    private String alley;
    private  int number;
    private int user_id;

    public Address() {
    }

    public Address(int address_id, String country, String city, String street, String alley, int number, int user_id) {
        this.address_id = address_id;
        this.country = country;
        this.city = city;
        this.street = street;
        this.alley = alley;
        this.number = number;
        this.user_id = user_id;
    }

    public Address(String country, String city, String street, String alley, int number, int user_id) {
        this.country = country;
        this.city = city;
        this.street = street;
        this.alley = alley;
        this.number = number;
        this.user_id = user_id;
    }

    public int getAddress_id() {
        return address_id;
    }

    public void setAddress_id(int address_id) {
        this.address_id = address_id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getAlley() {
        return alley;
    }

    public void setAlley(String alley) {
        this.alley = alley;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
}
