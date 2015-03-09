package com.shekhar.algo;

public class StacksString {
	
	private class Node{
		String item;
		Node next;
	}
	
	Node first = null;
	
	public void push(String value){
		Node first_new = new Node();
		first_new.item = value;
		first_new.next = first; 
		first = first_new;
	}
	
	public String pop(){
		if(!isEmpty()){
			String value = first.item;
			first = first.next;
			return value;
		}
		else{
			return null;
		}
	}
	
	public boolean isEmpty(){
		return (first==null);
	}

	public void display(){
		Node temp = first;
		while(temp!=null){
			System.out.println(temp.item);
			temp = temp.next;
		}
	}
}
