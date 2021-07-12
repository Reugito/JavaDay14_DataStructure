package com.bridgelabz.programs;

import com.bridgelabz.Utility.Utility;

public class HashTable {
	
	public static void main(String[] args) {
		Utility utility = new Utility();
		utility.put(10, "hii");
		utility.put(20, "hii everyone");
		utility.put(40, "hello");
		utility.put(50, "hii Rao");
		System.out.println("size of HashTable: "+utility.size);
		System.out.println("get value of "+10+"from table: "+ utility.getValue(10));
		utility.printHashTable();
	}

}
