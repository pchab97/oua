package com.example.applecatalog;

public class Phone {
    private String model;
    private String memory;
    private String color;
    private int imageID;

    public Phone(String model, String memory, String color, int imageID) {
        this.model = model;
        this.memory = memory;
        this.color = color;
        this.imageID = imageID;
    }

    public String getModel() {
        return model;
    }

    public String getMemory() {
        return memory;
    }

    public String getColor() {
        return color;
    }

    public int getImageID() {
        return imageID;
    }

    public static Phone[] getPhone() {
        return phone;
    }
    public String toString(){
        return this.model;
    }

    public static final Phone[] phone = {
            new Phone("Iphone 8 Plus", "256GB", "Space Grey", R.drawable.iphone8plus),
            new Phone("Iphone X", "64GB", "Silver", R.drawable.xsilver),
            new Phone("Iphone XS Max", "128GB", "Gold", R.drawable.xsgold)
    };
}
