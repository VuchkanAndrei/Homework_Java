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
        arr.add("�����");
        arr.add("�������");

//        System.out.println(slovar.addWord("en", "Cat", arr));
//        System.out.println(slovar.addWord("en", "Cat", "�����"));
        slovar.addWord("en", "Car", "����������");
        slovar.addWord("en", "Car", "������");
        slovar.addWord("en", "Car", "���������");
        slovar.addWord("en", "Head", "������");
        slovar.printSlovarLang("en");
    }
}
