package ru.job4j.search;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * Функции высшего порядка
 * @author Shegai Evgenii
 * @version 1.0
 * @since 02.01.2023
 */

public class PhoneDictionary {

    private List<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public List<Person> find(String key) {
        Predicate<Person> name = x -> x.getName().equals(key);
        Predicate<Person> surname = x -> x.getSurname().equals(key);
        Predicate<Person> phone = x -> x.getPhone().equals(key);
        Predicate<Person> address = x -> x.getAddress().equals(key);
        Predicate<Person> combine = name.or(surname.or(phone.or(address)));
        ArrayList<Person> result = new ArrayList<>();
        for (Person person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }

        return result;
    }
}
