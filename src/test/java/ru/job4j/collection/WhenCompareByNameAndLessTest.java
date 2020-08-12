package ru.job4j.collection;

import org.junit.Test;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class WhenCompareByNameAndLessTest {

    @Test
    public void WhenCompareByNameAndLess () {
        Job one = new Job("Bob", 2);
        Job two = new Job("Anna", 20);
        List<Job> list = new ArrayList<>();
        list.add(two);
        list.add(one);
        Collections.sort(list, new WhenCompareByNameAndLess());
        List<Job> except = new ArrayList<>();
        except.add(one);
        except.add(two);
        assertThat(list, is(except));
    }

}