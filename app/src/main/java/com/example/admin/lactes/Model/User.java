package com.example.admin.lactes.Model;

/**
 * Created by Admin on 18-04-2018.
 */

public class User {
    public User() {
    }

    public String getName() {

        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    private String Name;

    public User(String name, String password) {
        Name = name;
        Password = password;
    }

    private String Password;
}
