package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Slovar {
    private Map<String, Map<String, List<String>>> dictionary;

    {
        dictionary = new TreeMap<String, Map<String, List<String>>>();
    }


    public boolean addLang(String lang) {
        lang = lang.toLowerCase();
        if (dictionary.containsKey(lang)) {
            return false;
        }
        dictionary.put(lang, new TreeMap<String, List<String>>());
        return true;
    }

    public boolean removeLang(String lang) {
        lang = lang.toLowerCase();
        if (dictionary.containsKey(lang)) {
            dictionary.remove(lang);
            return true;
        }
        return false;
    }

    private List<String> toLowerCase(List<String> list){
        List<String> listArr = new ArrayList<String>();
        for (String word:list) {
            listArr.add(word.toLowerCase());
        }
        return listArr;
    }

    public boolean addWord(String keyLang, String originalWord, List<String> arrWord) {
        originalWord = originalWord.toLowerCase();
        keyLang=keyLang.toLowerCase();
        arrWord = toLowerCase(arrWord);
        if (dictionary.containsKey(keyLang)) {
            if(dictionary.get(keyLang).containsKey(originalWord)) {
                return false;
            }else {
                dictionary.get(keyLang).put(originalWord, arrWord);
                return true;
            }
        }else {
            if(addLang(keyLang))
            return addWord(keyLang, originalWord, arrWord);
            else return false;
        }
    }
    public boolean addWord(String keyLang, String originalWord, String word) {
        originalWord = originalWord.toLowerCase();
        keyLang=keyLang.toLowerCase();
        word=word.toLowerCase();
        if (dictionary.containsKey(keyLang)) {
            if(dictionary.get(keyLang).containsKey(originalWord)) {
                if(dictionary.get(keyLang).get(originalWord).contains(word)){
                    return false;
                }else{
                    dictionary.get(keyLang).get(originalWord).add(word);
                    return true;
                }
            }else {
                ArrayList<String> list = new ArrayList<String>();
                list.add(word);
                dictionary.get(keyLang).put(originalWord, list);
                return true;
            }
        }else {
            if(addLang(keyLang)) {
                boolean isadd = addWord(keyLang, originalWord, word);
                return isadd;
            }else {
                return false;
            }
        }
    }

    public void printLang() {
        int count = 1;
        for (String lang : dictionary.keySet()) {
            System.out.println(count++ + ") " + lang);
        }
    }

    public void printSlovarLang(String key){
        int count = 1;
        for (String newKey:dictionary.get(key).keySet()) {
            System.out.println(newKey);
            System.out.println("_______________________________________________________");
            for (String word:dictionary.get().keySet()) {
                System.out.print(word+" : ");
                for (String tr:dictionary.get(newKey).get(word)) {
                    System.out.print(tr+" , ");
                }
                System.out.println();
            }
        }
//        System.out.println(dictionary.get(key));
    }

}
