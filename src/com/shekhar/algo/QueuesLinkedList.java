package com.shekhar.algo;

public class QueuesLinkedList<Item> {

	class Node{
		Item data;
		Node next;
	}
	
	Node first = null;
	Node last = null;
	
	public void enqueue(Item value){
		Node new_last = new Node();
		new_last.data = value;
		if(isEmpty()){
			last = new_last;
			first = last;
		}else{
			last.next = new_last;
			last = new_last;
		}
	}
	
	public Item dequeue(){
		if(last == null){
			return null;
		}
		Item value = first.data;
		first = first.next;
		if(isEmpty()){
			last = null;
		}
		return value;
	}
	
	public void display(){}
	
	private boolean isEmpty(){
		return first == null;
	}
	

}
