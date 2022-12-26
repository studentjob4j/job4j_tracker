package ru.job4j.tracker;

import java.util.Scanner;

/**
 * Проект Трекер - добавление заявки
 * @author Shegai Evgeni
 * @version 1.0
 * @since 26.12.2022
 */
public class StartUI {

    public void init(Scanner scanner, Tracker tracker) {
        boolean run = true;
        while (run) {
            showMenu();
            System.out.print("Select ");
            int select = Integer.parseInt((scanner.nextLine()));
            if (select == 0) {
                System.out.println("=== Create a new Item ===");
                System.out.print("Enter name: ");
                String name = scanner.nextLine();
                Item item = new Item(name);
                tracker.add(item);
                System.out.println("Добавленная заявка: " + item);
            } else if (select == 6) {
                run = false;
            }
        }
    }

    private void showMenu() {
      String[] menu = {"Add new Item", "Show all items", "Edit item",
              "Delete item", "Find item by id", "Find items by name",
              "Exit Program"};
        System.out.println("Menu");
        for (int i = 0; i < menu.length; i++) {
            System.out.println(menu[i]);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tracker tracker = new Tracker();
        new StartUI().init(scanner, tracker);
    }
}