package ru.job4j.lambda;

import java.util.function.Supplier;

/**
 * Зона видимости в лямбда-выражениях и исключения
 * @author Shegai Evgenii
 * @version 1.0
 * @since 02.01.2023
 */

public class ScopeInside {

        public static void main(String[] args) {
            int[] number = {1, 2, 3};
            int total = 0;
            int value = total;
            for (int i = 0; i < number.length; i++) {
                int num = number[i];
                total = add(
                        () -> value + num
                );
            }
            System.out.println(total);
        }

        private static Integer add(Supplier<Integer> calc) {
            return calc.get();
        }
}
