package com.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamApiTest {
	
	public static void main(String args[]){
		
		List<Integer> list = new ArrayList();
		
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		
		List newList = list.stream().filter(i -> i%2 ==0).collect(Collectors.toList());
		
		//Integer j = list.stream().filter(i -> i%2 ==0).findFirst().orElse(0);
		
		//Optional<Integer> j = list.stream().filter(i -> i%2 ==0).findFirst();
		
		//System.out.println(list.stream().map(i -> i*i).reduce(0,(c,e) -> c+e));
		
		int[] intArr = new int[]{4,3,6,4,8,9};
		
		
		//IntStream.of(intArr).sorted().distinct().limit(3).forEach(System.out::println);
		
		List<Integer> li = IntStream.of(intArr).distinct().sorted().limit(3).boxed().collect(Collectors.toList());
		System.out.println(li);
		
		//System.out.println(IntStream.of(intArr).anyMatch(i -> i%2 == 0));
		//System.out.println(IntStream.of(intArr).allMatch(i -> i%2 == 0));
		
		
		List<String> items =
                Arrays.asList("apple", "apple", "banana",
                        "apple", "orange", "banana", "papaya");

        Map<String, Long> result =
                items.stream().collect(
                        Collectors.groupingBy(x ->x, Collectors.counting())
                );
        System.out.println(result);
        
        Map<String, Long> finalMap = new LinkedHashMap<>();
        
        result.entrySet().stream().sorted(Map.Entry.<String,Long>comparingByValue().reversed()).forEachOrdered(e -> finalMap.put(e.getKey(), e.getValue()));

        System.out.println(finalMap);
	}

}
