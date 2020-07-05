package ru.job4j.tracker;

public class StartUI {



    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            int select = input.askInt("Выберите пункт меню   ");
            System.out.println();
            if (select == 0) {
                System.out.println("Создаем новую заявку");
                String name = input.askStr("Введите имя заявки");
                Item item = new Item();
                item.setName(name);
                Item result = tracker.add(item);
                System.out.println("Заявка добавлена " + result.getName());
            } else if (select == 1) {
                System.out.println("Вывод всех заявок ");
                    Item[] result = tracker.findAll();
                    if (result.length > 0) {
                for (int i = 0; i < result.length ; i++) {
                    System.out.println(result[i].getName());
                }
                    } else {
                        System.out.println("Заявки с таким именем не найдены ");
                    }
            } else if (select == 2) {
                System.out.println();
                int temp = input.askInt("Редактирую заявку. Введите id заявки");
                System.out.println();
                String temp2 = input.askStr("Введите имя новой заявки");
                Item item = new Item();
                item.setName(temp2);
                if (tracker.replace(temp, item)) {
                    System.out.println("Заявка успешно изменена");
                } else {
                    System.out.println("Введите правильные данные");
                }
            } else if (select == 3) {
                int temp = input.askInt("Удаление заявки. Введите id удаляемой заявки");
                System.out.println();
                if (tracker.delete(temp)) {
                    System.out.println("Заявка успешно удалена");
                } else {
                    System.out.println("Введите правильные данные");
                }
            } else if (select == 4) {
                int temp = input.askInt("Поиск заявки по id. Введите id ");
                System.out.println();
                Item result = tracker.findById(temp);
                if (result != null) {
                    System.out.println("Заявка наидена " + result.getName());
                } else {
                    System.out.println("Заявка не найдена");
                }
            } else if (select == 5) {
                String temp = input.askStr("Поиск заявок по имени. Введите имя заявки");
                System.out.println();
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
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }
}
