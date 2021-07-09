package com.bridgelabz.Utility;

public class Utility {
	
/*------------------------ linked list methods ------------------------*/
	private static LinkedListNode head;
	
	public static class LinkedListNode {
		private int data;
		private LinkedListNode next;
		public LinkedListNode(int data) {
			this.data = data;
			this.next = null;
		}
	}

	//method to print linked list
	 public void printLinkedList() {
	     LinkedListNode currNode = head;
	     System.out.print("LinkedList: ");
	     while (currNode != null) {
	         System.out.print(currNode.data + "-->");
	         currNode = currNode.next;
	     }
	     System.out.println(currNode);
	 }
	 
	//method to insert between linked list
	 public void insertBetweenLinkedList(int position, int data) {
		 LinkedListNode currentNode = head;
		 LinkedListNode newNode = new LinkedListNode(data);
		 
		 while(currentNode.data != position) {
			 System.out.println(currentNode.data);
			 currentNode = currentNode.next;
		 }
		 newNode.next  = currentNode.next;
		 currentNode.next = newNode;
	 }
	 
	//method to append to linked list
	 public void appendList(int data) {
		 LinkedListNode newNode = new LinkedListNode(data);
		 newNode.next = null;
		 
		 if(head == null) 
			 head = newNode;
		 else {
			 LinkedListNode currentNode = head;
			 while(currentNode.next != null) {
				 currentNode = currentNode.next;
			 }
			 currentNode.next = newNode;
		 }
	 }
	 
	//method to pop from linked list
	 public int popLinkedList() {
		 int result = head.data;
		 LinkedListNode currentNode = head.next;
		 head.next = null;
		 head = currentNode;
		 return result;
	 }
	
/*------------------------ Stack methods ------------------------*/
	 
	 private StackNode top = null;
		private int length = 0;
		
		private class StackNode{
			private int data;
			private StackNode next;
		
			public StackNode(int data) {
				this.data = data;
			}
		}
		
		// -------method to get length of stack-------------
		public int getLen() {
			return length;
		}
		
		// -------method to check if stack is empty-------------
		public boolean isEmpty() {
			return length == 0;
		}
		
		// -------method to push data in stack-------------
		public void push (int data) {
			StackNode item = new StackNode(data);
			item.next = top;
			top = item;
			length++;
		}
		
		// -------method to peak data from stack-------------
		private int peek() {
			return top.data;
		}
		
		// -------method to pop data from stack-------------
		public int pop() {
			int result = top.data;
			top = top.next;
			length--;
			return result;
		}
		
		// -------method to print data from stack-------------
		public void printStack() {
			if(isEmpty()) {
				return;
			}
			int ele = peek();
			System.out.print(ele+"-->");
			pop();
			printStack();
			push(ele);
		}
}

