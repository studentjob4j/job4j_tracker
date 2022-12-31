package ru.job4j.queue;

import java.util.Deque;

/**
 * Интерфейс Deque
 * @author Shegai Evgenii
 * @version 1.0
 * @since 01.01.2023
 */

public class ReconstructPhrase {

    private final Deque<Character> descendingElements;

    private final Deque<Character> evenElements;

    public ReconstructPhrase(Deque<Character> descendingElements, Deque<Character> evenElements) {
        this.descendingElements = descendingElements;
        this.evenElements = evenElements;
    }

    private String getEvenElements() {
        StringBuilder builder = new StringBuilder();
        int size = evenElements.size();
        for (int i = 0; i < size; i++) {
           if (i % 2 == 0) {
               builder.append(evenElements.removeFirst());
               continue;
           }
           evenElements.removeFirst();
        }
        return builder.toString();
    }

    private String getDescendingElements() {
        StringBuilder builder = new StringBuilder();
        int size = descendingElements.size();
        for (int i = 0; i < size; i++) {
                builder.append(descendingElements.removeLast());
        }
        return builder.toString();
    }

    public String getReconstructPhrase() {
        return getEvenElements() + getDescendingElements();
    }
}
