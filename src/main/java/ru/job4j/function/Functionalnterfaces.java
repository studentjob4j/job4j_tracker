package ru.job4j.function;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.*;

/**
 *  Функциональный интерфейсы
 * @author Shegai Evgenii
 * @version 1.0
 * @since 02.01.2023
 */

public class Functionalnterfaces {

    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        String separator = System.lineSeparator();
        List<String> list = List.of("one", "two", "three", "four", "five", "six", "seven");
        System.out.println("Добавляю элемнты в карту используя BiConsumer");
        BiConsumer<Integer, String> biCon = (i, s) -> map.put(i, s);
        int index = 1;
        for (String value : list) {
            biCon.accept(index++, value);
        }
        System.out.println("HashMap после добавления элементов " + separator);
        System.out.println(map + separator);
        System.out.println("Использую Predicate для фильтрации " + separator);
        BiPredicate<Integer, String> biPred = (i, s) -> i % 2 == 0 || s.length() == 4;
        for (Integer i : map.keySet()) {
            if (biPred.test(i, map.get(i))) {
                System.out.println("key: " + i + " value: " + map.get(i));
            }
        }
        System.out.println("Создаю лист стрингов использую Suplier");
        Supplier<List<String>> sup = () -> new ArrayList<>(map.values());
        List<String> strings = sup.get();
        System.out.println("Используя Consumer и Function вывожу данные " + separator);
        Consumer<String> consumer = s -> System.out.println(s);
        Function<String, String> func = s -> s.toUpperCase();
        for (String s : strings) {
            consumer.accept(func.apply(s));
        }
    }
}
