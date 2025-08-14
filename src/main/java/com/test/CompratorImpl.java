package com.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CompratorImpl {

	public static void main(String args[]){
		
		List<Employee> empList = new ArrayList();
		
		empList.add(new Employee(103,"Parveen",6000.0,"M","India","INR"));
		empList.add(new Employee(102,"Jitendra",3000.0,"F","America","USD"));
		empList.add(new Employee(101,"Rohit",9000.0,"M","France","EUR"));
		empList.add(new Employee(104,"Tinku",7000.0,"F","India","INR"));
		
		Comparator<Employee> com =(Employee var1, Employee var2) -> {
				return var2.getEmpId() - var1.getEmpId();
		};
		Collections.sort(empList,com);
		
		System.out.println(empList);
		
		Predicate<Employee> p2 = e-> e.getEmpId() > 101;
		
		List<Employee> names = empList.stream().filter(p2).collect(Collectors.toList());
		
		Optional<Employee> name = empList.stream().findFirst();
		System.out.println(name.get());		
		Map<Integer, String> map1 = empList.stream().collect(Collectors.toMap(Employee::getEmpId, Employee::getEmpName));
		System.out.println(map1);
		String names1 = empList.stream().sorted(Comparator.comparingDouble(Employee::getEmpSalary)).map(Employee::getEmpName).collect(Collectors.joining(","));
		
		System.out.println(names1);
		final Map<String, List<Employee>> groupedByRegionAndGender  = empList.stream().
				collect(Collectors.groupingBy(Employee::getRegion));
		
		final Map<String, Map<String, List<Employee>>> groupedByRegionAndGender1  = empList.stream().
				collect(Collectors.groupingBy(Employee::getRegion,Collectors.groupingBy(Employee::getGender)));
		
		final Map<String, Map<String, DoubleSummaryStatistics>> groupedByRegionGenderSalry  = empList.stream().
				collect(Collectors.groupingBy(Employee::getRegion,Collectors.groupingBy(Employee::getGender,Collectors.summarizingDouble(Employee::getEmpSalary))));
		
		System.out.println(groupedByRegionAndGender);
		System.out.println(groupedByRegionGenderSalry);
		
		//toMap is used to form keyValue pair from object and (c1, c2) -> c1 is used to remove duplicate keys
		Map<String, String> empMap = empList.stream()
        .collect(Collectors.toMap(Employee::getRegion, Employee::getCurrency, (c1, c2) -> c1));
		
		
		System.out.println(empMap);
		
		List<String> listOfStrings = Arrays.asList("1", "2", "3", "4", "5");
		
		List<Integer> listOfIntegers = listOfStrings.stream().map(Integer :: parseInt).collect(Collectors.toList());
		//Optional<Integer> op = listOfIntegers.stream().sorted(Collections.reverseOrder()).distinct().limit(2).skip(1).findFirst();
		Integer op = listOfIntegers.stream().min(Integer :: compareTo).get();
		System.out.println(op); 
		int sum = listOfIntegers.stream().reduce(0,Integer::sum);
		System.out.println(sum); 
		List<Integer> list1 = Arrays.asList(1,2,3);
		List<Integer> list2 = Arrays.asList(4,5,6);
		List<Integer> list3 = Arrays.asList(7,8,9);
		 
		List<List<Integer>> listOfLists = Arrays.asList(list1, list2, list3);
		
		List<Integer> listOfAllIntegers = listOfLists.stream()
                .flatMap(x -> x.stream()).map(y -> y*2)
                .collect(Collectors.toList());

		System.out.println(listOfAllIntegers); 
		
	}
}
