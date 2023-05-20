package guc.supermarket.people;

import guc.supermarket.cart.Cart;
import guc.supermarket.exceptions.IncorrectFatTypeException;
import guc.supermarket.exceptions.IncorrectSugarLevelException;
import guc.supermarket.products.GroceryProduct;
import guc.supermarket.products.Beverage;
import guc.supermarket.products.DairyProduct;
import guc.supermarket.products.Fat;
import guc.supermarket.products.SugarLevel;

public class Customer {

	private String name;
	private Cart myCart;
	private Fat preferableFatLevel;
	private SugarLevel preferableSugarLevel;

	public Customer(String name, Cart myCart, Fat preferableFatLevel, SugarLevel preferableSugarLevel) {
		this.name = name;
		this.myCart = myCart;
		this.preferableFatLevel = preferableFatLevel;
		this.preferableSugarLevel = preferableSugarLevel;
	}

	public Customer(String name, Cart cart) {

		this.name = name;
		this.myCart = cart;

	}

	public Fat getPreferableFatLevel() {
		return preferableFatLevel;
	}

	public SugarLevel getPreferableSugarLevel() {
		return preferableSugarLevel;
	}

	public void buy(GroceryProduct p) throws IncorrectFatTypeException, IncorrectSugarLevelException {

		if (p instanceof DairyProduct) {
			DairyProduct D = (DairyProduct) p;
			if (!(D.getFat().equals(getPreferableFatLevel()))) {
				throw new IncorrectFatTypeException("Not preferable fat level");
			}
		} else if (p instanceof Beverage) {
			Beverage D = (Beverage) p;
			if (!(D.getSugarLevel().equals(getPreferableSugarLevel()))) {
				throw new IncorrectSugarLevelException("Not preferable sugar level");
			}
		}

		System.out.println(this.name + " bought " + p.getName() + ".");
		myCart.addProduct(p);

	}
}
