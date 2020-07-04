package ru.job4j.tracker;

import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

public class StartUI {

    public void init(Scanner scanner, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            System.out.print("Выберите пункт меню");
            int select = Integer.parseInt(scanner.nextLine());
            if (select == 0) {
                System.out.println("Создаем новую заявку");
                System.out.print("Введите имя заявки");
                String name = scanner.nextLine();
                Item item = new Item();
                item.setName(name);
                Item result = tracker.add(item);
                System.out.println("Заявка добавлена " + result.getName());
            } else if (select == 1) {
                System.out.println("Вывод всех заявок ");
                    Item[] result = tracker.findAll();
                for (int i = 0; i < result.length ; i++) {
                    System.out.println(result[i].getName());
                }
            } else if (select == 2) {
                System.out.println("Редактирую заявку. Введите id заявки");
                int temp = Integer.parseInt(scanner.nextLine());
                System.out.println("Введите имя новой заявки");
                String temp2 = scanner.nextLine();
                Item item = new Item();
                item.setName(temp2);
                if (tracker.replace(temp, item)) {
                    System.out.println("Заявка успешно изменена");
                } else {
                    System.out.println("Введите правильные данные");
                }
            } else if (select == 3) {
                System.out.println("Удаление заявки. Введите id удаляемой заявки");
                int temp = Integer.parseInt(scanner.nextLine());
                if (tracker.delete(temp)) {
                    System.out.println("Заявка успешно удалена");
                } else {
                    System.out.println("Введите правильные данные");
                }
            } else if (select == 4) {
                System.out.println("Поиск заявки по id. Введите id ");
                int temp = Integer.parseInt(scanner.nextLine());
                Item result = tracker.findById(temp);
                if (result != null) {
                    System.out.println("Заявка наидена " + result.getName());
                } else {
                    System.out.println("Заявка не найдена");
                }
            } else if (select == 5) {
                System.out.println("Поиск заявок по имени. Введите имя заявки");
                String temp = scanner.nextLine();
                Item[] result = tracker.findByName(temp);
                for (int i = 0; i < result.length; i++) {
                    System.out.println("Вывод заявок с таким именем " + result[i].getName() );
                }
            } else if (select == 6) {
                run = false;
            }
        }
    }

    private void showMenu() {
        System.out.println("Меню");
        System.out.println("0. Добавление новой заявки");
        System.out.println("1. Показать все заявки");
        System.out.println("2. Редактируем заявку");
        System.out.println("3. Удаляем заявку");
        System.out.println("4. Нахождение заявки по id");
        System.out.println("5. Находим заявку по имени");
        System.out.println("6. Выход");
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tracker tracker = new Tracker();
        new StartUI().init(scanner, tracker);
    }
}
