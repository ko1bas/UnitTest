package org.kolbas.modules.first;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.kolbas.common.interfaces.StringConvertable;

/**
 * @author Колбсов П.А.
 *
 */


/**
 * Тестирует функцию convert() класса FirstModule.
 *
 */
public class TestConvert extends Assert {

	@Test(expected = NullPointerException.class)
	public void testIsNullInput() {

		StringConvertable module = new FirstModule();
		String input = null;
		String res = module.convert(input);
	}

	@Test
	public void testIsEmptyInput() {
		StringConvertable module = new FirstModule();
		String input = "";
		String res = module.convert(input);
		assertEquals(res, "");
	}
	
	
	@Test
	public void testIsOneWordInput() {
		StringConvertable module = new FirstModule();
		String input = "OneWord";
		String res = module.convert(input);
		assertEquals(res, input);
	}
	
	@Test
	public void testIsTwoWordInput() {
		StringConvertable module = new FirstModule();
		String input = "OneWord TwoWord";
		String res = module.convert(input);
		assertEquals(res, "OneWord ");
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
		String res = module.convert(input);
		assertEquals(res, "OneWord ,,");
	}
	
	@Test
	public void testIsSentenseInput() {
		StringConvertable module = new FirstModule();
		String input = "мама мыла раму, а папа пил боржоми.";
		String res = module.convert(input);
		assertEquals(res, "мама  раму,  папа  боржоми.");
	}

}
