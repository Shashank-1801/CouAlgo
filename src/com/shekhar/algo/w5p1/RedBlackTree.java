package com.shekhar.algo.w5p1;


public class RedBlackTree<Key extends Comparable<Key>, Value> {

	public final boolean RED = true;
	public final boolean BLACK = false;

	class Node{
		Key key;
		Value value;
		Node right;
		Node left;
		boolean color;

		Node(Key key, Value value){
			this.key = key;
			this.value = value;
			this.color = RED;
		}
	}
	
	class List{
		Node n;
		List next;
		
		List(Node n){
			this.n = n;
		}

	}

	Node root = null;

	public void put(Key k, Value v){
		if(v==null) {
			System.out.println("Invalid entry!");
			return;
		}
		System.out.println("trying to put " + k + " : "+ v);
		root = insert(root, k,v);
	}

	public Node insert(Node r, Key k, Value v){
		Node temp = r;
		while(temp!=null){
			int cmp = compare(k, temp.key);
			if(cmp < 0){ 
				temp.left = insert(temp.left,k,v);
				if(isRed(temp.left) && isRed(temp.left.left)) {
					temp = rotateRight(temp);
					temp = flipColor(temp);
				}
				return temp;
			}
			else if(cmp > 0){
				temp.right = insert(temp.right,k,v);
				if(isRed(temp.left) && isRed(temp.right)){
					temp = flipColor(temp);
				}else if(isRed(temp.right)){
					temp = rotateLeft(temp);
				}
				return temp;
			}
			else {
				temp.value = v;
				return temp;
			}
		}

		temp = new Node(k, v);
		return temp;
	}

	public Value get(Key k){
		Node temp = root;
		while(temp!=null){
			int cmp = compare(k, temp.key);
			if(cmp < 0)
				temp = temp.left;
			else if(cmp > 0)
				temp = temp.right;
			else
				return temp.value;
		}
		return null;
	}


	public boolean contains(Key key){
		Node temp = root;
		while(temp!=null){
			int cmp = compare(key, temp.key);
			if(cmp < 0)
				temp = temp.left;
			else if(cmp > 0)
				temp = temp.right;
			else
				return true;
		}
		return false;
	}

	public boolean isEmpty(){
		return root == null;
	}

	public void display(){
		System.out.println("--------PRE ORDER--------");
		display(root);
	}
	
	public void displayInOrder(){
		System.out.println("--------IN ORDER--------");
		displayInOrder(root);
	}

	
//	public void displayLevelOrder(){
//		System.out.println("--------LEVEL ORDER--------");
//		List l = new List(root);
//		displayLevelOrder(l);
//		
//	}
//	
//	private Node displayLevelOrder(List rt){
//		if( rt.n == null) return null;
//		List new_rt;
//		while(rt!=null){
//			Node r = rt.n;
//
//			if(compare(r.key, root.key) == 0){
//				System.out.println(r.key + ":" +r.value + " *ROOT* ");
//			}else if(r.color==RED){
//				System.out.println("RED --> "+ r.key + ":" +r.value);
//			}
//			else{
//				System.out.println(r.key + ":" +r.value);
//			}
//
//			rt = rt.next;
//		}
//		
//		return null;
//	}
//	
//	private void add(Node x, List l){
//
//	}
	
	private void displayInOrder(Node r){
		if(r == null) return;
		if(compare(r.key, root.key) == 0){
			System.out.println(r.key + ":" +r.value + " *ROOT* ");
		}else if(r.color==RED){
			System.out.println("RED --> "+ r.key + ":" +r.value);
		}
		else{
			System.out.println(r.key + ":" +r.value);
		}
		displayInOrder(r.left);
		displayInOrder(r.right);
	}

	private void display(Node r){
		if(r==null) return;
		display(r.left);
		if(compare(r.key, root.key) == 0){
			System.out.println(r.key + ":" +r.value + " *ROOT* ");
		}else if(r.color==RED){
			System.out.println("RED --> "+ r.key + ":" +r.value);
		}
		else{
			System.out.println(r.key + ":" +r.value);
		}
		display(r.right);
	}

	
	public int compare(Key a, Key b){
		return a.compareTo(b);	
	}

	private boolean isRed(Node n){
		if(n==null) return false;
		else if(n.color == RED) return true;
		else return false;
	}

	private Node rotateLeft(Node a){
		Node b = a.right;
		if(b.color != RED) System.out.println("Something was wrong as node was not red - rotate left");

		a.right = b.left;
		b.left = a;
		b.color = a.color;
		a.color = RED;
		return b;
	}

	private Node rotateRight(Node b){
		Node a= b.left;
		if(a.color != RED) System.out.println("Something was wrong as node was not red - rotate right");

		b.left = a.right;
		a.right = b;
		a.color = b.color;
		b.color = RED;
		return a;		
	}

	private Node flipColor(Node n){ 	//nodes will split
		Node a = n.left;
		Node b = n.right;
		if(a.color!=RED || b.color!=RED) System.out.println("Nodes are not red but still we are spliting them!");

		a.color = BLACK;
		b.color = BLACK;
		n.color = RED;

		return n;
	}
}
