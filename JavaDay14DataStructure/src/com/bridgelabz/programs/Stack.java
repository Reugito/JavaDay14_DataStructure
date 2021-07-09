package com.bridgelabz.programs;

import com.bridgelabz.Utility.Utility;

public class Stack {
		public static void main(String[] args) {
			Utility utility = new Utility();
			utility.push(10);
			utility.push(30);
			utility.push(80);
			utility.push(770);
			utility.push(90);
			utility.push(60);
			utility.printStack();
			utility.pop();
			System.out.println("\n After pop operation");
			utility.printStack();
	}


}

/* public void printStack() {
        StackNode node = top;
        while (node != null){
            System.out.println( node.data);
            node = node.next;
        }
    }*/
