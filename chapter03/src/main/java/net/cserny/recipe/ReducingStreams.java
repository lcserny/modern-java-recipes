package net.cserny.recipe;

import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class ReducingStreams {

    public static void main(String[] args) {
        reducingToAValue();
        moreReducing();
    }

    private static void moreReducing() {
        int sum = IntStream.rangeClosed(1, 10)
                .reduce((x, y) -> x + y).orElse(0);
        System.out.println(sum);

        sum = IntStream.rangeClosed(1, 10)
                .reduce((x, y) -> {
                    System.out.printf("x=%d, y=%d\n", x, y);
                    return x + y;
                }).orElse(0);
        System.out.println(sum);

        sum = IntStream.rangeClosed(1, 10)
                .reduce(0, Integer::sum);
        System.out.println(sum);
    }

    private static void reducingToAValue() {
        String[] strings = "this is an array of strings".split(" ");
        long count = Arrays.stream(strings)
                .map(String::length)
                .count();
        System.out.println("There are " + count + " strings");

        int totalLength = Arrays.stream(strings)
                .mapToInt(String::length)
                .sum();
        System.out.println("The total length is " + totalLength);

        OptionalDouble average = Arrays.stream(strings)
                .mapToInt(String::length)
                .average();
        System.out.println("The average length is " + average.orElse(0));

        OptionalInt max = Arrays.stream(strings)
                .mapToInt(String::length)
                .max();
        OptionalInt min = Arrays.stream(strings)
                .mapToInt(String::length)
                .min();
        System.out.println("The max and min lengths are " + max.orElse(0) + ", " + min.orElse(0));
    }
}
