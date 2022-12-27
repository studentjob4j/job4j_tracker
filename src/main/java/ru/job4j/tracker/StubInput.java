package ru.job4j.tracker;

/**
 *  Input и полиморфизм
 * @author Shegai Evgenii
 * @version 1.0
 * @since 27.12.2022
 */

public class StubInput implements Input {
    private String[] answers;
    private int position = 0;

    public StubInput(String[] answers) {
        this.answers = answers;
    }

    @Override
    public String askStr(String question) {
        return answers[position++];
    }

    @Override
    public int askInt(String question) {
        return Integer.parseInt(askStr(question));
    }
}
