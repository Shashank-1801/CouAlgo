package com.shekhar.algo.w5p2;


public class OIBST<low extends Comparable<low>, Value> {

	Node root =null;

	public final boolean RED = true;
	public final boolean BLACK = false;

	class Node{
		low low, high;
		Value value;
		Node left, right;
		boolean color;


		Node(low low ,low high, Value value){
			this.low = low;
			this.high = high;
			this.value = value;
			this.color = RED;
		}
	}

	public void put(low low, low high, Value val){
		if(val==null) {
			System.out.println("Invalid entry!");
			return;
		}
		System.out.println("trying to put (" + low + ", " + high + ") : "+ val);
		root = insert(root, low, high, val);
	}

	private Node insert(Node r, low l, low h, Value v){
		Node temp = r;
		while(temp!=null){
			int cmp = compare(l, temp.low);
			if(cmp < 0){ 
				temp.left = insert(temp.left, l, h, v);
				if(isRed(temp.left) && isRed(temp.left.left)) {
					temp = rotateRight(temp);
					temp = flipColor(temp);
				}
				return temp;
			}
			else if(cmp > 0){
				temp.right = insert(temp.right, l, h, v);
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

		temp = new Node(l, h, v);
		return temp;
	}

	public Value get(low k){
		Node temp = root;
		while(temp!=null){
			int cmp = compare(k, temp.low);
			if(cmp < 0)
				temp = temp.left;
			else if(cmp > 0)
				temp = temp.right;
			else
				return temp.value;
		}
		return null;
	}


	public boolean contains(low low){
		Node temp = root;
		while(temp!=null){
			int cmp = compare(low, temp.low);
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


	//		public void displayLevelOrder(){
	//			System.out.println("--------LEVEL ORDER--------");
	//			List l = new List(root);
	//			displayLevelOrder(l);
	//			
	//		}
	//	
	//		private Node displayLevelOrder(List rt){
	//			if( rt.n == null) return null;
	//			List new_rt;
	//			while(rt!=null){
	//				Node r = rt.n;
	//
	//				if(compare(r.low, root.low) == 0){
	//					System.out.println(r.low + ":" +r.value + " *ROOT* ");
	//				}else if(r.color==RED){
	//					System.out.println("RED --> "+ r.low + ":" +r.value);
	//				}
	//				else{
	//					System.out.println(r.low + ":" +r.value);
	//				}
	//
	//				rt = rt.next;
	//			}
	//			
	//			return null;
	//		}
	//	
	//		private void add(Node x, List l){
	//
	//		}

	private void printStyle(Node r){
		if(compare(r.low, root.low) == 0){
			System.out.println("(" +r.low + ", " + r.high + ")" + " : " +r.value + " *ROOT* ");
		}else if(r.color==RED){
			System.out.println("RED --> (" +r.low + ", " + r.high + ") : " +r.value);
		}
		else{
			System.out.println("(" +r.low + ", " + r.high + ")" + " : " +r.value);
		}
	}
	private void displayInOrder(Node r){
		if(r == null) return;
		printStyle(r);
		displayInOrder(r.left);
		displayInOrder(r.right);
	}

	private void display(Node r){
		if(r==null) return;
		display(r.left);
		printStyle(r);
		display(r.right);
	}


	public int compare(low a, low b){
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
