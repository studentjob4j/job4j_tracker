package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class SearchAtt {

    public static List<Attachment> filterSize(List<Attachment> list) {
        return filter(list,  x -> x.getSize() > 100);
    }

    public static List<Attachment> filterName(List<Attachment> list) {
        return  filter(list,  x -> x.getName().equals("bug"));
    }

    private  static List<Attachment> filter(List<Attachment> list, Predicate<Attachment> predict) {
        List<Attachment> rsl = new ArrayList<>();
        for (Attachment att : list) {
            if (predict.test(att)) {
                rsl.add(att);
            }
        }
        return rsl;
    }
}
