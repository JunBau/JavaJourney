package com.JunBau;

public class Contacts {

    private String contactName;
    private String number;

    private Contacts(String contactName, String number) {
        this.contactName = contactName;
        this.number = number;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public static Contacts addContact(String name, String number) {
        return new Contacts(name, number);
    }

}
