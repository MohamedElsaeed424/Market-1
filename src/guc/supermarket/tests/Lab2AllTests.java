package guc.supermarket.tests;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

import static org.junit.Assert.*;
import guc.supermarket.products.*;

public class Lab2AllTests {

	String gPath = "guc.supermarket.products.GroceryProduct";
	String bPath = "guc.supermarket.products.Beverage";
	String dPath = "guc.supermarket.products.DairyProduct";

	@Test(timeout = 1000)
	public void testClassIsAbstractGroceryProduct()
			throws NoSuchMethodException {
		assertTrue(
				"No object should be instantiated from class groceryProducts",
				Modifier.isAbstract(GroceryProduct.class.getModifiers()));

	}

	

	@Test(timeout = 1000)
	public void testMethodBeverageGetActualPrice2() {

		try {
			Beverage.class.getDeclaredMethod("getActualPrice", double.class);
		} catch (NoSuchMethodException e) {
			fail("The overloaded method getTotal(double extra) should be implemented in the Beverage class.");
		}

	}

	@Test (timeout = 1000)
	public void testMethodBeverageGetActualPrice2Logic() {

		Beverage b = new Beverage("Schweppes Pomegranate", 10, 5,
				SugarLevel.ADDED_SUGAR);
		assertEquals(
				"The overloaded method getTotal(double extra) should calculate the price after adding the voucher's extra discount to the original dicount.",
				9, b.getActualPrice(5.0), 0.01);

		b = new Beverage("Schweppes Pomegranate", 20, 10,
				SugarLevel.ADDED_SUGAR);
		assertEquals(
				"The overloaded method getTotal(double extra) should calculate the price after adding the voucher's extra discount to the original dicount.",
				18, b.getActualPrice(0.0), 0.01);

	}

	@Test
	public void testMethodBeverageRefrigerate() throws Exception {

		Beverage.class.getDeclaredMethod("refrigerate");

	}

	@Test
	public void testMethodBeverageRefrigerateLogic() throws Exception {

		Beverage p = new Beverage("Schweppes Pomegranate", 10, 5,
				SugarLevel.ADDED_SUGAR);
		assertEquals("Beverages does not need to be kept in a refrigerator",
				false, p.refrigerate());

	}

	

	@Test
	public void testMethodDairyProductRefrigerate() throws Exception {

		DairyProduct.class.getDeclaredMethod("refrigerate");

	}

	@Test
	public void testMethodDairyProductRefrigerateLogic() throws Exception {

		DairyProduct p = new DairyProduct("Juhayna", 20, 5, Fat.FULLCREAM);
		assertEquals("Dairy products need to be kept in a refrigerator", true,
				p.refrigerate());

	}

	@Test
	public void testMethodGroceryProductRefrigerate() throws Exception {

		assertTrue(
				"A method that behaves completely differently in each subclass should be declared as abstract in the super class and implemented in each subclass.",
				Modifier.isAbstract(GroceryProduct.class.getMethod(
						"refrigerate", new Class[0]).getModifiers()));

	}
	@Test(timeout = 1000)
	public void testOverloading(){
		assertTrue("The method \"getActualPrice(int extra)\" should be declared in the Beverage class", containsMethod(Beverage.class, "getActualPrice",new Class[]{double.class}));
	}
	
	@Test//(timeout = 1000)
	public void testEqualsDairyProductPolymorphism()
	{
		DairyProduct milk1= new DairyProduct("Juhayna Milk", 10, 5, Fat.FULLCREAM);
		DairyProduct milk2= new DairyProduct("Juhayna Milk", 10, 5, Fat.FULLCREAM);
		DairyProduct milk3= new DairyProduct("Labanita", 10, 5, Fat.FULLCREAM);
		DairyProduct milk4= new DairyProduct("Juhayna Milk", 9, 5, Fat.FULLCREAM);
		DairyProduct milk5= new DairyProduct("Juhayna Milk", 9, 25, Fat.FULLCREAM);
		DairyProduct milk6= new DairyProduct("Juhayna Milk", 9, 25, Fat.SKIMMED);
		assertTrue("The two instances are equal", milk1.equals(milk2));
		assertFalse("The two instances are not equal, they have different names", milk1.equals(milk3));
		assertFalse("The two instances are not equal, they have different prices", milk1.equals(milk4));
		assertFalse("The two instances are not equal, they have different discounts", milk1.equals(milk5));
		assertFalse("The two instances are not equal, they have different fat levels", milk1.equals(milk6));
	}
	//equals -> Beverage
	//equals -> Dairy
	//private
	@Test(timeout = 1000)
	public void testEqualsBeveragePolymorphism()
	{
		assertTrue("The method \"equals\" should be declared in the GroceryProduct class", containsMethod(GroceryProduct.class, "equals", new Class[]{Object.class}));
		
		assertTrue("The method \"equals\" should be declared in the DairyProduct class", containsMethod(DairyProduct.class, "equals", new Class[]{Object.class}));
		
		assertTrue("The method \"equals\" should be declared in the Beverage class", containsMethod(Beverage.class, "equals", new Class[]{Object.class}));
		
		Beverage beverage1= new Beverage("Schweppes Pomegranate", 10, 5, SugarLevel.ADDED_SUGAR);
		Beverage beverage2= new Beverage("Schweppes Pomegranate", 10, 5, SugarLevel.ADDED_SUGAR);
		Beverage beverage3= new Beverage("Sprite", 10, 5, SugarLevel.ADDED_SUGAR);
		Beverage beverage4= new Beverage("Schweppes Pomegranate", 9, 5, SugarLevel.ADDED_SUGAR);
		Beverage beverage5= new Beverage("Schweppes Pomegranate", 9, 25, SugarLevel.ADDED_SUGAR);
		Beverage beverage6= new Beverage("Schweppes Pomegranate", 9, 25, SugarLevel.ADDED_SUGAR);
		assertTrue("The two instances are equal", beverage1.equals(beverage2));
		assertFalse("The two instances are not equal, they have different names", beverage1.equals(beverage3));
		assertFalse("The two instances are not equal, they have different prices", beverage1.equals(beverage4));
		assertFalse("The two instances are not equal, they have different discounts", beverage1.equals(beverage5));
		assertFalse("The two instances are not equal, they have different fat levels", beverage1.equals(beverage6));
	}
	//equals -> diff types
	//private
	@Test(timeout = 1000)
	public void testEqualsPolymorphism()
	{
		DairyProduct milk= new DairyProduct("Juhayna Milk", 10, 5, Fat.FULLCREAM);
		Beverage beverage= new Beverage("Schweppes Pomegranate", 10, 5, SugarLevel.ADDED_SUGAR);
		assertFalse("When comparing different types of grocery products, the method should return false with no exception", milk.equals(beverage));		
		assertFalse("When comparing different types of grocery products, the method should return false with no exception", beverage.equals(milk));
	}
	
	// ===============================================Helpers

		@SuppressWarnings("rawtypes")
		private void testInstanceVariablesArePresent(Class aClass, String varName,
				boolean implementedVar) throws SecurityException {

			boolean thrown = false;
			try {
				aClass.getDeclaredField(varName);
			} catch (NoSuchFieldException e) {
				thrown = true;
			}
			if (implementedVar) {
				assertFalse("There should be " + varName
						+ " instance variable in class " + aClass.getName(), thrown);
			} else {
				assertTrue("There should not be " + varName
						+ " instance variable in class " + aClass.getName()
						+ ", it should be inherited from the super class", thrown);
			}
		}

		@SuppressWarnings("rawtypes")
		private void testInstanceVariableIsPrivate(Class aClass, String varName)
				throws NoSuchFieldException, SecurityException {
			Field f = aClass.getDeclaredField(varName);
			assertEquals(
					varName + " instance variable in class " + aClass.getName()
							+ " should not be accessed outside that class", 2,
					f.getModifiers());
		}

		@SuppressWarnings({ "unchecked", "rawtypes" })
		private void testGetterMethodExistsInClass(Class aClass, String methodName,
				Class returnedType) {
			Method m = null;
			boolean found = true;
			try {
				m = aClass.getDeclaredMethod(methodName);
			} catch (NoSuchMethodException e) {
				found = false;
			}
			String varName = methodName.substring(3).toLowerCase();
			assertTrue(
					"The " + varName + " instance variable in class "
							+ aClass.getName() + " is a READ variable.", found);
			assertTrue("incorrect return type for " + methodName + " method in "
					+ aClass.getName() + " class.", m.getReturnType()
					.isAssignableFrom(returnedType));
		}

		@SuppressWarnings({ "rawtypes", "unchecked" })
		private void testSetterMethodExistsInClass(Class aClass, String methodName,
				Class inputType, boolean writeVariable) {

			Method[] methods = aClass.getDeclaredMethods();
			String varName = methodName.substring(3).toLowerCase();
			if (writeVariable) {
				assertTrue("The " + varName + " instance variable in class "
						+ aClass.getName() + " is a WRITE variable.",
						containsMethodName(methods, methodName));
			} else {
				assertFalse("The " + varName + " instance variable in class "
						+ aClass.getName() + " is a READ ONLY variable.",
						containsMethodName(methods, methodName));
				return;
			}
			Method m = null;
			boolean found = true;
			try {
				m = aClass.getDeclaredMethod(methodName, inputType);
			} catch (NoSuchMethodException e) {
				found = false;
			}

			assertTrue(aClass.getName() + " class should have " + methodName
					+ " method that takes one " + inputType.getSimpleName()
					+ " parameter", found);

			assertTrue("incorrect return type for " + methodName + " method in "
					+ aClass.getName() + ".", m.getReturnType().equals(Void.TYPE));

		}

		private static boolean containsMethodName(Method[] methods, String name) {
			for (Method method : methods) {
				if (method.getName().equals(name))
					return true;
			}
			return false;
		}
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