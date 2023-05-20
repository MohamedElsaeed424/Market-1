package guc.supermarket.products;

public class Beverage extends GroceryProduct implements Drinkable {

	private SugarLevel sugarLevel;

	public Beverage(String name, double price, double discount, SugarLevel sugarLevel) {
		super(name, price, discount);
		this.sugarLevel = sugarLevel;
	}

	public SugarLevel getSugarLevel() {
		return sugarLevel;
	}

	public void setSugarLevel(SugarLevel sugarLevel) {
		this.sugarLevel = sugarLevel;
	}

	public boolean equals(Object o) {
		if (o instanceof DairyProduct) {
			return false;
		}
		Beverage p = (Beverage) o;
		return (super.equals(o) && this.sugarLevel.equals(p.sugarLevel));
	}

	public double getActualPrice(double extra) {
		double price = this.getPrice();
		double discount = this.getDiscount();
		return (price - (price * ((discount + extra) / 100)));
	}

	public boolean refrigerate() {
		return false;
	}

	public String toString() {
		return super.toString() + "Sugar Level:" + this.sugarLevel;
	}

	public boolean isHealthy() {

		return (!(this.sugarLevel.equals(sugarLevel.ADDED_SUGAR)));
	}

	public static void main(String[] args) {
		Beverage b = new Beverage("Juhayna Milk", 10, 5, SugarLevel.LIGHT);
		Beverage b2 = new Beverage("Juhayna Milk", 10, 5, SugarLevel.ADDED_SUGAR);
		System.out.println(b.equals(b2));
	}

}
