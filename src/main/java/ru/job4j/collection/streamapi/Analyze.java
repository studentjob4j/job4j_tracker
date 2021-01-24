package ru.job4j.collection.streamapi;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Analyze {

    public static double averageScore(Stream<Pupil> stream) {

   return stream.flatMap(x -> x.getSubjects()
            .stream())
            .mapToDouble(Subject::getScore)
            .average()
            .orElse(0.0);
    }

    public static List<Tuple> averageScoreBySubject(Stream<Pupil> stream) {
        return  stream.map(x -> new Tuple(x.getName(), x.getSubjects()
                .stream()
                .mapToDouble(Subject::getScore)
                .average()
                .getAsDouble()))
                .collect(Collectors.toList());
    }

   public static List<Tuple> averageScoreByPupil(Stream<Pupil> stream) {
     return stream.flatMap(x -> x.getSubjects()
                .stream())
                .collect(Collectors.groupingBy(x -> x.getName(),
                        Collectors.averagingDouble(x -> x.getScore()))).
                     entrySet()
              .stream()
              .map(x -> new Tuple(x.getKey(), x.getValue()))
              .collect(Collectors.toList());

    }

    public static Tuple bestStudent(Stream<Pupil> stream) {
         return stream.map(x -> new Tuple(x.getName(), x.getSubjects()
                 .stream()
                 .mapToDouble(Subject::getScore)
                 .sum()))
                 .max(Comparator.comparing(x -> x.getScore()))
                 .orElse(new Tuple("нет значения", 0D));
    }

    public static Tuple bestSubject(Stream<Pupil> stream) {
        return stream.flatMap(x -> x.getSubjects()
                .stream())
                .collect(Collectors.groupingBy(x -> x.getName(), Collectors
                        .summingDouble(x ->  x.getScore()))).
                        entrySet()
                .stream()
                .map(x -> new Tuple(x.getKey(), x.getValue()))
                .max(Comparator.comparing(x -> x.getScore()))
                .orElse(null);
    }
}
