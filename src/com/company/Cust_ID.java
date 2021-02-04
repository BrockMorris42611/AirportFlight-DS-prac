package com.company;

public class Cust_ID {

    private String ID_name; // this is the login number or username of the person logging in
    private String assoc_ID_pass; // password

    Cust_ID(String ID_name, String assoc_ID_pass){
        this.ID_name = ID_name;
        this.assoc_ID_pass = assoc_ID_pass;
    }

    public String getAssoc_ID_pass() {
        return assoc_ID_pass;
    }
    public String getID_name() {
        return ID_name;
    }

    @Override
    public String toString() {
        return "USERNAME> " + this.getID_name() + "\t" + "PASSWORD> " + this.getAssoc_ID_pass();
    }
}