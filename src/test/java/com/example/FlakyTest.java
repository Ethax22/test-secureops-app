package com.example;

import org.junit.Test;
import static org.junit.Assert.*;

public class FlakyTest {
    @Test
    public void reliableTest() {
        assertTrue(true);
    }

    @Test
    public void flakyTest() {
        int random = new java.util.Random().nextInt(3);
        if (random == 0) {
            fail("Flaky test failed!");
        }
    }
}
