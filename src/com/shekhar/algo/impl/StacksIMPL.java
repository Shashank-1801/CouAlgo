package com.shekhar.algo.impl;

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
			//s.display();
		}
	}
}
