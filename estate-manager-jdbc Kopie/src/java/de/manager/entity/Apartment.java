package de.manager.entity;

public class Apartment {

    private int id;

    // estate specific attributes
    private int estateAgentId;
    private String city;
    private String postalCode;
    private String street;
    private String number;
    private String squareArea;

    // apartment specific attributes
    private int floor;
    private double rent;
    private int room;
    private int balcony;
    private int kitchen;

    public Apartment(int estateAgentId, String city, String postalCode, String street, String number, String squareArea, int floor, double rent, int room, int balcony, int kitchen) {
        this.estateAgentId = estateAgentId;
        this.city = city;
        this.postalCode = postalCode;
        this.street = street;
        this.number = number;
        this.squareArea = squareArea;
        this.floor = floor;
        this.rent = rent;
        this.room = room;
        this.balcony = balcony;
        this.kitchen = kitchen;
    }

    public Apartment() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEstateAgentId() {
        return estateAgentId;
    }

    public void setEstateAgentId(int estateAgentId) {
        this.estateAgentId = estateAgentId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getSquareArea() {
        return squareArea;
    }

    public void setSquareArea(String squareArea) {
        this.squareArea = squareArea;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public double getRent() {
        return rent;
    }

    public void setRent(double rent) {
        this.rent = rent;
    }

    public int getRoom() {
        return room;
    }

    public void setRoom(int room) {
        this.room = room;
    }

    public int getBalcony() {
        return balcony;
    }

    public void setBalcony(int balcony) {
        this.balcony = balcony;
    }

    public int getKitchen() {
        return kitchen;
    }

    public void setKitchen(int kitchen) {
        this.kitchen = kitchen;
    }

    @Override
    public String toString() {
        return "Apartment{" +
                "id=" + id +
                ", estateAgentId=" + estateAgentId +
                ", city='" + city + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", street='" + street + '\'' +
                ", number='" + number + '\'' +
                ", squareArea='" + squareArea + '\'' +
                ", floor=" + floor +
                ", rent=" + rent +
                ", room=" + room +
                ", balcony=" + balcony +
                ", kitchen=" + kitchen +
                '}';
    }
}
