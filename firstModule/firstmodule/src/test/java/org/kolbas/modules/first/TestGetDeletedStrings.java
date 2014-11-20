package org.kolbas.modules.first;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.kolbas.common.interfaces.StringConvertable;

/**
 * @author Колбсов П.А.
 *
 */

/**
 * Тестирует функцию getDeletedStrings() класса FirstModule.
 *
 */
public class TestGetDeletedStrings extends Assert {

	private static ArrayList<String> emptyArrayList;

	
	
	@Before
	public void initialize() {
		emptyArrayList = new ArrayList<String>();
	}

	@Test(expected = NullPointerException.class)
	public void testIsNullInput() {

		StringConvertable module = new FirstModule();
		String input = null;
		ArrayList<String> res = module.getDeletedStrings(input);
	}

	@Test
	public void testIsEmptyInput() {
		StringConvertable module = new FirstModule();
		String input = "";
		ArrayList<String> res = module.getDeletedStrings(input);
		assertEquals(res, emptyArrayList);
	}

	@Test
	public void testIsOneWordInput() {
		StringConvertable module = new FirstModule();
		String input = "OneWord";
		ArrayList<String> res = module.getDeletedStrings(input);
		assertEquals(res, emptyArrayList);
	}

	@Test
	public void testIsTwoWordInput() {

		StringConvertable module = new FirstModule();
		String input = "OneWord TwoWord";
		ArrayList<String> res = module.getDeletedStrings(input);

		ArrayList<String> trueRes = new ArrayList<String>();
		trueRes.add("TwoWord");

		assertEquals(res, trueRes);
	}

	
	
	/**
	 * Проверил, как работает @Ignore.
	 *
	 */
	@Test
	@Ignore
	public void testIsTwoWordWithSomeDelimetersInput() {
		StringConvertable module = new FirstModule();
		String input = "OneWord ,,TwoWord";

		ArrayList<String> res = module.getDeletedStrings(input);

		ArrayList<String> trueRes = new ArrayList<String>();
		trueRes.add("TwoWord");

		assertEquals(res, trueRes);
	}

	@Test
	public void testIsSentenseInput() {
		StringConvertable module = new FirstModule();
		String input = "мама мыла раму, а папа пил боржоми.";

		ArrayList<String> res = module.getDeletedStrings(input);

		ArrayList<String> trueRes = new ArrayList<String>();
		trueRes.add("мыла");
		trueRes.add("а");
		trueRes.add("пил");

		assertEquals(res, trueRes);
	}

}
