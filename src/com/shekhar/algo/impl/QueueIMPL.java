package com.shekhar.algo.impl;

import com.shekhar.algo.*;

public class QueueIMPL {

	public static void main(String[] args) {
		QueuesLinkedList<String> qu = new QueuesLinkedList<String>();
		//QueuesArray qu = new QueuesArray();
		qu.enqueue("A");
		qu.enqueue("B");
		qu.enqueue("C");
		System.out.println(qu.dequeue());
		System.out.println(qu.dequeue());
		System.out.println(qu.dequeue());
		System.out.println(qu.dequeue());
		System.out.println(qu.dequeue());
		qu.enqueue("X");
		qu.enqueue("Zero");
		qu.enqueue("F");
		System.out.println(qu.dequeue());
		System.out.println(qu.dequeue());

	}

}
