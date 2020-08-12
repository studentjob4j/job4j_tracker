package ru.job4j.collection;

import org.junit.Test;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class WhenCompareByNameTest {

    @Test
    public void WhenCompareByNameAndBig () {
        Job one = new Job("John", 10);
        Job two = new Job("Anna", 2);
        List<Job> list = new ArrayList<>();
        list.add(one);
        list.add(two);
        Collections.sort(list, new WhenCompareByName());
        List<Job> except = new ArrayList<>();
        except.add(two);
        except.add(one);
        assertThat(list, is(except));
    }

}