package net.cserny.recipe;

import java.util.Arrays;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PredicateDemo {

    public static final Predicate<String> LENGTH_FIVE = s -> s.length() == 5;
    public static final Predicate<String> STARTS_WITH = s -> s.startsWith("A");

    public static void main(String[] args) {
        String[] names = Stream.of("Leo", "Sabyx", "Matei", "Alis", "Andrei", "Adriana").sorted().toArray(String[]::new);

        String lengthFilter = Arrays.stream(names).filter(LENGTH_FIVE)
                .collect(Collectors.joining(", "));
        System.out.println(lengthFilter);

        String startsFilter = Arrays.stream(names).filter(STARTS_WITH)
                .collect(Collectors.joining(", "));
        System.out.println(startsFilter);
    }
}
