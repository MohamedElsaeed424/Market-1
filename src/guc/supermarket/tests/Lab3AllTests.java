package guc.supermarket.tests;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import org.junit.Test;

import static org.junit.Assert.*;
import guc.supermarket.products.Beverage;
import guc.supermarket.products.DairyProduct;
import guc.supermarket.products.Drinkable;
import guc.supermarket.products.Fat;
import guc.supermarket.products.GroceryProduct;
import guc.supermarket.products.SugarLevel;

public class Lab3AllTests {
	
	
	//------------------------------------Test Interface----------------------------------------------------------------------
	
	@Test(timeout = 1000)
	    public final void testInterface() {
			
			assertEquals("Drinkable should be an Interface", 1537, Drinkable.class.getModifiers());
		
			Drinkable drink= new Beverage("Pepsi", 5, 0, SugarLevel.ADDED_SUGAR);
			Drinkable drink2= new Beverage("Pure Apple", 5, 0, SugarLevel.NO_ADDED_SUGAR);
			Drinkable drink3= new Beverage("Sprite", 5, 0, SugarLevel.LIGHT);
			Drinkable drink4= new Beverage("Pepsi", 5, 0, SugarLevel.ZERO);
		    assertFalse("A drink with added sugar is unhealthy", drink.isHealthy());
		    assertTrue("A drink with no sugar is healthy", drink2.isHealthy());
		    assertTrue("A drink with light sugar level is healthy", drink3.isHealthy());
		    assertTrue("A drink with zero sugar level is healthy", drink4.isHealthy());
	    }
	
	//--------------------------------------------Helper methods----------------------------------------------------------
	public static boolean containsMethod(Class c, String name, Class[] parameters){
		try{
			c.getDeclaredMethod(name, parameters);
			return true;
		}
		catch(NoSuchMethodException e){
			return false;
		}
	}
}
