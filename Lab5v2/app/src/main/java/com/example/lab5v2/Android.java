package com.example.lab5v2;

public class Android {

    private String name;
    private String description;

    public static final Android[] androids = {
            new Android("Wersja 1.0",
                    "Nazwa: Apple Pie \n Numer wersji:  1.0 	\n Data wydania: 23 września 2008 	Poziom API: 1"),
            new Android("Wersja 1.6",
                    "Nazwa: Donut \n Numer wersji: 1.6 	\n Data wydania: 15 września 2009  	Poziom API: 4"),
            new Android("Wersja: 4.4",
                    "Nazwa: KitKat \n Numer wersji: 4.4-4.4.4  	\n Data wydania: 31 października 2013  	Poziom API: 19-20"),
            new Android("Wersja: 9.0",
                    "Nazwa: Pie \n Numer wersji: 9.0 	\n  Data wydania: 6 sierpnia 2018  	Poziom API: 28")
    };

    // Każdy trening (Workout) zawiera nazwę i opis
    private Android(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return this.name;
    }
}
