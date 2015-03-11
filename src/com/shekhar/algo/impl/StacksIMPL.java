package com.shekhar.algo.impl;

import com.shekhar.algo.StacksArray;
import com.shekhar.algo.StacksString;

public class StacksIMPL {

	public static void main(String[] args) {
		StacksString s  = new StacksString();
		System.out.println("starting!!");
		for(int i=0; i< args.length; i++){
			if(args[i].equals("-")){
				System.out.print(s.pop() + " ");
			}
			else{
				s.push(args[i]);
			}
		}
		System.out.println();

		
		StacksArray sa = new StacksArray();
		System.out.println("starting again!!");
		for(int i=0; i< args.length; i++){
			if(args[i].equals("-")){
				System.out.print(sa.pop() + " ");
			}
			else{
				sa.push(args[i]);
			}
		}
		System.out.println();

	}
}
