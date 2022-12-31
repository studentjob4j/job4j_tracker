package ru.job4j.ooa;

/**
 * final
 * @author Shegai Evgenii
 * @version 1.0
 * @since 31.12.2022
 */

public class Airport {

    public static void main(String[] args) {
        final AirBus airbus = new AirBus("A320");
        System.out.println(airbus);
        airbus.printModel();
        airbus.printCountEngine();
        airbus.setName("A380");
        System.out.println(airbus);
        airbus.printModel();
        airbus.printCountEngine();
    }
}
