package com.example.applecatalog;

public class Tablets {
    private String model;
    private String memory;
    private String size;
    private int imageID;

    public Tablets(String model, String memory, String size, int imageID) {
        this.model = model;
        this.memory = memory;
        this.size = size;
        this.imageID = imageID;
    }

    public String getModel() {
        return model;
    }

    public String getMemory() {
        return memory;
    }

    public String getSize() {
        return size;
    }

    public int getImageID() {
        return imageID;
    }

    public String toString(){
        return this.model;
    }

    public static Tablets[] getTablet() {
        return tablets;
    }

    public static final Tablets[] tablets = {
            new Tablets("IPad Pro 12.9'", "256GB", "12.9 Inch", R.drawable.ipad129),
            new Tablets("IPad Pro 11'", "128GB", "11 Inch", R.drawable.ipadpro111),
            new Tablets("IPad Mini", "64GB", "7,9 Inch", R.drawable.ipad_mini_gold_new)
    };


}
