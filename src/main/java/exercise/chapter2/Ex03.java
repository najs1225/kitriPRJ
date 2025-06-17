package exercise.chapter2;

import reactor.core.publisher.Flux;

public class Ex03 {
    public static void main(String[] args) {
        /*
        Flux<String> nameStream = Flux.just("Kim", "Lee", "Park");

        Flux<String> upperNameStream = nameStream.map(String::toUpperCase);
        upperNameStream.subscribe(
                data -> System.out.println(data),
                error -> System.out.println(error), //on error
                () -> System.out.println("데이터가 모두 전송되었습니다.") //onComplete
        );
        */

        //다음과 같이 더 간결하게 할 수 있다 .
        Flux.just("Kim", "Lee", "Park")
                .map(String::toUpperCase)
                .subscribe();

    }
}
