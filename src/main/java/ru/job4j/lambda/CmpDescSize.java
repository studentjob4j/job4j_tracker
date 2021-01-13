package ru.job4j.lambda;

import java.util.Comparator;

public class CmpDescSize  {

       private Comparator<String> comparator = (o1, o2) -> {
            System.out.println(" ReverseCompare " + o2.length() + " : " + o1.length());
            return o2.length() - o1.length();
       };
}

