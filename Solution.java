package com;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		System.out.println("Welcome to XYZ departmentalstore");
		System.out.println("---------------------------------");

		Scanner scan=new Scanner(System.in);
		//Upcasting to Achieve Abstraction
		DepartmentalStore store=new DepartmentalStoreImpl();

		store.addProduct();//add only once
		int choice=1;
		while(choice==1) {
			store.displayProduct();
			store.buyProduct();
			System.out.println("Press 1 to continue or any other number to checkout");
			choice=scan.nextInt();
		}
		store.checkout();//checkout only once
	}
}
