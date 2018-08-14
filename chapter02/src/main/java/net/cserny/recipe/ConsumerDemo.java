package net.cserny.recipe;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerDemo {

    public static void main(String[] args) {
        printingElementsOfCollections();
    }

    private static void printingElementsOfCollections() {
        List<String> strings = Arrays.asList("this", "is", "a", "list", "of", "strings");

        // A
        strings.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });

        // B
        strings.forEach(s -> System.out.println(s));

        // C
        strings.forEach(System.out::println);
    }
}
