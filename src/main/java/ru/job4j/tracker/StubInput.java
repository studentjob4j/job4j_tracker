package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

public class StubInput  implements Input {

    private List<String> answers = new ArrayList<>();
    private int position = 0;

    public StubInput(ArrayList<String> answers) {
        this.answers = answers;
    }

    @Override
    public String askStr(String question) {
        return answers.get(position++);
    }

    @Override
    public int askInt(String question) {
        return Integer.parseInt(askStr(question));
    }
}
