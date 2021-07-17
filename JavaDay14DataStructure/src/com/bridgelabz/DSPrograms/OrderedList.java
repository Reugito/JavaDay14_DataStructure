package com.bridgelabz.DSPrograms;

import java.util.Scanner;

import com.bridgelabz.DSUtility.Utility;

public class OrderedList {

	public static void main(String[] args) {
		Utility utility = new Utility();
		Scanner sc = new Scanner(System.in);
		utility.readIntegerFromFile();
		utility.sortList();
		utility.printLinkedList();
	}

}
