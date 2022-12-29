package ru.job4j.tracker;

/**
 * Обеспечить бесперебойную работу приложения Tracker
 * @author Shegai Evgeni
 * @version 1.0
 * @since 30.12.2022
 */

public class ValidateInput extends ConsoleInput {
    @Override
    public int askInt(String question) {
        boolean condition = true;
        int result = -1;
        do {
           try {
               result = super.askInt(question);
               condition = false;
           } catch (NumberFormatException nfe) {
               System.out.println("Please enter validate data again");
           }
        } while (condition);
        return result;
    }
}
