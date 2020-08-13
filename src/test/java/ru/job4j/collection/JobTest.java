package ru.job4j.collection;

import org.junit.Test;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class JobTest {

    @Test
    public void test() {
        Job one = new Job("Bob", 20);
        Job two = new Job("Bob", 2);
        List<Job> list = new ArrayList<>();
        list.add(one);
        list.add(two);
        Collections.sort(list, new WhenCompareByName().thenComparing(new WhenCompareByPriority()));
        List<Job> except = new ArrayList<>();
        except.add(two);
        except.add(one);
        assertThat(list, is(except));
    }

    @Test
    public void test2() {
        Job one = new Job("Bob", 20);
        Job two = new Job("Anna", 20);
        List<Job> list = new ArrayList<>();
        list.add(one);
        list.add(two);
        Collections.sort(list, new WhenCompareByPriority().thenComparing(new WhenCompareByName()));
        List<Job> except = new ArrayList<>();
        except.add(two);
        except.add(one);
        assertThat(list, is(except));
    }
}