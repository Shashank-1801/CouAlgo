package com.shekhar.algo.w4.part2;

public class BST<Key extends Comparable<Key>, Value> {

	class Node{
		Key key;
		Value value;
		Node right;
		Node left;
		int c;

		Node(Key key, Value value){
			this.key = key;
			this.value = value;
		}
	}

	Node root = null;

	public void put(Key k, Value v){
		if(v==null){
			System.out.println("Invalid entry!");
			return;
		}
		root = put(root, k, v);
	}

	public Node put(Node r, Key k, Value v){
		Node temp = r;
		if(temp == null)
			return new Node(k, v);

		int cmp = compare(k, temp.key);
		if(cmp < 0) 
			temp.left = put(temp.left,k,v);
		else if(cmp > 0) 
			temp.right = put(temp.right, k, v);
		else 
			temp.value = v;
		return temp;
	}

	public Value get(Key k){
		Node temp = root;
		while(temp!=null){
			int cmp = compare(k, temp.key);
			if(cmp < 0) temp = temp.left;
			else if (cmp > 0) temp = temp.right;
			else return temp.value;
		}
		return null;
	}


//	public void delete(Key key){
//		//TODO 
//	}

	public boolean contains(Key key){
		Node temp = root;
		while(temp!=null){
			int cmp = compare(key,temp.key);
			if(cmp < 0) temp = temp.left;
			else if(cmp > 0) temp = temp.right;
			else return true;
		}
		return false;
	}
	
	public boolean isEmpty(){
		return root == null;
	}
	
//	public int size(){
//		//TODO	
//	}

//	public Iterable<Key> keys(){
//		Queue<Key> q = new Queue<Key>();
//		
//	}
//	
//	private void inorder(Node r, Queue<Key> q){
//		if(r==null) return;
//		inorder(r.left, q);
//		q.e
//	}
//
	
	public void display(){
		display(root);
	}
	
	private void display(Node r){
		if(r==null) return;
		display(r.left);
		if(compare(r.key, root.key) == 0){
			System.out.println("*ROOT* " + r.key + ":" +r.value);
		}
		System.out.println(r.key + ":" +r.value);
		display(r.right);
	}
	
	public int compare(Key a, Key b){
		return a.compareTo(b);	
	}
}
