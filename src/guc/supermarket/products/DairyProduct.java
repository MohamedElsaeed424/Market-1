	package guc.supermarket.products;

public class DairyProduct extends GroceryProduct {

	private Fat fat;

	public DairyProduct(String name, double price, double discount, Fat fat) {
		super(name, price, discount);
		this.fat = fat;
	}
	

	public  Fat getFat() {
		return fat;
	}

	public void setFat(Fat fat) {
		this.fat = fat;
	}

	 public boolean equals(Object o) {
		 if (o instanceof Beverage )	 {
			 return false ;
		 }
		 DairyProduct p = (DairyProduct) o ;
			return ( super.equals(o) && this.fat.equals(p.fat) );	
	 }
	 
	 public boolean refrigerate() {
		 return true ;
	 }


	public String toString() {
		return super.toString()+
	    "Fat Level:"+this.fat;
	}
	

	public static void main (String [] args) {
		GroceryProduct p1 = new DairyProduct("Milk", 100, 50, Fat.FULLCREAM) ;
		DairyProduct p2 = new DairyProduct("Milk", 100, 50, Fat.FULLCREAM) ;
		System.out.println(p1 );
		System.out.println(p2 );
		System.out.println( p1.equals(p2) );
	}


}
