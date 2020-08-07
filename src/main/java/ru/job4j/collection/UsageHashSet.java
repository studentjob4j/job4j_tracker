package ru.job4j.collection;

import java.util.HashSet;

public class UsageHashSet {

    public static void main(String[] args) {
        HashSet<String> autos = new HashSet<String>();
        autos.add("LADA");
        autos.add("BMW");
        autos.add("VOLVO");
        autos.add("TOYOTA");
        for (String temp : autos) {
            System.out.println(temp);
        }
    }
}
