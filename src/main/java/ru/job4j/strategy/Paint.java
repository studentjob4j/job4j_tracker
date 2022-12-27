package ru.job4j.strategy;

/**
 * Strategy pattern
 * @author Shegai Evgeni
 * @version 1.0
 * @since 17.12.2022
 */

public class Paint {

    public void draw(Shape shape) {
        System.out.println(shape.draw());
    }

    public static void main(String[] args) {
        Paint context = new Paint();
        context.draw(new Triangle());
        context.draw(new Square());
    }
}
