package ru.job4j.function;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

class FunctionalCalculatorTest {

    @Test
    public void whenLinearFunctionThenLinearResults() {
        FunctionalCalculator function = new FunctionalCalculator();
        List<Double> result = function.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result).containsAll(expected);
    }

    @Test
    public void whenSquareFunctionThenResults() {
        FunctionalCalculator function = new FunctionalCalculator();
        List<Double> result = function.diapason(5, 8, x -> x * x);
        List<Double> expected = Arrays.asList(25D, 36D, 49D);
        assertThat(result).containsAll(expected);
    }

    @Test
    public void whenExponentialFunctionThenResults() {
        FunctionalCalculator function = new FunctionalCalculator();
        List<Double> result = function.diapason(5, 8, x -> Math.pow(x, x));
        List<Double> expected = Arrays.asList(3125D, 46656D, 823543D);
        assertThat(result).containsAll(expected);
    }

}