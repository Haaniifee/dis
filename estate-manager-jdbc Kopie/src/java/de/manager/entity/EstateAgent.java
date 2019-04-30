package de.manager.entity;

public class EstateAgent {

    private int id;

    private String firstName;
    private String lastName;
    private String address;
    private String loginName;
    private String loginPass;

    public EstateAgent(String firstName, String lastName, String address, String loginName, String loginPass) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.loginName = loginName;
        this.loginPass = loginPass;
    }

    public EstateAgent() {}

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getLoginPass() {
        return loginPass;
    }

    public void setLoginPass(String loginPass) {
        this.loginPass = loginPass;
    }

    @Override
    public String toString() {
        return "EstateAgent{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", loginName='" + loginName + '\'' +
                ", loginPass='" + loginPass + '\'' +
                '}';
    }
}
