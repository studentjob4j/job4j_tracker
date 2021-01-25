package ru.job4j.lambda;

import org.junit.Test;

import java.util.List;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class SearchAttTest {

    @Test
    public void whenFilterBySize() {
        Attachment one = new Attachment("one", 100);
        Attachment two = new Attachment("two", 200);
        Attachment three = new Attachment("three", 300);
        List<Attachment> attachments =  List.of(one, two, three);
        attachments = SearchAtt.filterSize(attachments);
        List<Attachment> except =  List.of(two, three);
        assertThat(attachments, is(except));
    }

    @Test
    public void whenFilterByName() {
        Attachment one = new Attachment("bug", 100);
        Attachment two = new Attachment("two", 200);
        Attachment three = new Attachment("bug", 300);
        List<Attachment> attachments =  List.of(one, two, three);
        attachments = SearchAtt.filterName(attachments);
        List<Attachment> except =  List.of(one, three);
        assertThat(attachments, is(except));
    }

}