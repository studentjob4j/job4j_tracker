package ru.job4j.queue;

import java.util.Queue;

/**
 * Интерфейс Queue
 * @author Shegai Evgenii
 * @version 1.0
 */

public class AppleStore {

    private final Queue<Customer> queue;

    private final int count;

    public AppleStore(Queue<Customer> queue, int count) {
        this.queue = queue;
        this.count = count;
    }

    public String getLastHappyCustomer() {
        for (int i = 1; i < count; i++) {
            queue.poll();
        }
        return queue.poll().name();
    }

    public String getLastUpsetCustomer() {
        for (int i = 1; i <= count; i++) {
            queue.poll();
        }
        return queue.poll().name();
    }
}
