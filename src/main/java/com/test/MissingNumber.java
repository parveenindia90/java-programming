	package com.test;

import java.util.ArrayList;
import java.util.List;

public class MissingNumber {
 
	public static void main(String args[]){
		int[] arr = {5,5,5,5,5,5,5};
		List<Integer> list = new ArrayList<>();
		for(int i=0;i<arr.length;i++){
			int in = Math.abs(arr[i]);
			if(arr[in-1]> 0){
				arr[in-1] *= -1;
			}
		}
		for(int i=0;i<arr.length;i++){
			if(arr[i] > 0){
				list.add(i+1);
			}
		}
		list.forEach(System.out::println);
		
		/*int[] arr = {2,3,2,5,5,6,5,2};
		Map<Integer,Integer> countMap = new HashMap<>();
		Map<Integer,Integer> indexMap = new HashMap<>();
		for(int i=0;i<arr.length;i++){
			countMap.put(arr[i],countMap.containsKey(arr[i])?countMap.get(arr[i])+1:1);
			indexMap.put(arr[i], i+1);
		}
		
		int maxVal = 1;
		for(Entry<Integer,Integer> entry : countMap.entrySet()){
			if(entry.getValue() > maxVal){
				maxVal = entry.getValue();
			}
		}
		
		final int value = maxVal;
		List<Integer> maxList = countMap.entrySet().stream().filter(e -> e.getValue() == value).map(e -> e.getKey()).collect((Collectors.toList()));
		
		int minIndex = indexMap.get(maxList.get(0));
		int val =maxList.get(0);
		for(int i=1;i<maxList.size();i++){
			if(indexMap.get(maxList.get(i)) < minIndex){
				val =  maxList.get(i);
			}
		}
		
		
		System.out.println(val);*/
		
		
	}
}
