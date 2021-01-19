package ru.job4j.collection.streamapi;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class MatrixConvertListTest {

    private Integer[][] array = {{1, 2}, {3, 4}};
    private List<Integer> expect = Arrays.asList(1, 2, 3, 4);

    @Test
    public void whenConvertMatrixToList() {
        MatrixConvertList matrixConvertList = new MatrixConvertList();
        List<Integer> result = matrixConvertList.list(array);
        assertThat(result, is(expect));
    }
}