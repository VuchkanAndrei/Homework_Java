import java.util.*;

// НАПИСАТЬ ПОИСКОВИК ДВУМЯ ОБРАЗАМИ:
//1. ПОЛЬЗОВАТЕЛЬ ПИШЕТ К*Л ВЫВЕДЕТ ВСЕ СЛОВА - НАЧАЛО С К - ОКОНЧАГИЕ Л
//2. ПОЛЬЗОВАТЕЛЬ ПИШЕТ К_Т ВЫВЕДЕТ ВСЕ СЛОВА - НАЧАЛО С К  "_" - ЛЮБОЙ ОДИН СИМВОЛ, - 3 СИМВОЛА
class Slovar {
    private Map<String, Map<String, List<String>>> dictionary;

    {
        dictionary = new TreeMap<String, Map<String, List<String>>>();
    }

    // метод добавления языка ru, en
    public boolean addLang(String lang) {
        lang = lang.toLowerCase(); // игнорирование регистра
        if (dictionary.containsKey(lang)) { //не добавлять уже существующий язык
            return false;
        }
      //  dictionary.put(lang, new TreeMap<String, String>());
        return true;
    }

    // метод вывода на печать языка ru, en
    public void printLang() {
        int count = 1;
        for (String lang : dictionary.keySet()) {
            System.out.println(count++ + ") " + lang);
        }
    }

    // метод удаления языка ru, en
    public boolean removeLang(String lang) {
        lang = lang.toLowerCase();// игнорирование регистра
        if (dictionary.containsKey(lang)) {
            dictionary.remove(lang);
            return true;
        }
        return false;
    }

    public List<String> toLowerCase(List<String> list) {
        List<String> lisrArr = new ArrayList<String>();
        for (String word : list) {
            lisrArr.add(word.toLowerCase());
        }
        return lisrArr;
    }

    public List<String> checkList(List<String> nowArrWord, List<String> newArrWord) {
        for (String word : newArrWord) {
            if (!nowArrWord.contains(word)) {
                nowArrWord.add(word);
            }
        }
        return nowArrWord;
    }

    public boolean addWord(String keyLang, String originalWord, List<String> arrWord) {
        originalWord = originalWord.toLowerCase();// игнорирование регистра
        keyLang = keyLang.toLowerCase();// игнорирование регистра
        arrWord = toLowerCase(arrWord);// игнорирование регистра
        if (dictionary.containsKey(keyLang)) {
            if (dictionary.get(keyLang).containsKey(originalWord)) {
                List<String> arr = dictionary.get(keyLang).get(originalWord);
                List<String> arrNew;
                //проверить есть ли слова отсутствующие в arrWord
                arrNew = checkList(arr, arrWord);
                if (arr.size() != arrNew.size()) {
                    dictionary.get(keyLang).put(originalWord, arrNew);
                    return true;
                }
                return false;
            } else {
                dictionary.get(keyLang).put(originalWord, arrWord);
                return true;
            }
        } else {
            if (addLang(keyLang))
                return addWord(keyLang, originalWord, arrWord);
            else return false;
        }
    }

//    public boolean addWord(String keyLang, String originalWord, String word) {
//        originalWord = originalWord.toLowerCase();// игнорирование регистра
//        keyLang = keyLang.toLowerCase();// игнорирование регистра
//        word = word.toLowerCase();// игнорирование регистра
//        if (dictionary.containsKey(keyLang)) {
//            if (dictionary.get(keyLang).containsKey(originalWord)) {
//                if (dictionary.get(keyLang).get(originalWord).contains(word)) {
//                    return false;
//                } else {
//                    dictionary.get(keyLang).get(originalWord).add(word);
//                    return true;
//                }
//            } else {
//                ArrayList<String> list = new ArrayList<String>();
//                list.add(word);
//                dictionary.get(keyLang).put(originalWord, list);
//                return false;
//            }
//        } else {
//            if (addLang(keyLang)) {
//                boolean isadd = addWord(keyLang, originalWord, word);
//                return isadd;
//            } else {
//                return false;
//            }
//        }
//    }

    public void printSlovarLang(String newKey) {
        int count = 1;
        if (dictionary.containsKey(newKey)) {
            System.out.println(newKey);
            System.out.println("--------------------------------");
            for (String word : dictionary.get(newKey).keySet()) {
                System.out.print(word + " : ");
                for (String tr : dictionary.get(newKey).get(word)) {
                    System.out.print(tr + " , ");
                }
                System.out.println();
            }
        }
    }

    public void printSlovarLang() {
        int count = 1;
        if (dictionary.keySet().size() > 0) {

            for (String lang : dictionary.keySet()) {
                System.out.println(count++ + ") " + lang);
            }
        }
    }

    public String getLangByIndex(int index) {
        int count = 1;
        if (dictionary.keySet().size() >= index && index >= 0) {

            for (String lang : dictionary.keySet()) {
                if (index == count) return lang;
                count++;
                //  System.out.println(count++ + ") "+ lang);
            }
        }

        return null;
    }

    public void printSlovar() {
        int count = 1;
        for (String newKey : dictionary.keySet()) {
            System.out.println(newKey);
            System.out.println("--------------------------------");
            for (String word : dictionary.get(newKey).keySet()) {
                System.out.print(word + " : ");
                for (String tr : dictionary.get(newKey).get(word)) {
                    System.out.print(tr + " , ");
                }
                System.out.println();
            }
        }
    }

    // метод поиска слова по первым буквам
    public void searchWord(String lang, String search) {
        int count = 1;
        search = search.toLowerCase();
        if (dictionary.containsKey(lang)) {
            for (String word : dictionary.get(lang).keySet()) {
                if (word.startsWith(search)) {
                    if (count == 1)
                        System.out.println("Search : " + search);
                    System.out.println(count++ + ") " + word);
                }
            }
            if (count == 1) {
                System.out.println("Такого слова нет !!!");
            }
        }
    }

    //  ПОЛЬЗОВАТЕЛЬ ПИШЕТ К*Л ВЫВЕДЕТ ВСЕ СЛОВА - НАЧАЛО С К - ОКОНЧАГИЕ Л


    public void printWordSearch(String lang, String newWord) {
        int count = 1;
        String[] arr = newWord.split("[*]");
        String startChar = arr[0];
        String endChar = arr[1];
        lang = lang.toLowerCase();
        startChar = startChar.toLowerCase();
        endChar = endChar.toLowerCase();
        if (dictionary.containsKey(lang)) {
            for (String word : dictionary.get(lang).keySet()) {
                if (word.startsWith(startChar) && word.endsWith(endChar)) {
                    if (count == 1)
                        System.out.println("Начало : " + startChar + " Конец: " + endChar);
                    System.out.print(count++ + ") " + word + " ");
                    for (String tr : dictionary.get(lang).get(word)) {
                        System.out.print(tr + " ");
                    }
                    System.out.println();
                }
                if (count == 1) {
                    System.out.println("Такого слова нет !!!");
                }
            }
        }
    }

    public void printWordSize(String lang, String newWord) {
        int count = 1;
        String[] arr = newWord.split("[_]");
        String startChar = arr[0];
        String endChar = arr[1];
        lang = lang.toLowerCase();
        startChar = startChar.toLowerCase();
        endChar = endChar.toLowerCase();
        if (dictionary.containsKey(lang)) {
            for (String word : dictionary.get(lang).keySet()) {
                if (word.startsWith(startChar) && word.endsWith(endChar) && word.length() == 3) {
                    if (count == 1)
                        System.out.println("Начало : " + startChar + " Конец " + endChar);
                    System.out.print(count++ + ") " + word + " ");

                    for (String tr : dictionary.get(lang).get(word)) {
                        System.out.print(tr + " ");
                    }
                    System.out.println();
                }

            }
            if (count == 1) {
                System.out.println("Такого слова нет !!!");
            }
        }
    }

    public void printWordArr(String lang, String newWord) {
        int count = 1;
        for (String str : dictionary.get(lang).keySet()) {
            if (checkWordChar(str, newWord)) {
                System.out.println(str);
            }
        }


    }

    //                if(dictionary.get(lang).keySet().)
//            }
//
//        lang = lang.toLowerCase();
//        startChar = startChar.toLowerCase();
//        endChar = endChar.toLowerCase();
//        if (dictionary.containsKey(lang)) {
//            for (String word : dictionary.get(lang).keySet()) {
//                if (word.startsWith(startChar)&&word.endsWith(endChar)&&word.length()==3) {
//                    if (count == 1)
//                        System.out.println("Начало : " + startChar + " Конец " + endChar);
//                    System.out.print(count++ + ") " + word+" ");
//
//                    for (String tr : dictionary.get(lang).get(word)) {
//                        System.out.print(tr + " ");
//                    }
//                    System.out.println();
//                }
//
//            }
//            if (count == 1) {
//                System.out.println("Такого слова нет !!!");
//            }
//        }
//
//    }
    public boolean checkWordChar(String word, String search) {

//        boolean flag = false;
//        if (word.length() == search.length()) {
//            for (int i = 0; i < search.length(); i++) {
//                if (word.charAt(i) == search.charAt(i) || search.charAt(i) == '_') {
//                    flag = true;
//                } else {
//                    flag = false;
//                    break;
//                }
//            }
//        }
//        return flag;

        if (word.length() == search.length()) {
            for (int i = 0; i < search.length(); i++) {
                if (word.charAt(i) != search.charAt(i)) {
                    if (search.charAt(i) != '_')
                        return false;
                }
            }
            return true;
        }
        return false;
    }
}


    public class Main {
        public static void main(String[] args) {
            System.out.println("Словарь!");
            String action;
            Scanner scanner = new Scanner(System.in);
            Slovar slovar = new Slovar();
            slovar.addWord("en", "cat", "кошка");
            slovar.addWord("en", "cot", "кот");
            slovar.addWord("en", "cit", "кит");
            slovar.addWord("en", "coat", "пальто");
            slovar.addWord("en", "dog", "собака");
//        System.out.println("Введите раскладку");
//        String lang = scanner.nextLine();
//        System.out.println("Введите искомое слово");
//        String word = scanner.nextLine();

//        slovar.printWordSize(lang, word);
//            String newWord = "m_m_";
//
//          slovar.printWordArr("en", "_o_");


            do {

                System.out.println("1 Добавить расскалдку");
                System.out.println("2 Добавить слово");
                System.out.println("3 Добавить несколько слов");
                System.out.println("4 Напечатать расскладку");
                System.out.println("5 Напечатать словарь");
                System.out.println("6 Удаление расскалдки");
                System.out.println("7 Поиск слова");
                System.out.println("8 Выход");

                action = scanner.nextLine();

                if (action.equals("1")) {
                    System.out.println("Выведите расскалдку");
                    String lang = scanner.nextLine();
                    slovar.addLang(lang);
                } else if (action.equals("2")) {
                    System.out.println("Введите язык слова");
                    String langword = scanner.nextLine();
                    System.out.println("Введите исходное слово");
                    String originalWord = scanner.nextLine();
                    System.out.println("Ввод перевода");
                    String translateWord = scanner.nextLine();
                    slovar.addWord(langword, originalWord, translateWord);
                } else if (action.equals("3")) {
                    System.out.println("Введите язык слова");
                    String langword = scanner.nextLine();
                    System.out.println("Введите исходное слово");
                    String originalWord = scanner.nextLine();
                    System.out.println("Ввод перевода");
                    List<String> translateWord = new ArrayList<String>();
                    String addWord = scanner.nextLine();
                    translateWord.add(addWord);

                    while (true) {
                        System.out.println("Добавить еще одно значение перевода слова? \n1.Да\n2.Нет");
                        int command = scanner.nextInt();
                        if (command == 1) {
                            while (true) {
                                System.out.println("Введите перевод слова");
                                scanner.nextLine();
                                addWord = scanner.nextLine();
                                translateWord.add(addWord);
                                break;
                            }
                        } else if (command == 2) break;
                        else System.out.println("Некорректная команда");
                    }
                    slovar.addWord(langword, originalWord, translateWord);
                } else if (action.equals("4")) {
                    slovar.printLang();
                } else if (action.equals("5")) {
                    slovar.printSlovar();
                } else if (action.equals("6")) {
                    System.out.println("Введите раскладку которую хотите удалить");
                    String removeLang = scanner.nextLine();
                    if (slovar.removeLang(removeLang)) {
                        System.out.println("Раскладка " + removeLang + " удалена!");
                    } else System.out.println("Такой раскладки нет!");
                } else if (action.equals("7")) {
                    System.out.println("Введите язык слова");
                    String langWordSearch = scanner.nextLine();
                    System.out.println("Введите начало слов, которые хотите найти");
                    String originalWordSearch = scanner.nextLine();
                    slovar.searchWord(langWordSearch, originalWordSearch);
                } else if (action.equals("8")) {
                    System.out.println("Выход");
                    break;
                } else {
                    System.out.println("Неправильный выбор, только от (1-8)");
                }


       }while (true);


//        Slovar slovar = new Slovar();
//        System.out.println(slovar.addLang("ru"));
//        System.out.println(slovar.addWord("ru", "cat", "котенок"));
//        System.out.println(slovar.addWord("ru", "cat", "кошка"));
//        System.out.println(slovar.addLang("en"));
//        System.out.println(slovar.addLang("en"));
//        System.out.println(slovar.addLang("fr"));
//        System.out.println(slovar.removeLang("pr"));
//
//        ArrayList<String> arr = new ArrayList<String>();
//        arr.add("Кошка");
//        arr.add("Кот");
//        arr.add("Котенок");
//
//        slovar.addWord("ru", "cat", arr);
//        slovar.addWord("ru", "card", arr);
//        slovar.addWord("ru", "capitan", arr);
//        slovar.addWord("ru", "catalog", arr);
//
//        slovar.printSlovarLang("ru");
//        slovar.searchWord("ru", "catal");
//        slovar.printSlovar();
//        slovar.printLang();

                //}

        }
    }
