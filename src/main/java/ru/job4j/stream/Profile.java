package ru.job4j.stream;

/**
 * Список адресов
 * @author Shegai Evgenii
 * @version 1.0
 * @since 04.01.2023
 */

public class Profile {

    private Address address;

    public Profile(Address address) {
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }
}
