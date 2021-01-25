package ru.job4j.collection.streamapi;

import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ListConvertMapTest {

    private List<Student> list = Arrays.asList(new Student(1, "Boris"), new Student(2, "Pavel"),
    new Student(2, "Sergey"));

    @Test
    public void whenConvertListInMap() {
        ListConvertMap convert = new ListConvertMap();
        Map<String, Student> result = convert.covert(list);
        assertThat(result.size(), is(3));
    }
}