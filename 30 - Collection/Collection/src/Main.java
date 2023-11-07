

import java.util.*;
//import test.org.Person;


//class Person{
//    public int length;
//    public int size(){
//        return length;
//    }
//}

public class Main {
    public static void main(String[] args) {

//        Map<String,String> map = new TreeMap<>();
//        map.put("one","odin");
//        map.put("two","dva");
//        map.put("three","tri");
//        map.put("four","cetire");
//
//        System.out.println(map.containsKey("one"));
//        System.out.println(map.containsValue("cetire"));
//        map.clear();
//        map.size();
//


        Map<String,Map<String,String>> map =new TreeMap<>();
        map.put("en", new TreeMap<>());

        map.get("en").put("one","один");
        map.get("en").put("home","дом");
        map.get("en").put("mom","мама");
        map.get("en").put("dad","папа");
        map.get("en").put("dad","ппппппп");



        map.put("ru", new TreeMap<>());
        map.get("ru").put("один","one");
        map.get("ru").put("дом" ,"home");
        map.get("ru").put("мама","mom");
        map.get("ru").put("папа","dad");


        String lang = "en";
        String word = "dad";
        if(!map.containsKey(lang)&&!map.containsKey(word)){
            System.out.println(map.get(lang).get(word));
        }else System.out.println("Такой ключ отсутствует");


//        System.out.println(map.containsKey("one"));
//        System.out.println(map.containsValue("cetire"));
//        map.clear();
//        map.size();





//        HashSet<String> hashSet = new HashSet<>();
//        hashSet.add("Farid");
//        hashSet.add("Farid");
//        hashSet.add("Farid");
//        hashSet.add("Farid");


//        SortedSet<String> hashSet = new TreeSet<>();
//        hashSet.add("Farid");
//        hashSet.add("Farid");
//        hashSet.add("Farid");
//        hashSet.add("Farid");
//
//        hashSet.
//
//        System.out.println(hashSet.size());

       //  LIFO
//        Deque<String> deque = new ArrayDeque<>(2);
////        deque.get
//deque.of("Farid");
//deque.add("Oleq");
//deque.add("Sawa");
//deque.push("Nacalo");
//
//        System.out.println(deque.pop());
//        System.out.println(deque.size());

//        System.out.println(queue.add("A"));;
//        System.out.println(queue.add("A"));;
//        System.out.println(queue.add("A"));;
//
//
//        queue.forEach(x->{
//            System.out.println(x);
//        });
//        List<String> list = new ArrayList<>();
//      list.add("Farid");
//      list.add("Sawa");
//      list.add("Mawa");
//      list.add("Dawa");
//
//        for (String str:list ) {
//            System.out.println(str);
//        }
//        System.out.println();
//
//        list.forEach(x-> System.out.println(x));
//
//        System.out.println();
//
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i));
//        }


//        list.removeAll();


//        List<Integer> list1 = new ArrayList<>( );
//        list1.add(0);
//        list1.add(10);
//        list1.add(2);
//        list1.add(45);
//        list1.add(10);
//        list1.add(405);
//
////        list1.add(0,1000);
//
////        list1.removeIf(x->x%2==0);
//
//
//                List<Integer> list2 = new ArrayList<>( );
//        list2.add(0);
//        list2.add(10);
//        list2.add(45);
//        list2.add(405);
//
//        list1.removeAll(list2);
//
//
//        for (int i = 0; i < list1.size(); i++) {
//            System.out.println(list1.get(i));
//        }


//        List<Integer> list2 = new ArrayList<>( );
//        list2.add(0);
//        list2.add(10);
//        list2.add(2);
//        list2.add(45);
//        list2.add(10);
//        list2.add(405);
//
//        list1.addAll(list2);








//        Person person = new Person();
//        person.
//Scanner scanner = new Scanner(System.in);
//      int[] arr = new int[10];
//      arr[0] = 1;
//        System.out.println(arr.length);
//        int[] arr2 = new int[arr.length + 10];
//        List<Person> list1 = new ArrayList<>( );
//        List<Integer> list1 = new ArrayList<>( );

//      boolean isAdd = list1.add(10);
//        System.out.println("Is Add : " + isAdd);
//        System.out.println("Size   : " + list1.size());
//        System.out.println("Get    : " + list1.get(0));
//        list1.clear();
//        System.out.println("Clear  : " + list1.size());
//        list1.add(0);
//        list1.add(10);
//        list1.add(2);
//        list1.add(45);
//        list1.add(10);
//        list1.add(405);

//        list1.add(new Person());
//        list1.add(new Person());
//        list1.add(new Person());
//        list1.add(new Person());
//        list1.add(new Person());
//        list1.add(new Person());


//        System.out.println("IsEmpty: " + list1.isEmpty());
//        System.out.println("Contain: " + list1.contains(10));
//        System.out.println("Contain: " + list1.contains(100));

//        list1.remove(new Person());

//        for (int i = 0; i < list1.size(); i++) {
//            System.out.println(list1);
//        }




//        List<Integer> list2 = new Vector<>( );



//        list.add(1);
//        System.out.println(list.size());




    }
}