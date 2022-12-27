package ru.job4j.tracker;

/**
 * Проект Трекер - Разрыв зависимости StartUI от Scanner
 * @author Shegai Evgeni
 * @version 1.0
 * @since 27.12.2022
 */

public interface Input {

        String askStr(String question);

        int askInt(String question);

}
