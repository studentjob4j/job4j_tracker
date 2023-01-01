package ru.job4j.collection;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

public class JobTest {

    @Test
    public void whenSortAscByName() {
        List<Job> list = Arrays.asList(new Job("x", 2), new Job("a", 3));
        list.sort(new SortJobByAscName());
        List<Job> expect = List.of(new Job("a", 3), new Job("x", 2));
        assertThat(list).containsSequence(expect);
    }

    @Test
    public void whenSortDescByName() {
        List<Job> list = Arrays.asList(new Job("a", 2), new Job("x", 3));
        list.sort(new SortJobByDescName());
        List<Job> expect = List.of(new Job("x", 3), new Job("a", 2));
        assertThat(list).containsSequence(expect);
    }

    @Test
    public void whenSortAscByPriority() {
        List<Job> list = Arrays.asList(new Job("x", 3), new Job("a", 1));
        list.sort(new SortJobByAscName());
        List<Job> expect = List.of(new Job("a", 1), new Job("x", 3));
        assertThat(list).containsSequence(expect);
    }

    @Test
    public void whenSortDescByPriority() {
        List<Job> list = Arrays.asList(new Job("x", 1), new Job("a", 3));
        list.sort(new SortJobByDescPriority());
        List<Job> expect = List.of(new Job("a", 3), new Job("x", 1));
        assertThat(list).containsSequence(expect);
    }

    @Test
    public void whenSortAscByNameThenByAscPriority() {
        List<Job> list = Arrays.asList(new Job("a", 2), new Job("a", 1));
        Comparator<Job> comparator = new SortJobByAscName().thenComparing(new SortJobByAscPriority());
        list.sort(comparator);
        List<Job> expect = List.of(new Job("a", 1), new Job("a", 2));
        assertThat(list).containsSequence(expect);
    }

    @Test
    public void whenSortAscByPriorityThenByDescName() {
        List<Job> list = Arrays.asList(new Job("a", 2), new Job("x", 2));
        Comparator<Job> comparator = new SortJobByAscPriority().thenComparing(new SortJobByDescName());
        list.sort(comparator);
        List<Job> expect = List.of(new Job("x", 2), new Job("a", 2));
        assertThat(list).containsSequence(expect);
    }

}