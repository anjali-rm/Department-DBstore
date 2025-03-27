package com;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class DepartmentalStoreImpl implements DepartmentalStore {
	//key-> Product Id -> Integer & value -> Product Instance -> Product
	Map<Integer,Product> db=new LinkedHashMap<Integer,Product>();
	Scanner sc=new Scanner(System.in);
	int totalBill=0;

	@Override
	public void addProduct() {
		db.put(1, new Product("chocolates",10,5));
		db.put(2, new Product("Biscuits",20,10));
		db.put(3, new Product("IceCream",30,20));
	}
	@Override
	public void displayProduct() {
		Set<Integer> keys=db.keySet();//1 2 3
		for(int key:keys) {
			Product p=db.get(key);
			System.out.println("Enter "+key+" to order "+p.getName());
			System.out.println("Available Quantity is "+p.getQuantity());
			System.out.println("Cost: Rs."+p.getCost());
			System.out.println("--------------------------------");
		}
	}
	@Override
	public void buyProduct() {
		System.out.println("Enter choice: ");//choice -> key
		int choice=sc.nextInt();//1

		//get() return null, when the key(choice) is not present
		Product p=db.get(choice);//getting the product based on choice
		//		System.out.println(p);

		if(p!=null) {
			//logic for buying
			System.out.println("Buying "+p.getName());

			System.out.println("Enter the Quantity: ");
			int quantity=sc.nextInt();

			if(quantity <= p.getQuantity()) {
				//calculating the current product cost
				int productCost=quantity * p.getCost();

				//Adding the current productCost to totalBill
				totalBill=totalBill+productCost;

				//Updating the new quantity
				p.setQuantity(p.getQuantity()-quantity);

				System.out.println("Ordered "+p.getName());

				System.out.println("Current ProductCost is Rs."+productCost);

				System.out.println("Total Bill as of now:Rs."+totalBill);

			}
			else {
				try {
					String message="Invalid Quantity "+p.getName()+" not available";
					throw new InvalidQuantityException(message);
				}
				catch(Exception e) {
					System.out.println(e.getMessage());
				}
			}
		}
		else {
			try {
				String message="Invalid choice!, Kindly enter valid choice";
				throw new InvalidChoiceException(message);
			}
			catch(Exception e){
				System.out.println(e.getMessage());
			}
		}

	}
	@Override
	public void checkout() {
		System.out.println("TotalBill: Rs."+totalBill);
		System.out.println("ThankYou! for Shopping");

	}
}
