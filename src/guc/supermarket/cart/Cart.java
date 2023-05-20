package guc.supermarket.cart;


import java.util.ArrayList;

import guc.supermarket.products.GroceryProduct;

public class Cart {
	private ArrayList<GroceryProduct> products;

	public ArrayList<GroceryProduct> getProducts() {
		return products;
	}
	
	public Cart() {
		products = new ArrayList<>();
	}
	
	public void addProduct(GroceryProduct p) {
		products.add(p);
	}
	
	public double getTotal(){
		double total=0.0;
		for(int i=0; i<products.size();i++) {
			total += products.get(i).getActualPrice();
		}
		return total;
	}
	
	public String toString(){
		String s= "";
		for (int i =0;i<products.size();i++){
			s+= products.get(i).toString()+"\n--------------------\n";
			
		}
		
		return s;
	}
	
	
	
}
