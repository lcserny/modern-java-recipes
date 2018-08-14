package net.cserny.recipe;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.DoubleSupplier;
import java.util.function.Supplier;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class SupplierDemo {

    public static void main(String[] args) {
        usingMmathRandom();
        findingNameInCollection();
    }

    private static void findingNameInCollection() {
        List<String> names = Arrays.asList("Mail", "Wash", "Kaylee", "Inara", "Zoe", "Jayne",
                "Simon", "River", "Sheperd Book");
        Optional<String> first = names.stream()
                .filter(name -> name.startsWith("C"))
                .findFirst();

        System.out.println(first);
        System.out.println(first.orElse("None"));

        // Construct the else even if optional is not empty, performance might be bad
        System.out.println(first.orElse(String.format("No result found in %s",
                names.stream().collect(Collectors.joining(", ")))));

        // Doesn't construct the else if optional is not empty, performance good
        System.out.println(first.orElseGet(() -> String.format("No result found in %s",
                names.stream().collect(Collectors.joining(", ")))));
    }

    private static void usingMmathRandom() {
        Logger logger = Logger.getLogger("...");

        // A
        DoubleSupplier randomSupplier = new DoubleSupplier() {
            @Override
            public double getAsDouble() {
                return Math.random();
            }
        };

        // B
        randomSupplier = () -> Math.random();

        // C
        randomSupplier = Math::random;

        logger.info(String.valueOf(randomSupplier.getAsDouble()));
    }
}
