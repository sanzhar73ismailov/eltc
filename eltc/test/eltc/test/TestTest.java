package eltc.test;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestTest {

    private static final Logger LOGGER = Logger.getLogger(TestTest.class.getName());

    public TestTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        try {
            eltc.logger.MyLogger.setup(".");
        } catch (IOException ex) {
            LOGGER.log(Level.SEVERE, null, ex);
        }
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of main method, of class Test.
     */
    @Test
    public void testMain() throws Exception {
        System.out.println("test");

        if (1 == 0) {
            fail("The test case is a prototype.");
        }

        Thread th = new Thread(new MyThreadClass());
        th.start();

        assertTrue(1 == 1);
    }

}
