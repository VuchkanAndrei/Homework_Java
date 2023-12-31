import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        /*
        1) Дана коллекция строк { "a1","a2","a3","a2","a2","a5","a1"} вернцть количество вхождений объекта "а1" c помощью streamApi
        2) Найти элемент в коллекции равный "a3" или вывести "ошибку"
        3) Вернуть последний элемент коллекции или "empty" если коллекция пуста
        4) Вернуть два элемента начиная со второго элемента коллекции
        5) Из коллекции имен убрать все повторения и найти среднию длинну имен
        6) Отсортировать коллекцию строк по убыванию и убрать дубликаты
        7) Вернуть сумму нечетных чисел или 0

    */

        System.out.println("_____________________________1____________________________");
        int result = (int) Stream.of("a1", "a2", "a3", "a2", "a2", "a5", "a1").filter(x -> x.equals("a1")).count();
        System.out.println("chislo vhojdeniy a1 = " + result);

        System.out.println("_____________________________2____________________________");

        System.out.println(Stream.of("a1", "a2", "a3", "a2", "a2", "a5", "a1").filter(x -> x.contains("a3")).findFirst().orElse("error!"));

        System.out.println("_____________________________3____________________________");

        System.out.println(Stream.of("a1", "a2", "a3", "a2", "a2", "a5", "a10").reduce((first, second) -> second).orElse("empty")); // последний элемент коллекции

        System.out.println("_____________________________4____________________________");

        System.out.println(Stream.of("a1", "a2", "a3", "a2", "a2", "a5", "a10").skip(1).limit(2).collect(Collectors.toList()));

        System.out.println("_____________________________5____________________________");

        System.out.println(Stream.of("a1", "a2", "a3", "a2", "a2", "a5", "a2").distinct().sorted(Collections.reverseOrder()).collect(Collectors.toList()));

        System.out.println("_____________________________6____________________________");

        System.out.println(Stream.of("a1", "a2", "a3", "a2", "a2", "a5", "a2").distinct().sorted(Collections.reverseOrder()).collect(Collectors.toList()));

        System.out.println("_____________________________7____________________________");

        System.out.println(Stream.of("a1", "a2", "a3", "a2", "a2", "a5", "a2").mapToInt(x -> Integer.parseInt(x.substring(1))).filter(x -> x % 2 != 0).sum());


    }
}
