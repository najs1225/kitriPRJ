package exercise.chapter2;

import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ex02 {
    public static void main(String[] args) {
        List<User> users = Arrays.asList(
                new User("user1", "김개발", "ADMIN"),
                new User("user2", "이설계", "USER"),
                new User("user3", "박테스트", "USER"),
                new User("user4", "최디버그", "DEVELOPER"),
                new User("user5", "한기획", "PLANNER"),
                new User("user6", "정운영", "OPERATOR"),
                new User("user7", "오보안", "SECURITY"),
                new User("user8", "유디자인", "DESIGNER"),
                new User("user9", "장기획", "PLANNER"),
                new User("user10", "노인턴", "INTERN"),
                new User("user11", "서리더", "ADMIN"),
                new User("user12", "문기획", "USER"),
                new User("user13", "황테스트", "TESTER"),
                new User("user14", "조매니저", "MANAGER"),
                new User("user15", "강프론트", "FRONTEND")

        );

        //user 모두를 userDTO 로 변경하여라 password 를 추가해야하는데, 1234 로 일괄추가한다.
        //1.틀- 딱 (근데 이것도 좋은듯 ㅋ)
        List<UserDTO> newUsers = new ArrayList<>();
        for(User user : users){
            newUsers.add(new UserDTO(user.getId(), user.getName(), user.getRole(), "1234"));
        }
        System.out.println("userDTO List : "+ newUsers);

        //2.자바 스트림 이용해보기
        users.stream()
                .map(user -> new UserDTO(user.getId(), user.getName(), user.getRole(), "1234"))
                .forEach(System.out::println);

        //2.리액터 사용
        Flux.fromIterable(users)
                .map(user -> new UserDTO(user.getId(), user.getName(), user.getRole(), "1234"))
                .subscribe(System.out::println);

        Flux.fromIterable(users)
                .doOnNext(user -> System.out.println("1. user list  : "+user))
                .filter(user -> user.getRole().equals("ADMIN"))
                .doOnNext(user -> System.out.println("2. filtered user list  : "+user))
                .subscribe();

    }
}
