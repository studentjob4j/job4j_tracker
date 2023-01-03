package ru.job4j.stream;

import java.util.Objects;

/**
 * Перенос методов в Stream API
 * @author Shegai Evgenii
 * @version 1.0
 * @since 04.01.2023
 */

public class Label {

    private String name;

    private float price;

    public Label(String name, float price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Label label = (Label) o;
        return Float.compare(label.price, price) == 0
                && Objects.equals(name, label.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }

    @Override
    public String toString() {
        return "Label{"
                + "name='" + name + '\''
                + ", price=" + price
                + '}';
    }
}
