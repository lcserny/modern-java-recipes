package net.cserny.recipe;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class BoxedStreams {

    public static void main(String[] args) {
        List<Integer> integers = IntStream.of(1, 2, 3, 4, 5)
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        System.out.println(integers);
    }
}
