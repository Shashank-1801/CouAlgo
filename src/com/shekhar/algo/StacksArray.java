package com.shekhar.algo;

public class StacksArray {

	String[] s;
	private int head;
	
	public StacksArray(){
		s = new String[1];
		head = 0;
	}

	public void display(){
		for(int i=0; i<s.length; i++){
			System.out.print(s[i] + " ");
		}
	}

	public void push(String item){
		if(head == s.length){
			resize();
		}
		s[head] = item;
		head++;
	}

	public String pop(){
		head--;
		String value =  s[head];
		s[head] = null;
		if(head == (s.length/4)){
			resize();
		}
		return value;
	}

	private void resize(){
		String[] new_stack = null;
		int old_len = s.length;
		if(head == old_len){
			new_stack = new String[old_len*2];
		}else if(head == (old_len/4)){
			new_stack = new String[old_len/2];
		}
		for(int i=0; i<head; i++){
			new_stack[i] = s[i];
		}
		s = new_stack;
	}
}
