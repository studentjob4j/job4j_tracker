package ru.job4j.tracker;

/**
 * Обеспечить бесперебойную работу приложения Tracker
 * @author Shegai Evgeni
 * @version 1.0
 * @since 30.12.2022
 */

public class ValidateInput implements Input {

    private final Output out;
    private final Input in;

    public ValidateInput(Output out, Input in) {
        this.out = out;
        this.in = in;
    }

    @Override
    public String askStr(String question) {
        return in.askStr(question);
    }

    @Override
    public int askInt(String question) {
        boolean condition = true;
        int result = -1;
        do {
           try {
               result = in.askInt(question);
               condition = false;
           } catch (NumberFormatException nfe) {
               System.out.println("Please enter validate data again");
           }
        } while (condition);
        return result;
    }
}
