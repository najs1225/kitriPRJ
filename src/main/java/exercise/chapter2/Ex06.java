package exercise.chapter2;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class Ex06 {
    public static void main(String[] args) {
        System.out.println("현재 스레드 : "+ Thread.currentThread().getName());
        System.out.println("💻 사용 가능한 CPU 코어: " + Runtime.getRuntime().availableProcessors());

        Flux.just("실행1", "실행2", "실행3")
                .publishOn(Schedulers.single())
                .doOnNext(value -> System.out.println("스트림 생성 스레드 : "+ Thread.currentThread().getName()))
                .blockLast();

        System.out.println("==완료==");
    }
}
