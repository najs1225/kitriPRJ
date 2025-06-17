package exercise.chapter2;

import reactor.core.publisher.Flux;

public class Ex04 {
    public static void main(String[] args) {
        //flatMap 예제 : 문장을 단어로 변환, 순서를 보장하지 않음
        //concatMap 의 경우 순서를 보장함
        Flux<String> sentences = Flux.just("Hello World", "Reactive Programming");

        sentences.flatMap(sentence -> {
           String[] words = sentence.split(" ");
           return Flux.fromArray(words);
        })
        .subscribe(System.out::println);


    }
}
