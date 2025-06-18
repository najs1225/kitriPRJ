package exercise.chapter2;

import reactor.core.publisher.Flux;

public class Ex05 {
    public static void main(String[] args) {
        Flux.just(5,7,0,3,2)
                .map(num -> 10 /num)
                .onErrorMap(ArithmeticException.class, err -> new RuntimeException())
                .subscribe(System.out::println);

    }
}
