package com.shekhar.algo.w5p2;


public class OIBST<Key extends Comparable<Key>, Value> {

	Node root =null;

	public final boolean RED = true;
	public final boolean BLACK = false;

	class Node{
		Key low, high;
		Value value;
		Node left, right;
		boolean color;
		int lenght;


		@SuppressWarnings("unchecked")
		Node(Integer low ,Integer high, Value value){
			this.low = (Key) low;
			this.high = (Key) high;
			this.value = value;
			this.color = RED;
			this.lenght = (Integer)high-low;
		}
	}

	public void put(Key low, Key high, Value val){
		if(val==null) {
			System.out.println("Invalid entry!");
			return;
		}
		System.out.println("trying to put (" + low + ", " + high + ") : "+ val);
		root = insert(root, low, high, val);
	}

	private Node insert(Node r, Key l, Key h, Value v){
		Node temp = r;
		while(temp!=null){
			int cmp = compare(l, temp.low);
			if(cmp < 0){ 
				temp.left = insert(temp.left, l, h, v);
				temp.lenght = Math.max(temp.lenght, temp.left.lenght);
				if(isRed(temp.left) && isRed(temp.left.left)) {
					temp = rotateRight(temp);
					temp = flipColor(temp);
				}
				return temp;
			}
			else if(cmp > 0){
				temp.right = insert(temp.right, l, h, v);
				temp.lenght = Math.max(temp.lenght, temp.right.lenght);
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

		temp = new Node((Integer)l, (Integer)h, v);
		return temp;
	}

	public Value get(Key k){
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


	public boolean intersects(Key low, Key high){
		Node temp = root;
		while(temp!=null){
			int cmplowlow = compare(low, temp.low);
			int cmplowhigh = compare(high, temp.low);
			if(cmplowlow < 0 && cmplowhigh > 0){
				return true;
			}else if(cmplowlow > 0 && cmplowhigh <0){
				return true;
			}else if(cmplowhigh <0 && cmplowlow < 0){
				return true;
			}else if(cmplowhigh < 0 ){
				temp = temp.left;
			}else{
				temp = temp.right;
			}

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

	private void printStyle(Node r){
		if(compare(r.low, root.low) == 0){
			System.out.println("(" +r.low + ", " + r.high + ")" + " : " +r.value + "(" + r.lenght + ")" +" *ROOT* ");
		}else if(r.color==RED){
			System.out.println("(" +r.low + ", " + r.high + ") : " +r.value+ "(" + r.lenght + ")" + " <-- RED");
		}
		else{
			System.out.println("(" +r.low + ", " + r.high + ")" + " : " +r.value+ "(" + r.lenght + ")");
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

	class ListNode{
		Node node;
		ListNode next;
		
		ListNode(Node m){
			this.node = m;
		}
	}
	
	ListNode listRoot = new ListNode(root);
	
	public void displayLevelOrder(){
		System.out.println("--------LEVEL ORDER--------");
		ListNode listRoot = new ListNode(root);
		displayLevelOrder(listRoot);
		System.out.println("--------LEVEL ORDER--------");
	}

	private Node displayLevelOrder(ListNode rt){
		ListNode t = rt;
		System.out.println("Size of this tree is " + size(rt));
		ListNode new_list = null;
		if(t==null) return null;
		while(t!=null){
			if(t.node!=null){
				printStyle(t.node);
				new_list = add(t.node.left, new_list);
				new_list = add(t.node.right, new_list);
			}
			t = t.next;
		}
		displayLevelOrder(new_list);
		return null;
	}

	private ListNode add(Node x, ListNode head){
		if(x==null) return head;
		ListNode temp = new ListNode(x);
		if(head==null){
			head = temp;
		}else{
			ListNode t2 = head;
			while(t2.next!=null){
				t2 = t2.next;
			}
			t2.next = temp;
		}
		
		return head;		
	}
	
	private int size(ListNode head){
		int count =0;
		ListNode temp = head;
		
		while(temp!=null){
			temp = temp.next;
			count++;
		}
		
		return count;
	}
}
