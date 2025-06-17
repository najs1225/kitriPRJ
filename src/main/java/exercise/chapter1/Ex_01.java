package exercise.chapter1;

import java.util.Arrays;
import java.util.List;

public class Ex_01 {
    public static void main(String[] args) {

        List<Employee> employees = Arrays.asList(
                new Employee("김개발", "IT", 5000, 28),
                new Employee("이기획", "기획", 4500, 32),
                new Employee("박디자인", "디자인", 4800, 26),
                new Employee("최개발", "IT", 6000, 35),
                new Employee("정마케팅", "마케팅", 4200, 29)
        );

        //IT 부서의 연봉 4500이상의 직원의 연봉을 10프로 인상하여 리스트로 반환하여 출력하라
        employees.stream()
                .filter(emp -> emp.getDepartment().equals("IT"))
                .filter(emp -> emp.getSalary()>= 4500 )
                .map(emp -> new Employee(
                        emp.getName(),
                        emp.getDepartment(),
                        emp.getSalary()*1.1,
                        emp.getAge()

                ))
                .forEach(System.out::println);
    }
}
