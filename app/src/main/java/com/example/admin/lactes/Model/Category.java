package com.example.admin.lactes.Model;

/**
 * Created by Admin on 18-04-2018.
 */

public class Category {
    private String Name;
    private String Image;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public Category(String name, String image) {

        Name = name;
        Image = image;
    }

    public Category() {

    }
}
