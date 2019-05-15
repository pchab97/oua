package com.example.lab6.DAO;

public class Computer {
    private String name;
    private String description;
    private float price;
    private int imageResourceId;

    public Computer(String name, String description, float price, int imageResourceId) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.imageResourceId = imageResourceId;
    }

    public Computer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Float getPrice() {
        return price;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    @Override
    public String toString() {
        return name;
    }
}
