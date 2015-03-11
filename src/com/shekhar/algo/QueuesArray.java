package com.shekhar.algo;

public class QueuesArray {
	
	String[] q;
	int head;
	int tail;
	
	public QueuesArray() {
		q = new String[10];
		head = 0;
		tail = 0;
	}
	
	public void enqueue(String value){
		if((head+1)%10 == tail){
			System.out.println("Overflow! Queue full");
			return;
		}
		q[head] = value;
		head = (head+1)%10;
	}
	

	public String dequeue(){
		if(isEmpty()){
			return "Underflow! Queue is empty";
		}
		String value = q[tail];
		tail = (tail+1)%10;
		return value;
	}
	
	public void display(){}
	
	private boolean isEmpty(){
		return head == tail;
	}
	

}
