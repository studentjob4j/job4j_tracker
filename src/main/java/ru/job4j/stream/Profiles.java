package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Список адресов
 * @author Shegai Evgenii
 * @version 1.0
 * @since 04.01.2023
 */

public class Profiles {

    public static List<Address> collect(List<Profile> profiles) {
        return profiles.stream().map(Profile::getAddress).collect(Collectors.toList());
    }
}
