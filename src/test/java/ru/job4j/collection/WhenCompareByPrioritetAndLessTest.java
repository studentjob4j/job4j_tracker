package ru.job4j.collection;

import org.junit.Test;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class WhenCompareByPrioritetAndLessTest {

    @Test
    public void WhenCompareByPriorityAndLess () {
        Job one = new Job("Bob", 20);
        Job two = new Job("Harry", 20);
        List<Job> list = new ArrayList<>();
        list.add(one);
        list.add(two);
        Collections.sort(list, new WhenCompareByPrioritetAndLess());
        List<Job> except = new ArrayList<>();
        except.add(two);
        except.add(one);
        assertThat(list, is(except));
    }

}