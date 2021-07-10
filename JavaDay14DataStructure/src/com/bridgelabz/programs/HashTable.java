package com.bridgelabz.programs;

public class HashTable {
	private HashNode [] bucket;
	int size, noOfBuckets;
	int n;
	public HashTable(){
		this(10);  // or this.noOfBuckets = capacity;
	}
	
	public HashTable(int capacity) {
		this.noOfBuckets = capacity;
		this.bucket = new HashNode[noOfBuckets];
		this.size = 0;
	}

	public class HashNode{
		Integer key;
		String value;
		HashNode next;
		public HashNode(Integer key, String value ) {
			this.key = key;
			this.value = value;
		}
	}
	
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
	
	public int getIndex(Integer key) {
		return key % noOfBuckets;
	}
	
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
	
	public void printHashTable() {
		for(HashNode i : bucket) {
			if(i != null)
				while( i.next != null) {
					System.out.println(i.value);
					i = i.next;
				}
		}
	}
	
	public static void main(String[] args) {
		HashTable obj = new HashTable();
		obj.put(10, "hii");
		obj.put(20, "hii Rao");
		obj.put(10, "hii Rao");
		System.out.println("size of HashTable: "+obj.size);
		System.out.println("get value of "+10+"from table: "+ obj.getValue(10));
		obj.printHashTable();
	}

}
