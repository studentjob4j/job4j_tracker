package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Перенос методов в Stream API
 * @author Shegai Evgenii
 * @version 1.0
 * @since 04.01.2023
 */

public class ProductLabel {

    public List<String> generateLabels(List<Product> products) {
        return products.stream()
                .filter(x -> (x.getStandard() - x.getActual()) <= 3)
                .filter(x -> x.getStandard() - x.getActual() >= 0)
                .map(x -> new Label(x.getName(), x.getPrice() / 2))
                .map(Label::toString)
                .collect(Collectors.toList());
    }
}
