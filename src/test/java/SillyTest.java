/*
 * This file contains JUnit test cases for Silly.java
 *
 * You should NOT modify this file! When you push Silly.java to
 * GitHub, it should run these tests. You can see the results in the
 * "Actions" tab of your repository.
 */

import org.junit.*;

import static org.junit.Assert.*;

import java.io.*;

public class SillyTest {
    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    public String[] getMainOutput() {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        // action
        Silly.main(null);

        System.setOut(originalOut);

        return bos.toString().split("\n");
    }

    @Test(timeout = 100)
    public void testTask1() {
        Silly sample = new Silly("a", "b");
        assertEquals("ab", sample.name);

        Silly sample2 = new Silly("first", "second");
        assertEquals("firstsecond", sample2.name);

        Silly sample3 = new Silly("", "Silly");
        assertEquals("Silly", sample3.name);

        Silly sample4 = new Silly ("123", "---");
        assertEquals("123---", sample4.name);
    }

    @Test(timeout = 50)
    public void testTask2() {
        String[] output = getMainOutput();

        // assertion
        assertEquals("The countStatic calls will return [0, 1, 2, 3]", output[3].strip());
    }

    @Test(timeout = 50)
    public void testTask3() {
        Silly a = new Silly(1);
        Silly b = new Silly(3);
        Silly c = new Silly("my name");
        Silly d = new Silly(" ");

        assertEquals("Silly #1", a.toString());
        assertEquals("Silly #3", b.toString());
        assertEquals("my name", c.toString());
        assertEquals(" ",d.toString());
    }

    @Test(timeout = 50)
    public void testTask4() {
        Silly a = new Silly(1);
        Silly b = new Silly("Silly #1");
        Silly c = new Silly("my name");
        Silly d = new Silly("my name");

        assertTrue(a.equals(b));
        assertTrue(b.equals(a));
        assertFalse(c.equals(a));
        assertFalse(c.equals(b));
        assertTrue(c.equals(d));
    }

    @Test(timeout = 100)
    public void testTask5() {
        Silly base = new Silly(1);
        Silly equal = new Silly("Silly #1");
        Silly shorter = new Silly("short");
        Silly longer = new Silly("very very very long");
        Silly equal2 = new Silly("Silly #2");

        assertTrue(base.compareTo(equal) == 0);
        assertTrue(base.compareTo(shorter) > 0);
        assertTrue(base.compareTo(longer) < 0);

        assertTrue(base.compareTo(equal2) == 0);
        assertTrue(equal.compareTo(equal2) == 0);
        assertTrue(equal2.compareTo(shorter) > 0);
        assertTrue(shorter.compareTo(longer) < 0);

    }
}
