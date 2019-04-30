package de.manager.entity;

import java.sql.Date;

public class PurchaseContract {

    private int id;

    private String contractNumber;
    private Date date;
    private String place;

    private int personID;
    private int houseID;
    private int noOfInstallments;
    private int intrestRate;

    public PurchaseContract(int id, String contractNumber, Date date, String place, int personID, int houseID, int noOfInstallments, int intrestRate) {
        this.id = id;
        this.contractNumber = contractNumber;
        this.date = date;
        this.place = place;
        this.personID = personID;
        this.houseID = houseID;
        this.noOfInstallments = noOfInstallments;
        this.intrestRate = intrestRate;
    }

    public PurchaseContract() {}


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(String contractNumber) {
        this.contractNumber = contractNumber;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public int getPersonID() {
        return personID;
    }

    public void setPersonID(int personID) {
        this.personID = personID;
    }

    public int getHouseID() {
        return houseID;
    }

    public void setHouseID(int houseID) {
        this.houseID = houseID;
    }

    public int getNoOfInstallments() {
        return noOfInstallments;
    }

    public void setNoOfInstallments(int noOfInstallments) {
        this.noOfInstallments = noOfInstallments;
    }

    public int getIntrestRate() {
        return intrestRate;
    }

    public void setIntrestRate(int intrestRate) {
        this.intrestRate = intrestRate;
    }

    @Override
    public String toString() {
        return "PurchaseContract{" +
                "id=" + id +
                ", contractNumber=" + contractNumber +
                ", date=" + date +
                ", place='" + place + '\'' +
                ", personID=" + personID +
                ", houseID=" + houseID +
                ", noOfInstallments=" + noOfInstallments +
                ", intrestRate=" + intrestRate +
                '}';
    }
}
