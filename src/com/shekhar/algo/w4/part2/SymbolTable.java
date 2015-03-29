package com.shekhar.algo.w4.part2;

public class SymbolTable<Key, Value> {
	
	class STNode{
		Key key;
		Value value;
		STNode next;
		
		STNode(){
			key = null;
			value = null;
			next = null;
		}
		
	}

	STNode first;
	
	public SymbolTable(){
		first = null;
	}
	
	public void put(Key k, Value v){
		if(v==null){
			System.out.println("Invalid entry!");
			return;
		}
		if(first == null){
			STNode n = new STNode();
			n.key = k;
			n.value = v;

			first = n;
			return;
		}
		
		STNode temp =first;
		while(temp.key!= k && temp.next!=null){
			temp = temp.next;
		}
		
		if(temp.key==k){
			temp.value = v;
		}
		else if(temp.next == null){
			STNode n = new STNode();
			n.key = k;
			n.value = v;

			temp.next = n;
		}
	}
	
	public Value get(Key key){
		STNode temp = first;
		
		while(temp.next!=null && temp.key!= key){
			temp = temp.next;
		}
		if(temp.key==key){
			return temp.value;
		}else {
			return null;
		}
		
	}
	
	public void delete(Key key){
		STNode temp = first;
		
		while(temp.next!=null && temp.key!= key){
			temp = temp.next;
		}
		if(temp.key==key){
			temp.value = null;
		}else {
			System.out.println("Invalid Key!");
			return;
		}
	}

	public boolean contains(Key key){
		STNode temp = first;
		while(temp.next!=null && temp.key!= key){
			temp = temp.next;
		}
		if(temp.key==key){
			return true;
		}
		return false;
	}
	
	public boolean isEmpty(){
		return first==null;
	}
	
	public int size(){
		if(isEmpty()){
			return 0;
		}
		
		STNode temp = first;
		int count = 0;
		while(temp!=null){
			count++;
			temp = temp.next;
		}
		return count;
	}
	
	public void display(){
		STNode temp = first;
		while(temp!=null){
			System.out.println(temp.key + ":" + temp.value);
			temp = temp.next;
		}
		
	}

//	public Iterable<Key> key(){
//		
//	}
}
