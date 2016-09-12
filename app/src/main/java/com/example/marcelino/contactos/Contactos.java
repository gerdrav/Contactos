package com.example.marcelino.contactos;

import java.io.Serializable;

public class Contactos implements Serializable {
    // Parameters
    private String contactName;
    private String birthDate;
    private String phoneNumber;
    private String email;
    private String description;

    //Constructor
    public Contactos(String contactName, String birthDate, String phoneNumber, String email, String description){
        this.contactName = contactName;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.description = description;
    }
    /**
     * Setting setters and getters.
     * @return
     */

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String emal) {
        this.email = email;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
