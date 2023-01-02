package ru.job4j.lambda;

import ru.job4j.lambda.Attachment;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Анонимные классы
 * @author Shegai Evgenii
 * @version 1.0
 * @since 1.0
 */

public class AttachmentSort {

    public static void main(String[] args) {
        List<Attachment> attachments = Arrays.asList(
                new Attachment("a", 100),
                new Attachment("d", 34),
                new Attachment("y", 13)
        );
        Comparator<Attachment> comparator = new Comparator<>() {
            @Override
            public int compare(Attachment o1, Attachment o2) {
                return Integer.compare(o1.getSize(), o2.getSize());
            }
        };
        attachments.sort(comparator);
        System.out.println(attachments);
        Comparator<Attachment> comparator2 = new Comparator<Attachment>() {
            @Override
            public int compare(Attachment o1, Attachment o2) {
                return o1.getName().compareTo(o2.getName());
            }
        };
        attachments.sort(comparator2);
        System.out.println(attachments);
    }
}
