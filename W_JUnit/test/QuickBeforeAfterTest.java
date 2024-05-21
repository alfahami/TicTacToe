package test;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class QuickBeforeAfterTest {

    @BeforeClass
    public static void beforeClass() {
        System.out.println("Before Calss");
    }
    
    @Before
    public void setup() {
        System.out.println("Before Test");
    }

    @Test
    public void test() {
        System.out.println("test 1 executed");
    }

    @Test
    public void test2() {
        System.out.println("test2 executed");
    }

    @After
    public void teardown() {
        System.out.println("After executed");
    }
}
