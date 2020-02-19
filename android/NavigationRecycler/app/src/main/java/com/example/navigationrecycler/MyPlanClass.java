package com.example.navigationrecycler;

public class MyPlanClass {


    String name;
    int image;

    public MyPlanClass(String name, int image) {
        this.name = name;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public int getImage() {
        return image;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
