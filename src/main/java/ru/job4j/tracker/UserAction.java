package ru.job4j.tracker;

/**
 * Проект Трекер-  Реализация меню за счет шаблона стратегия
 * @author Shegai Evgeni
 * @version 1.0
 * @since 26.12.2022
 */

public interface UserAction {

    String name();

    boolean execute(Input input, Tracker tracker);

}
