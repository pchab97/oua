package com.example.applecatalog;

public class Computer {
    private String model;
    private String memory;
    private String proccesor;
    private int imageID;

    public Computer(String model, String memory, String proccesor, int imageID) {
        this.model = model;
        this.memory = memory;
        this.proccesor = proccesor;
        this.imageID = imageID;
    }

    public String getModel() {
        return model;
    }

    public String getMemory() {
        return memory;
    }

    public String getProccesor() {
        return proccesor;
    }

    public int getImageID() {
        return imageID;
    }

    public static Computer[] getComputer() {
        return computer;
    }

    public String toString(){
        return this.model;
}

    public static final Computer[] computer = {
            new Computer("Macbook 12'", "256GB", "Intel M3", R.drawable.macbook),
            new Computer("Macbook Air 13'", "256GB", "Intel Core i5", R.drawable.macbookair),
            new Computer("Macbook Pro 13'", "1TB", "Intel Core i7", R.drawable.macbookpro)
    };

}
