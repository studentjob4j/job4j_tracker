package ru.job4j.ooa;

/**
 * final
 * @author Shegai Evgenii
 * @version 1.0
 * @since 31.12.2022
 */

public final class AirBus extends Aircraft {

    private static int countEngine = 2;

    private String name;

    public AirBus(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void printCountEngine() {
        countEngine = this.name.equals("A380") ? 4 : 2;
        System.out.println("Количество двигателей равно : " + countEngine);
    }

    @Override
    public String toString() {
        return "Airbus{"
                + "name='" + name + '\''
                + '}';
    }
}
