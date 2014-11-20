package org.kolbas.modules.first;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * @author Колбсов П.А.
 *
 */


/**
 * Проверил, как работает @Suite.
 *
 */
@Suite.SuiteClasses({ TestConvert.class, TestGetDeletedStrings.class })
@RunWith(Suite.class)
public class TestSuite {

}
