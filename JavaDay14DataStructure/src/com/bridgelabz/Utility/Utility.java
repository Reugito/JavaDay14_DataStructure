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

	//----------method to print linked list----------
	 public void printLinkedList() {
	     LinkedListNode currNode = head;
	     System.out.print("LinkedList: ");
	     while (currNode != null) {
	         System.out.print(currNode.data + "-->");
	         currNode = currNode.next;
	     }
	     System.out.println(currNode);
	 }
	 
	//---------method to insert between linked list-------------
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
	 
	//------------method to append to linked list------------
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
	 
	//--------------method to pop from linked list------------
	 public int popLinkedList() {
		 int result = head.data;
		 LinkedListNode currentNode = head.next;
		 head.next = null;
		 head = currentNode;
		 return result;
	 }
	 
	 //-------pop last element from linked list --------
	 public int popLast() {
		 LinkedListNode currentNode = head;
		while(currentNode.next.next != null) {
			currentNode = currentNode.next;
		}
		int lastNodeData = currentNode.next.data;
		currentNode.next = null;
		 return lastNodeData;
	 }
	 
	 //------ search element from linked list -------
	 public boolean searchLinkedList(int data) {
		 LinkedListNode currentNode = head;
		 while(currentNode.data != data) {
			 currentNode = currentNode.next;
		 }
		 if(currentNode.data == data)
			return true;
		 return false;
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
		public int peek() {
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
		
		// -------method to search element from stack-------------
		public boolean searchStack(int data) {
	        StackNode node = top;
	        while (node != null){
	            if(node.data == data)
	            	return true;
	            node = node.next;
	        }
	        return false;
	    }
		
/*------------------------ Queue methods ------------------------*/
		private QueueNode rear = null;
		private QueueNode front = null;
		private int qlength = 0;
			
		private class QueueNode{
			private int data;
			private QueueNode next;
			private QueueNode previous;
			public QueueNode(int data) {
				this.data = data;
			}
		}
		
		// -------method to get length of queue-------------
		public int getQLen() {
			return qlength;
		}
				
		// -------method to check if queue is empty-------------
		public boolean isQEmpty() {
			return qlength == 0;
		}
		
		// -------method to add element in queue -------------
		public void enQueue(int data) {
			 QueueNode newNode = new QueueNode(data);
			 if(front == null) {
				 newNode.next = rear;
				 rear = newNode ;
				 front = newNode;
			 }
			 else {
				QueueNode currentNode = rear;
				while(currentNode.next != null) {
					 currentNode = currentNode.next;
				 }
				 currentNode.next = newNode;
				 rear = currentNode;
			 }
			 qlength++;
		 }
		
		// ----------print all elements queue -----
		public void printQueue() {
	        QueueNode node = front;
	        while (node != null){
	        	System.out.print(node.data+"<--");
	            node = node.next;
	        }
	    }
		
		// ----------remove data from queue -----
		public int deQueue() {
			int result = front.data;
			QueueNode currentNode = front.next;
			 front.next = null;
			 front = currentNode;
			rear = rear.next;
			qlength--;
			return result;
		}
		
		// ----------search elements queue -----
		public boolean searchQueue(int data) {
			QueueNode node = front;
			while (node.data != data){
				node = node.next;
			}
			if(node.data == data)
				return true;
			return false;
		}
		
		/*------------------------ HashTable methods ------------------------*/
		
		public int size = 0;
		int noOfBuckets = 10;
		int n;
		private HashNode [] bucket = new HashNode[noOfBuckets];
		
		public class HashNode{
			Integer key;
			String value;
			HashNode next;
			public HashNode(Integer key, String value ) {
				this.key = key;
				this.value = value;
			}
		}
		
		//---------- method to insert values in hash table -----------
		public void put(Integer key, String value) {
			if(key == null || value == null)
				throw new IllegalArgumentException("key or value are null");
			int index = getIndex(key);
			HashNode head = bucket[index];
			while(head != null) {    // check existing node value in hash table
				if(head.key.equals(key)) {
					head.value = value;
					return;
				}
				head = head.next;
			}
			size++;
			head = bucket[index];
			HashNode node = new HashNode(key, value);
			node.next = head;
			bucket[index] = node;
		}
		
		//---------- method to get hash table  index -----------
		public int getIndex(Integer key) {
			return key % noOfBuckets;
		}
		
		//---------- method to search value in hash table -----------
		public String getValue(Integer key) {
			int index = getIndex(key);
			HashNode head = bucket[index];
			while(head != null) {    // check existing node value in hash table
				if(head.key.equals(key)) {
					return head.value;
				}
				head = head.next;
			}
			return null;
		}
		
		//---------- method to print  hash table values -----------
		public void printHashTable() {
			for(HashNode i : bucket) {
				if(i != null)
					while( i.next != null) {
						System.out.println(i.value);
						i = i.next;
					}
			}
		}
		
		
/*------------------------ Binary Search Tree methods ------------------------*/
		class BSTNode
		{
			int key;
			BSTNode left, right;

			public BSTNode(int item)
			{
				key = item;
				left = right = null;
			}
		}
		
		BSTNode root;
		
		//------------method to insert data in tree------------
		public void insert(int key)
		{
			root = insertRec(root, key);
		}

		//------------method to insert data in tree------------
		BSTNode insertRec(BSTNode root, int key)
		{

			if (root == null)
			{
				root = new BSTNode(key);
				return root;
			}

			if (key < root.key)
				root.left = insertRec(root.left, key);
			else if (key > root.key)
				root.right = insertRec(root.right, key);
			return root;
		}

	//------------method to print sorted data from tree------------
		public void inorder()
		{
			inorderRec(root);
		}

		void inorderRec(BSTNode root)
		{
			if (root != null) {
				inorderRec(root.left);
				System.out.println(root.key);
				inorderRec(root.right);
			}
		}
}

