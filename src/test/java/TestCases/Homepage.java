package TestCases;

import base.Base;
import common.CommonTask;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class Homepage extends Base {
    @BeforeClass
    public static void start() {
        setup();
    }

    @Test
    public void test1() {
        String var = System.getProperty("param");
        System.out.println(var);
        CommonTask.navigateTo(driver, "https://google.com");

//        assertEquals("cool", "ABC", var);
        assertEquals("cool", "ABC", "ABC");
    }

    @Test
    public void test2() {
        Base.driver.get("https://facebook.com");
        assertTrue("cool2", true);
    }

    @AfterClass
    public static void end() {
        closeOut();
    }
}
