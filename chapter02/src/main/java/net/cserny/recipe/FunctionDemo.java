package net.cserny.recipe;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FunctionDemo {

    public static void main(String[] args) {
        mappingStringsToTheirLengths();
    }

    private static void mappingStringsToTheirLengths() {
        Function<String, Integer> nameLengthFunction = String::length;

        List<String> names = Arrays.asList("Mal", "Wash", "Kaylee", "Inara", "Zoe", "Jayne", "Simon", "River");
        List<Integer> nameLengths = names.stream().map(nameLengthFunction).collect(Collectors.toList());
        System.out.printf("Name lengths: %s%n", nameLengths);
    }
}
