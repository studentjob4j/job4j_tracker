package ru.job4j.lambda;

import java.util.Comparator;

public class CmpDescSize  {

    public static void main(String[] args) {
        Comparator<String> comparator = (o1, o2) -> {
            System.out.println(" ReverseCompare " + o2.length() + " : " + o1.length());
            return Integer.compare(o2.length(), o1.length());
        };
    }
}

