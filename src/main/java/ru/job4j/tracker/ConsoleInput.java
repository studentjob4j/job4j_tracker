package ru.job4j.tracker;

import java.util.Scanner;

/**
 * Проект Трекер - Разрыв зависимости StartUI от Scanner
 * @author Shegai Evgeni
 * @version 1.0
 * @since 27.12.2022
 */

public class ConsoleInput implements Input {

    private Scanner scanner = new Scanner(System.in);

    @Override
    public String askStr(String question) {
        System.out.print(question);
        return scanner.nextLine();
    }

    @Override
    public int askInt(String question) {
        return Integer.parseInt(askStr(question));
    }
}
