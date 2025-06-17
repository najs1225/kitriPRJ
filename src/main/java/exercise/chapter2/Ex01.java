package exercise.chapter2;

import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.List;

public class Ex01 {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("kim", "Lee", "Na", "Back", "hwang");

        Flux.fromIterable(strings)
                .filter(item -> item.length() < 5)
                .subscribe(System.out::println);

    }
}
