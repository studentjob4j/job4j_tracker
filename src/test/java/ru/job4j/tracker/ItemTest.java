package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

public class ItemTest {

    @Test
    public void whenOneLessThenTwo() {
        Item one = new Item();
        one.setId(4);
        Item two = new Item();
        two.setId(3);
        List<Item> temp = new ArrayList<>();
        temp.add(one);
        temp.add(two);
        Collections.sort(temp, new OneLessThenTwo());
        List<Item> expect = new ArrayList<>();
        expect.add(two);
        expect.add(one);
        assertThat(temp, is(expect));
    }

    @Test
    public void whenOneBigThenTwo() {
        Item one = new Item();
        one.setId(5);
        Item two = new Item();
        two.setId(10);
        List<Item> temp = new ArrayList<>();
        temp.add(one);
        temp.add(two);
        Collections.sort(temp, new OneBigThenTwo());
        List<Item> expect = new ArrayList<>();
        expect.add(two);
        expect.add(one);
        assertThat(temp, is(expect));
    }

}