package com.example.catalogandroid;

public class Android {
    private String name;
    private String description;

    public Android(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public static final Android[] androids = {

            new Android("Android 1.0", "Nazwa: Apple Pie \nNumer wersji: 1.0 \nData wydania: 23 września 2008 \nPoziom API: 1 "),
            new Android("Android 4.4", "Nazwa: KitKat \nNumer wersji: 4.4-4.4.4 \nData wydania: 31 października 2013 \nPoziom API:19-20 "),
            new Android("Android 9.0", "Nazwa: Pie \nNumer wersji: 9.0 \nData wydania: 6 sierpnia 2018 \nPoziom API: 28 ")
    };

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
