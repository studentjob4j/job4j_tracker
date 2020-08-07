package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {

    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("job4j@yandex.ru", "Shegai Evgenii Sergeevich");
        for (String key : map.keySet()) {
            String value =  map.get(key);
            System.out.println(key + " " + value);
        }

    }
}
