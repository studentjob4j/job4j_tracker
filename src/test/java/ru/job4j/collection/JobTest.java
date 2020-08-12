package ru.job4j.collection;

import org.junit.Test;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class JobTest {

    @Test
    public void test () {
        Job one = new Job("Bob", 2);
        Job two = new Job("Bob", 2);
        List<Job> list = new ArrayList<>();
        list.add(one);
        list.add(two);
        Collections.sort(list, new WhenCompareByName().thenComparing(new WhenCompareByNameAndLess()));
        List<Job> except = new ArrayList<>();
        except.add(one);
        except.add(two);
        assertThat(list, is(except));
    }


}