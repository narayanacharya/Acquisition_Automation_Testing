package TestCases;

import base.Base;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class SecondPage extends Base {

    @BeforeClass
    public static void start() {
        setup();
    }

    @Test
    public void test1() {
        Base.driver.get("https://facebook.com");
        assertTrue("cool 123", true);
    }

    @Test
    public void test2() {
        Base.driver.get("https://facebook.com");
        assertTrue("cool 123", true);
    }

    @AfterClass
    public static void end() {
       closeOut();
    }
}
