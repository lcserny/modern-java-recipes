package net.cserny.recipe;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class CreatingStreams {

    public static void main(String[] args) {
        arrayStreams();
        streamIterate();
        streamGenerate();
        streamRange();
    }

    private static void streamRange() {
        List<Integer> integers = IntStream.range(10, 15).boxed()
                .collect(Collectors.toList());
        System.out.println(integers);

        List<Long> longs = LongStream.rangeClosed(10, 15).boxed()
                .collect(Collectors.toList());
        System.out.println(longs);
    }

    private static void streamGenerate() {
        Stream.generate(Math::random)
                .limit(10)
                .forEach(System.out::println);
    }

    private static void streamIterate() {
        List<BigDecimal> nums = Stream.iterate(BigDecimal.ONE, n -> n.add(BigDecimal.ONE))
                .limit(10)
                .collect(Collectors.toList());
        System.out.println(nums);

        Stream.iterate(LocalDate.now(), ld -> ld.plusDays(10L))
                .limit(10)
                .forEach(System.out::println);
    }

    private static void arrayStreams() {
        String names = Stream.of("Gomez", "Morticia", "Wednesday", "Pugsley")
                .collect(Collectors.joining(", "));
        System.out.println(names);

        String[] munsters = { "Herman", "Lily", "Eddie", "Marilyn", "Grandpa" };
        names = Arrays.stream(munsters)
                .collect(Collectors.joining(", "));
        System.out.println(names);
    }
}
