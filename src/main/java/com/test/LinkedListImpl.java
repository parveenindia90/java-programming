package com.test;

import java.util.ArrayList;
import java.util.List;

public class LinkedListImpl {

	static class Node{
		 
		int data;
		Node next;
		
		Node(int data){
			this.data = data;
			next = null;
		}
	}
	
	Node head;
	
	public static void main(String[] args){
		 
		 LinkedListImpl list = new LinkedListImpl(); 
		 
		 insert(list,1);
		 insert(list,2);
		 insert(list,3);
		 insert(list,4);
		 insert(list,5);
		 insert(list,6);
		 insert(list,7);
		 insert(list,8);
		 insert(list,9);
		 
		 printList(list);
		 
		 findMiddleElement(list);
		 
		 reverseLinkedList(list);
		 printList(list);
		 
		 findNthelement(list,2);
		 
		 findNthelementFromLast(list,5);
		 
		 detectLoopInLinkedList(list);
		 
		 LinkedListImpl list1 = new LinkedListImpl(); 
		 
		 insert(list1,4);
		 insert(list1,6);
		 insert(list1,-10);
		 insert(list1,8);
		 insert(list1,9);
		 insert(list1,10);
		 insert(list1,-19);
		 insert(list1,10);
		 insert(list1,-18);
		 insert(list1,20);
		 insert(list1,25);
		 
		 removeElemmendsWithZeroSum(list1);
		 
		 deleteMiddleElement(list1);
		 
		 printList(list1);
	 }

	private static void deleteMiddleElement(LinkedListImpl list) {
		
		Node slow = list.head;
		Node fast = list.head;
		Node prev = null;
		while(fast != null && fast.next != null){
			prev = slow;
			slow = slow.next;
			fast = fast.next.next;
		}
		
		prev.next = slow.next;
		
	}

	private static void removeElemmendsWithZeroSum(LinkedListImpl list1) {
		
		Node start = list1.head;
		List<Integer> res = new ArrayList<>();
		while(start != null){
			int sum = 0;
			boolean mod = false;
			Node end = start;
			while(end != null){
				sum += end.data;
				
				if(sum == 0){
					start = end;
					mod = true;
					break;
				}
				end = end.next;
			}
			
			if(!mod){
				res.add(start.data);
			}
			start = start.next;
			
		}
		res.forEach(System.out::println);
		
		
	}

	private static void detectLoopInLinkedList(LinkedListImpl list) {
		
		Node slow = list.head;
		Node fast = list.head;
		
		while(fast != null && fast.next != null){
			slow = slow.next;
			fast = fast.next.next;
			if(slow == fast){
				System.out.println("Loop");
				return;
			}
		}
		
		System.out.println("No Loop");
		
		
	}

	private static void findNthelementFromLast(LinkedListImpl list, int i) {
		
		Node currentNode = list.head;
		Node fastNode = list.head;
		
		for(int j=1;j<i;j++){
			if(fastNode.next != null){
				fastNode = fastNode.next;
			}else{
				System.out.println("No Such Position");
			}
		}
		
		while(fastNode.next != null){
			fastNode = fastNode.next;
			currentNode = currentNode.next;
		}
		
		System.out.println(currentNode.data);
		
		
	}

	private static void findNthelement(LinkedListImpl list, int i) {
		
		Node currentNode = list.head;
		if(currentNode == null){
			System.out.println("Empty List");
			return;
		}
		int counter = 1;
		while(currentNode != null){
			if(i == counter){
				System.out.println("Element at position "+i+" is "+currentNode.data);
				return;
			}else{
				counter++;
				currentNode = currentNode.next;
			}
		}
		
		System.out.println("Position does not exists");
		
	}

	private static void reverseLinkedList(LinkedListImpl list) {
		 
		Node currentNode = list.head;
		Node next = null;
		Node prev = null;
		if(currentNode == null){
			return;
		}
		while(currentNode != null){
			next = currentNode.next;
			currentNode.next = prev;
			prev = currentNode;
			currentNode = next;
		}
		
		list.head = prev;
		
	}

	private static void findMiddleElement(LinkedListImpl list) {
		
		Node firstNode = list.head;
		Node secondNode = list.head;
		
		while(secondNode != null && secondNode.next != null){
			firstNode = firstNode.next;
			secondNode = secondNode.next.next;
		}

        System.out.println(firstNode != null? firstNode.data : "Not present");
		
	}

	private static void printList(LinkedListImpl list) {

		Node currentNode = list.head;
		if(list.head == null){
			System.out.println("List is empty");
			return;
		}
		
		while(currentNode != null){
			System.out.println(currentNode.data);
			currentNode = currentNode.next;
		}
	}

	private static void insert(LinkedListImpl list, int i) {

		  Node node = new Node(i);
		  if(list.head == null){
			  list.head = node;
		  }else{
			  Node last = list.head;
			  while(last.next != null){
				  last = last.next;
			  }
			  last.next = node;
		  }
		  
	}
}
