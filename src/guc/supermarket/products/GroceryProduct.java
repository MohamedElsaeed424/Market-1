package guc.supermarket.products;

 public abstract class GroceryProduct {

	private String name;
	private double price;
	private double discount;

	public GroceryProduct(String name, double price, double discount) {
		this.name = name;
		this.price = price;
		this.discount = discount;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public String getName() {
		return name;
	}

	void setName(String name) {
		this.name = name;
	}

	 public final double getActualPrice() {
		return (price - price * (discount / 100));
	}

	public boolean equals(Object o) {
		GroceryProduct p = (GroceryProduct) o;
		return this.name.equals(p.name)&&
				 this.price== p.price&&
				 this.discount== p.discount;
	}
	
	abstract public boolean refrigerate();

	public String toString() {
		return "Name: " + this.name + "\n" +
				"Price: " + this.price + " L.E." + "\n" +
				"Discount: " + this.discount+ "%"+"\n";
	}
	
	public static void main (String [] args) {
		GroceryProduct p1 = new DairyProduct("Milk", 100, 50, Fat.FULLCREAM) ;

		System.out.println(p1.equals(p1) );

	}

}
