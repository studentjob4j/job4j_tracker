package ru.job4j.map;

import java.util.Map;
import java.util.Optional;
import java.util.Set;

/**
 *  Optional - empty, of
 * @author  Shegai Evgenii
 * @version 1.0
 * @since 06.01.2023
 */
public class College {

    private final Map<Student, Set<CollegeSubject>> students;

    public College(Map<Student, Set<CollegeSubject>> students) {
        this.students = students;
    }

    public Optional<Student> findByAccount(String account) {
        Optional<Student> rsl = Optional.empty();
        for (Student s: students.keySet()) {
            if (account.equals(s.getAccount())) {
                rsl = Optional.of(s);
                break;
            }
        }
        return rsl;
    }

    public Optional<CollegeSubject> findBySubjectName(String account, String name) {
        Optional<CollegeSubject> rsl = Optional.empty();
        Optional<Student> s = findByAccount(account);
        if (s.isPresent()) {
            Set<CollegeSubject> subjects = students.get(s.get());
            for (CollegeSubject subj : subjects) {
                if (name.equals(subj.getName())) {
                    rsl = Optional.of(subj);
                    break;
                }
            }
        }
        return rsl;
    }
}
