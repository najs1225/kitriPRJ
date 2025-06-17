package exercise.chapter2;

import reactor.core.publisher.Flux;

public class Ex04 {
    public static void main(String[] args) {
        Flux<String> sentences = Flux.just("Hello World", "Reactive Programming");

        sentences.flatMap(sentence -> {
           String[] words = sentence.split(" ");
           return Flux.fromArray(words);
        })
        .subscribe(words -> System.out.println(word))


    }
}
