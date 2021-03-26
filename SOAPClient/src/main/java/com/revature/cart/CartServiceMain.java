package com.revature.cart;

import java.util.Scanner;

public class CartServiceMain {
	
	public static void main(String[] args) {
		
		CartService_Service cart = new CartService_Service();
		
		CartService cartPort = cart.getCartServiceImplPort();
		
		Item item = new Item();
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter product ID: ");
		
		int id = Integer.parseInt(scan.nextLine()); 
		
		System.out.println("Enter product name: ");
		
		String name = scan.nextLine();
		
		System.out.println("Enter quantity to add: ");
		
		int quantity = Integer.parseInt(scan.nextLine());
		
		item.setItemID(id);
		item.setItemName(name);
		item.setQuantity(quantity);
		
		System.out.println("Output: " + cartPort.addItem(item));
		
	}

}
