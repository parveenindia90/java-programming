package com.test;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamsExercise {

    public static void main(String[] args) {
        List<Integer> list = List.of(1,2,3,4,5,6,7,8,3,5,7);
        //find greatest
        list.stream().max(Integer::compare).ifPresent(System.out::println);
        list.stream().sorted(Collections.reverseOrder()).distinct().findFirst().ifPresent(System.out::println);
        //filter even numbers
        list.stream().filter(x -> x%2 ==0).forEach(System.out::println);
        //find sum
        System.out.println(list.stream().reduce(0, Integer::sum));
        //convert to hashmap
        Map<Integer, Long> map = list.stream().collect(Collectors.groupingBy(num -> num, Collectors.counting()));
        map.forEach((key, value) -> System.out.println(key + " " + value));

        List<Employee> empList = new ArrayList<>();

        empList.add(new Employee(103,"Parveen",6000.0,"M","India","INR"));
        empList.add(new Employee(102,"Jitendra",3000.0,"F","America","USD"));
        empList.add(new Employee(101,"Rohit",9000.0,"M","France","EUR"));
        empList.add(new Employee(104,"Tinku",7000.0,"F","India","INR"));
        empList.add(new Employee(105,"Parveen",10000.0,"M","India","INR"));

        //convert to map where id is emp name and value is empSalary
        empList.stream().collect(Collectors.toMap(Employee::getEmpName, Employee::getEmpSalary,(oldVal, newVal) -> newVal)).forEach((key, value) -> System.out.println(key + " " +value));
        //find one employee with salary greater than 5000
        empList.stream().filter(emp -> emp.getEmpSalary() >= 5000).findFirst().ifPresent(System.out::println);
        //sort employees based on salary and return names of employees
        System.out.println(empList.stream().sorted(Comparator.comparingDouble(Employee::getEmpSalary)).map(Employee::getEmpName).collect(Collectors.joining(",")));
        //group employee by region
        empList.stream().collect(Collectors.groupingBy(Employee::getRegion)).forEach((key, value) -> System.out.println(key + " " + value));
        //double grouping by region and gender
        empList.stream().collect(Collectors.groupingBy(Employee::getRegion, Collectors.groupingBy(Employee::getGender))).forEach((key, value) -> System.out.println(key + " " + value));

    }

}
