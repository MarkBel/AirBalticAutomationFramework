package com.epam.AirBaltic.entity;

import com.epam.AirBaltic.util.PropertyLoader;

/**
 * Created by Davud_Murtazin on 3/2/2017.
 */
public class Passenger {
    private String firstName;
    private String lastName;
    private String phoneNo;
    private String email;

    public Passenger() {
    }

    public Passenger(String firstName, String lastName, String phoneNo, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNo = phoneNo;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }

    public String getLastName() {
        return lastName;
    }

//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }

    public String getPhoneNo() {
        return phoneNo;
    }

//    public void setPhoneNo(String phoneNo) {
//        this.phoneNo = phoneNo;
//    }

    public String getEmail() {
        return email;
    }

//    public void setEmail(String email) {
//        this.email = email;
//    }

    public Passenger loadPassengerDataFromProperties() {
        this.firstName = PropertyLoader.getProperty("");
        this.lastName = PropertyLoader.getProperty("");
        this.phoneNo = PropertyLoader.getProperty("");
        this.email = PropertyLoader.getProperty("");
        return this;
    }


}
