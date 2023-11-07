package com.company;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Slovar slovar = new Slovar();
        slovar.addLang("en");
        slovar.addLang("ru");
        slovar.removeLang("En");

        ArrayList<String> arr = new ArrayList<String>();
        arr.add("Кошка");
        arr.add("Котенок");

//        System.out.println(slovar.addWord("en", "Cat", arr));
//        System.out.println(slovar.addWord("en", "Cat", "Кошка"));
        slovar.addWord("en", "Car", "Автомобиль");
        slovar.addWord("en", "Car", "Машина");
        slovar.addWord("en", "Car", "Транспорт");
        slovar.addWord("en", "Head", "голова");
        slovar.printSlovarLang("en");
    }
}
