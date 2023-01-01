package ru.job4j.tracker;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

public class ItemSortByNameTest {

    @Test
    public void whenSortItemByAsc() {
        List<Item> list = Arrays.asList(new Item("c"), new Item("f"), new Item("a"));
        list.sort(new ItemAscByName());
        List<Item> expected = Arrays.asList(new Item("a"), new Item("c"), new Item("f"));
        assertThat(list).isEqualTo(expected);
    }

    @Test
    public void whenSortItemByDesc() {
        List<Item> list = Arrays.asList(new Item("c"), new Item("f"), new Item("a"));
        list.sort(new ItemDescByName());
        List<Item> expected = Arrays.asList(new Item("f"), new Item("c"), new Item("a"));
        assertThat(list).isEqualTo(expected);
    }
}
