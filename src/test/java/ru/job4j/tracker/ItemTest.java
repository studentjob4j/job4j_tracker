package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

public class ItemTest {

    @Test
    public void whenOneLessThenTwo() {
        Item one = new Item();
        one.setName("Petrov");
        Item two = new Item();
        two.setName("Ivan");
        assertThat(one.compare(two, one),is(-1));
    }

    @Test
    public void whenOneBigThenTwo() {
        Item one = new Item();
        one.setName("Petrov");
        Item two = new Item();
        two.setName("Ivan");
        assertThat(one.compare(one, two),is(1));
    }

}