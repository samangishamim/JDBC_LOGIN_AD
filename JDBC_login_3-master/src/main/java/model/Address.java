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
}
