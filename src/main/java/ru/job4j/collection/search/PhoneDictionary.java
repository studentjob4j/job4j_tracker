package ru.job4j.collection.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {

    private ArrayList<Person> persons = new ArrayList<Person>();

    public void add(Person person) {
        this.persons.add(person);
    }

    /**
     * Вернуть список всех пользователей, который содержат key в любых полях.
     * @param key Ключ поиска.
     * @return Список подощедщих пользователей.
     */
    public ArrayList<Person> find(String key) {
        Predicate<Person> one = x -> x.getName().contains(key);
        Predicate<Person> two = x -> x.getSurname().contains(key);
        Predicate<Person> three = x -> x.getPhone().contains(key);
        Predicate<Person> four = x -> x.getAddress().contains(key);
        Predicate<Person> combine = one.or(two.or(three.or(four)));
        ArrayList<Person> result = new ArrayList<>();
        for (var person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}
