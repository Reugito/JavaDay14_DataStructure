package com.bridgelabz.programs;

import com.bridgelabz.Utility.Utility;
import java.io.*;

public class LinkedList {
 
 public static void main(String[] args)
 {
	 Utility utility = new Utility();
     
	 utility.appendList(56);
	 utility.appendList(30);
	 utility.appendList(70);
	 utility.printLinkedList();
	 System.out.println("pop from linked list --> "+utility.popLinkedList());
	 System.out.println("After pop operation");
	 utility.printLinkedList();
	 utility.insertBetweenLinkedList(30, 67);
	 System.out.println("After Inserting at specific positon");
	 utility.printLinkedList();
 }
}
